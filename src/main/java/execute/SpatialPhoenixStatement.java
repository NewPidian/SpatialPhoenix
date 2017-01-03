package execute;

import deparser.SelectDeparser;
import deparser.SpatialSqlDeparser;
import entity.GeometryColumnsEntity;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import parser.CreateTableParser;
import parser.SelectParser;
import parser.SpatialSqlParser;
import parser.UpsertParser;
import util.DBUtil;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/22
 */
public class SpatialPhoenixStatement {

    public SpatialPhoenixStatement() {

    }


    /**
     * 执行查询
     *
     * @param statement
     * @param connection
     * @return
     * @throws JSQLParserException
     * @throws SQLException
     */
    public SpatialPhoenixResultSet executeQuery(String statement, Connection connection) throws JSQLParserException, SQLException {
        /**
         * 解析的时候将获取元数据信息
         */
        SpatialSqlParser parser = new SelectParser();
        SpatialSqlDeparser deparser = new SelectDeparser();
        List<GeometryColumnsEntity> list = new ArrayList<>();
        String phoenixSql = parser.parse(statement, connection, list);
        ResultSet resultSet = executeQueryPhoenixSql(phoenixSql, connection);
        SpatialPhoenixResultSet spatialPhoenixResultSet = deparser.deparser(resultSet, list);
        DBUtil.closeConnection(connection);
        return spatialPhoenixResultSet;
    }

    /**
     * 执行CreateTable（如CreateTable）
     * 建表，改Geometry类型为VARCHAR(8000)
     * 更新，Geometry_Column表
     *
     * @param statement
     * @return
     * @throws SQLException
     */
    public int executeCreate(String statement, Connection connection) throws SQLException, JSQLParserException {
        int res = 0;
        try {
            connection.setAutoCommit(false);
            SpatialSqlParser parser = new CreateTableParser();
            List<GeometryColumnsEntity> entities = new ArrayList<>();
            String phoenixSql = parser.parse(statement, connection, entities);
            res = executePhoenixSql(phoenixSql, connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw new SQLException(e);
        }
        return res;
    }

    /**
     * 执行Upsert（如Upsert）
     *
     * @param statement
     * @return
     * @throws SQLException
     */
    public boolean executeUpsert(String statement, Connection conn) throws SQLException, JSQLParserException {
        conn.setAutoCommit(true);
        SpatialSqlParser parser = new UpsertParser();
        List<GeometryColumnsEntity> entities = new ArrayList<>();
        String phoenixSql = parser.parse(statement, conn, entities);
        
        return false;
    }


    private ResultSet executeQueryPhoenixSql(String phoenixSql, Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        ResultSet rs = null;
        Statement statement = connection.createStatement();
        try {
            rs = statement.executeQuery(phoenixSql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(statement);
        }
        return rs;
    }

    private int executePhoenixSql(String phoenixSql, Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        int rs = 0;
        Statement statement = connection.createStatement();
        try {
            rs = statement.executeUpdate(phoenixSql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(statement);
        }
        return rs;
    }


}
