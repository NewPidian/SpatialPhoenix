package geometry.convert;

import com.vividsolutions.jts.geom.*;
import geometry.convert.wkbconvert.PhoenixWKBReader;
import geometry.convert.wkbconvert.PhoenixWKBWriter;
import geometry.convert.wktconvert.PhoenixWKTReader;
import geometry.convert.wktconvert.PhoenixWKTWriter;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/20
 */
public class ConvertMain {
    public static void main(String[] args) throws Exception {
        GeometryFactory factory = new GeometryFactory(new PrecisionModel(10), 1234);
        Coordinate[] coordinates = new Coordinate[10];
        for (int i = 0; i < 10; i++) {
            coordinates[i] = new Coordinate(i, i + 1);
        }
        LineString lineString = factory.createLineString(coordinates);


        PhoenixWKBWriter phoenixWKBWriter = new PhoenixWKBWriter();
        PhoenixWKBReader phoenixWKBReader = new PhoenixWKBReader();
        byte[] phoenixBytes = phoenixWKBWriter.write(lineString);
        LineString phoenixLineString = (LineString) phoenixWKBReader.read(phoenixBytes);
        System.out.println(phoenixLineString.getEnvelopeInternal() + "  " + phoenixLineString.getNumPoints() + " " + phoenixLineString.getSRID());


        PhoenixWKTReader reader = new PhoenixWKTReader();
        PhoenixWKTWriter writer = new PhoenixWKTWriter();
        String geomStr = writer.write(lineString);
        phoenixLineString = (LineString) reader.read(geomStr);
        System.out.println(phoenixLineString.getEnvelopeInternal() + "  " + phoenixLineString.getNumPoints() + " " + phoenixLineString.getSRID());
    }
}
