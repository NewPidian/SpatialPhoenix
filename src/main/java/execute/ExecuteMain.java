package execute;

import jdbc.JdbcPool;
import net.sf.jsqlparser.JSQLParserException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/23
 */
public class ExecuteMain {
    public static void main(String[] args) throws SQLException, JSQLParserException {
        JdbcPool jdbcPool = new JdbcPool();
        Connection conn = jdbcPool.getConnection();

        SpatialPhoenixStatement statement = new SpatialPhoenixStatement();
        String sql = "CREATE TABLE NewHighWays (" +
                "PK_UID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PK_UID_X0 INTEGER  DEFAULTVALUE='100' NOT NULL," +
                "Geometry POINT NOT NULL);";
        statement.executeCreate(sql, conn);
    }
}
