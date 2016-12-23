package execute;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import geometry.convert.wktconvert.PhoenixWKTReader;
import org.apache.phoenix.compile.RowProjector;
import org.apache.phoenix.iterate.ResultIterator;
import org.apache.phoenix.jdbc.PhoenixResultSet;

import java.io.StringReader;
import java.sql.SQLException;

/**
 * 文件描述：空间结果集的实现
 * 主要添加 getGeometry方法。
 * 作者： bamboo
 * 时间： 2016/12/22
 */
public class SpatialPhoenixResultSet extends PhoenixResultSet {
    public SpatialPhoenixResultSet(ResultIterator resultIterator, RowProjector rowProjector, org.apache.phoenix.jdbc.PhoenixStatement statement) throws SQLException {
        super(resultIterator, rowProjector, statement);
    }

    /**
     * 只用到WKT格式的
     *
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    public Geometry getGeometry(int columnIndex) throws SQLException, ParseException {
        String geometryStr = getString(columnIndex);
        return new PhoenixWKTReader().read(new StringReader(geometryStr));
    }

    /**
     * 只用到WKT格式的
     *
     * @param columnLabel
     * @return
     * @throws SQLException
     */
    public Geometry getGeometry(String columnLabel) throws SQLException, ParseException {
        String geometryStr = getString(columnLabel);
        return new PhoenixWKTReader().read(new StringReader(geometryStr));
    }

}
