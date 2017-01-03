package execute;

import jdbc.JdbcPool;
import net.sf.jsqlparser.JSQLParserException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/23
 * <p>
 * String sql="CREATE TABLE geometry_column ( " +
 * "id INTEGER NOT  NULL PRIMARY KEY ," +
 * "f_table_name VARCHAR(20) ," +
 * "f_geometry_column VARCHAR(20)  ," +
 * "type VARCHAR(20) ," +
 * "coordinate_dimension INTEGER   ," +
 * "srid INTEGER )";
 */
public class ExecuteMain {
    public static void main(String[] args) throws SQLException, JSQLParserException {
        JdbcPool jdbcPool = new JdbcPool();
        Connection conn = jdbcPool.getConnection();

        SpatialPhoenixStatement statement = new SpatialPhoenixStatement();
//        String sql = "UPSERT INTO MZ_GEOMETRY_COLUMN ( id ,f_table_name,f_geometry_column,type,coordinate_dimension,srid) VALUES (1,'hello','geometry','point',1,23)";
        String sql = "create table mz_highways (mykey integer not null primary key, mycolumn point)";

        statement.executeCreate(sql, conn);
    }
}
