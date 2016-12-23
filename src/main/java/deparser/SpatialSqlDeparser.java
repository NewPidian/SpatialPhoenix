package deparser;

import entity.GeometryColumnsEntity;
import execute.SpatialPhoenixResultSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/22
 */
public abstract class SpatialSqlDeparser {
    public  abstract SpatialPhoenixResultSet deparser(ResultSet rs, List<GeometryColumnsEntity> list) throws SQLException;
}
