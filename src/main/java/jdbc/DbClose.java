package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库资源关闭类
 */
public class DbClose {
	/**
	 * 关闭数据库连接
	 * @param conn 连接对象
	 */
	public static void close(Connection conn){
		if(conn != null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭会话对象函数
	 * @param stmt 会话对象
	 */
	public static void close(Statement stmt){
		if(stmt != null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭结果集函数
	 * @param result 结果集对象
	 */
	public static void close(ResultSet result){
		if(result != null){
			try{
				result.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * 同时关闭结果集、会话对象和数据库连接对象
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		close(rs);
		close(stmt,conn);
	}
	/**
	 * 同时关闭数据库连接对象和会话对象
	 * @param stmt
	 * @param conn
	 */
	public static void close(Statement stmt,Connection conn){
		close(stmt);
		close(conn);
	}
}
