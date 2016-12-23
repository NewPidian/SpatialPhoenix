package deparser;

import entity.GeometryColumnsEntity;
import execute.SpatialPhoenixResultSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/23
 */
public class SelectDeparser extends SpatialSqlDeparser {

    public SpatialPhoenixResultSet deparser(ResultSet rs) throws SQLException {
        return (SpatialPhoenixResultSet) rs;
    }

    @Override
    public SpatialPhoenixResultSet deparser(ResultSet rs, List<GeometryColumnsEntity> list) throws SQLException {
        return (SpatialPhoenixResultSet) rs;
    }
}
