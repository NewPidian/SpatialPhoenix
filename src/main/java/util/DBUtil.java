package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/23
 */
public class DBUtil {

    /**
     * 关闭connection
     *
     * @param connection
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭statement
     *
     * @param statement
     */
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
