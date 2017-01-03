package execute;


import jdbc.JdbcPool;

import java.sql.Connection;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/30
 */
public class SpatialPhoenixStatementTest {
    private static JdbcPool jdbcPool = new JdbcPool();

    @org.junit.Test
    public void executeQuery() throws Exception {
        Connection conn = jdbcPool.getConnection();
        SpatialPhoenixStatement statement = new SpatialPhoenixStatement();
    }

    @org.junit.Test
    public void executeCreate() throws Exception {
        Connection conn = jdbcPool.getConnection();
        SpatialPhoenixStatement statement = new SpatialPhoenixStatement();
        String sql = "create table mz_highways (mykey integer not null primary key, mycolumn point)";
        statement.executeCreate(sql, conn);
    }

    @org.junit.Test
    public void executeUpsert() throws Exception {
        Connection conn = jdbcPool.getConnection();
        SpatialPhoenixStatement statement = new SpatialPhoenixStatement();
        String sql = "upsert into mz_highways values('abc-asdas','point(1,2)')";
        statement.executeUpsert(sql, conn);
    }

}