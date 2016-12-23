package geometry.convert.wktconvert;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTWriter;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/21
 */
public class PhoenixWKTWriter extends WKTWriter {
    public PhoenixWKTWriter() {
        super();
    }

    @Override
    public String write(Geometry geometry) {
        int SRID = geometry.getSRID();
        String classType = geometry.getGeometryType();
        Envelope envelope = geometry.getEnvelopeInternal();
        double minx = envelope.getMinX();
        double miny = envelope.getMinY();
        double maxx = envelope.getMaxX();
        double maxy = envelope.getMaxY();
        String geometryStr = super.write(geometry);
        int length = geometryStr.length();
        StringBuffer sb = new StringBuffer();
        sb.append("start&");
        sb.append(SRID + "&");
        sb.append(classType + "&");
        sb.append(minx + "&");
        sb.append(miny + "&");
        sb.append(maxx + "&");
        sb.append(maxy + "&");
        sb.append(length + "&");
        sb.append(geometryStr + "&");
        sb.append("end");
        return sb.toString();
    }
}
