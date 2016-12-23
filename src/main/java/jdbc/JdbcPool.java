package jdbc;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

/*
 * 数据库连接池
 */
public class JdbcPool implements DataSource {
	private static LinkedList<Connection> connList = new LinkedList<Connection>();
	static
	{
		InputStream input = JdbcPool.class.getClassLoader().getResourceAsStream("jdbc-config.properties");
		Properties properties = new Properties();
		try
		{
			properties.load(input);
			String driver = properties.getProperty("driver");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String url = properties.getProperty("url");
			int connSize = Integer.parseInt(properties.getProperty("initialConnectSize"));
			Class.forName(driver);
			for(int i = 0;i < connSize;i++)
			{
				Connection conn = DriverManager.getConnection(url);
//				Connection conn = DriverManager.getConnection(url, username, password);
				connList.add(conn);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

    /**
     * 获取数据库连接，利用对数据库连接的代理进行处理
     * @return
     * @throws SQLException
     */
	public Connection getConnection() throws SQLException {
		if(connList.size() > 0)
		{
			final Connection conn = connList.removeFirst();
			return (Connection)Proxy.newProxyInstance(
					JdbcPool.class.getClassLoader(),
					new Class[]{Connection.class}, 
					new InvocationHandler() {
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
						{
							if(!method.getName().equals("close"))
								return method.invoke(conn, args);
							else
							{
								connList.add(conn);
								return null;
							}
						}
					});
		}
		else
			throw new RuntimeException("对不起，数据库忙");
	}
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}
	public int getLoginTimeout() throws SQLException {
		return 0;
	}
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
	public void setLogWriter(PrintWriter arg0) throws SQLException {}
	public void setLoginTimeout(int arg0) throws SQLException {}
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		return false;
	}
	public <T> T unwrap(Class<T> cls) throws SQLException {
		return null;
	}
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		return null;
	}
}
