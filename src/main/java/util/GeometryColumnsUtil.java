package util;

import entity.GeometryColumnsEntity;

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
public class GeometryColumnsUtil {
    /**
     * 获取一个表的所有空间列信息
     *
     * @return
     */
    public static List<GeometryColumnsEntity> getEntityByTableName(String tableName, Connection connection) throws SQLException {
        String sql = "select * from mz_geometry_column where f_table_name= '" + tableName + "'";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<GeometryColumnsEntity> list = new ArrayList<GeometryColumnsEntity>();
        while (rs.next()) {
            GeometryColumnsEntity entity = new GeometryColumnsEntity();
            entity.setId(rs.getInt("id"));
            entity.setSrid(rs.getInt("srid"));
            entity.setCoordinateDimension(rs.getInt("coordinate_dimension"));
            entity.setGeometryColumn(rs.getString("f_geometry_column"));
            entity.setTableName(rs.getString("f_table_name"));
            entity.setType(rs.getString("type"));
            list.add(entity);
        }
        return list;
    }
}
