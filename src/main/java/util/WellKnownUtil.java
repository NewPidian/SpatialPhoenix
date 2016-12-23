package util;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;

import static util.ByteUtil.bytesToInt;
import static util.ByteUtil.intToBytes;

/**
 * 文件描述：字节数据添加/删除长度头
 * 作者： bamboo
 * 时间： 2016/12/20
 */
public class WellKnownUtil {
    /**
     * 根据前4个字节求几何数据字节数组
     *
     * @param phoenixGeometryBytes
     * @return
     * @throws ParseException
     */
    public static byte[] getGeometryBytes(byte[] phoenixGeometryBytes) throws ParseException {
        int length = bytesToInt(phoenixGeometryBytes, 0);
        if (phoenixGeometryBytes.length - 4 != length)
            throw new ParseException("bytes length error:" + phoenixGeometryBytes.length + "-" + 4 + "!=" + length);
        byte[] geometry = new byte[length];
        System.arraycopy(phoenixGeometryBytes, 4, geometry, 0, length);
        return geometry;
    }


    /**
     * Geometry字符数组解析成(length+Geometry)字节数组)
     *
     * @param geometryBytes
     * @return
     */
    public static byte[] writeToPhoenixGeometry(byte[] geometryBytes) {
        /**Geometry对象字节数组长度*/
        int length = geometryBytes.length;
        byte[] bytes = new byte[length + 4];
        byte[] lengthByte = intToBytes(length);
        System.arraycopy(lengthByte, 0, bytes, 0, 4);
        System.arraycopy(geometryBytes, 0, bytes, 4, geometryBytes.length);
        return bytes;
    }


    /**
     * 获取Geometry的ClassType
     * @param geometry
     * @return
     * @throws ParseException
     */
    public static int getClassType(Geometry geometry) throws ParseException {
        if (geometry instanceof Point) {
            return 1;
        } else if (geometry instanceof LineString) {
            return 2;
        } else if (geometry instanceof Polygon) {
            return 3;
        } else if (geometry instanceof MultiPoint) {
            return 4;
        } else if (geometry instanceof MultiLineString) {
            return 5;
        } else if (geometry instanceof MultiPolygon) {
            return 6;
        } else if (geometry instanceof GeometryCollection) {
            return 7;
        }else {
            throw new ParseException("Unknown Geometry Class Type");
        }
    }
}
