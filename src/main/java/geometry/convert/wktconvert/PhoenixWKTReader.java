package geometry.convert.wktconvert;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import geometry.convert.ConfigConstant;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/21
 */
public class PhoenixWKTReader extends WKTReader {
    public PhoenixWKTReader() {
        super();
    }

    @Override
    public Geometry read(String phoenixWellKnownText) throws ParseException {
        String[] phoenixText = phoenixWellKnownText.split("&");
        if (phoenixText.length != ConfigConstant.WKT_LENGTH && !"start".equals(phoenixText[ConfigConstant.WKT_START_INDEX]) && !"end".equals(phoenixText[ConfigConstant.WKT_END_INDEX])) {
            throw new ParseException("phoenixWellKnownText:" + phoenixWellKnownText + " data error!");
        }
        int length = Integer.parseInt(phoenixText[ConfigConstant.WKT_GEOMETRY_LENGTH_INDEX].trim());
        String geometryStr = phoenixText[ConfigConstant.WKT_GEOMETRY_CONTENT_INDEX].trim();
        if (length != geometryStr.length()) {
            throw new ParseException(geometryStr + "is not equal  pre length: " + length);
        }
        Geometry geometry = super.read(geometryStr);
        setMetaGeometryInfo(geometry, phoenixText);
        return geometry;
    }

    /**
     * 设置元数据信息
     *
     * @param geometry
     * @param phoenixText
     * @throws ParseException
     */
    private void setMetaGeometryInfo(Geometry geometry, String[] phoenixText) throws ParseException {
        if (phoenixText.length != ConfigConstant.WKT_LENGTH) throw new ParseException("data error");
        int SRID = Integer.parseInt(phoenixText[ConfigConstant.WKT_SRID_INDEX].trim());
        geometry.setSRID(SRID);
    }
}
