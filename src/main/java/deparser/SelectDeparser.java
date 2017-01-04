package deparser;

import entity.GeometryColumnsEntity;
import execute.SpatialPhoenixResultSet;
import org.apache.phoenix.jdbc.PhoenixResultSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/23
 */
public class SelectDeParser extends SpatialSqlDeParser {

    public SpatialPhoenixResultSet deParser(PhoenixResultSet rs) throws SQLException {
        return new SpatialPhoenixResultSet(rs);
    }

    @Override
    public SpatialPhoenixResultSet deParser(PhoenixResultSet rs, List<GeometryColumnsEntity> list) throws SQLException {
        return new SpatialPhoenixResultSet(rs);
    }
}
