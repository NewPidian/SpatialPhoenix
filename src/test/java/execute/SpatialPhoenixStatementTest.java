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
        String sql = "select * from mz_america";
        SpatialPhoenixResultSet rs = statement.executeQuery(sql, conn);
        while (rs.next()) {
            System.out.println(rs.getInt("mykey"));
            System.out.println(rs.getGeometry("mycolumn").getEnvelopeInternal());
        }
    }

    @org.junit.Test
    public void executeCreate() throws Exception {
        Connection conn = jdbcPool.getConnection();
        SpatialPhoenixStatement statement = new SpatialPhoenixStatement();
        String sql = "create table mz_america (mykey integer not null primary key, mycolumn polygon)";
        statement.executeCreate(sql, conn);
    }

    @org.junit.Test
    public void executeUpsert() throws Exception {
        Connection conn = jdbcPool.getConnection();
        SpatialPhoenixStatement statement = new SpatialPhoenixStatement();
        String sql = "upsert into mz_america values(12,'" +
                "Polygon ((10 10, 10 20, 20 20, 20 15, 10 10))')";
        statement.executeUpsert(sql, conn);
    }

}