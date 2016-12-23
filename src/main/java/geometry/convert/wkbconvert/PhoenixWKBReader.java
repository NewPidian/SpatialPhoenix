package geometry.convert.wkbconvert;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBReader;
import geometry.convert.ConfigConstant;

import static util.ByteUtil.bytesToInt;
import static util.WellKnownUtil.getGeometryBytes;

/**
 * 文件描述：读取字节数组转换为Geometry对象
 * 作者： bamboo
 * 时间： 2016/12/21
 */
public class PhoenixWKBReader extends WKBReader {
    public PhoenixWKBReader() {
        super();
    }

    public PhoenixWKBReader(GeometryFactory geometryFactory) {
        super(geometryFactory);
    }

    /**
     * 读取自定义字节数组转换为Geometry对象
     *
     * @param bytes
     * @return
     * @throws ParseException
     */
    @Override
    public Geometry read(byte[] bytes) throws ParseException {
        Geometry geometry = null;
        int length = bytesToInt(bytes, ConfigConstant.SPATIAL_PHOENIX_GEOMETRY_FROM);
        /**
         * 获取phoenixGeometryBytes数组
         * */
        byte[] phoenixGeometryBytes = new byte[length + 4];
        System.arraycopy(bytes, ConfigConstant.SPATIAL_PHOENIX_GEOMETRY_FROM, phoenixGeometryBytes, 0, length + 4);
        geometry = parseGeometry(phoenixGeometryBytes);
        setMetaGeometryInfo(geometry, bytes);
        return geometry;
    }

    /**
     * @param PhoenixGeometryBytes
     * @return 返回Geometry的子类对象
     * @throws ParseException
     */
    private <T extends Geometry> T parseGeometry(byte[] PhoenixGeometryBytes) throws ParseException {
        byte[] geometryBytes = getGeometryBytes(PhoenixGeometryBytes);
        return (T) super.read(geometryBytes);
    }


    /**
     * 设置元数据信息，如SRID，MBR值
     *
     * @param geometry
     * @param packet
     * @throws ParseException
     */
    private void setMetaGeometryInfo(Geometry geometry, byte[] packet) throws ParseException {
        int SRID = bytesToInt(packet, ConfigConstant.SPATIAL_PHOENIX_SRID_FROM);
        geometry.setSRID(SRID);
    }
}
