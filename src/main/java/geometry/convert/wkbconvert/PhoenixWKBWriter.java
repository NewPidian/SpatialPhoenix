package geometry.convert.wkbconvert;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBWriter;
import geometry.convert.ConfigConstant;
import util.WellKnownUtil;
import util.ByteUtil;

/**
 * 文件描述：读取Geometry对象为字节数组
 * 作者： bamboo
 * 时间： 2016/12/21
 */
public class PhoenixWKBWriter extends WKBWriter {


    /**
     * 将Geometry转化为自定义格式的字节数组
     * @param geometry
     * @return
     */
    @Override
    public byte[] write(Geometry geometry) {
        byte[] geometryPhoenixBytes = WellKnownUtil.writeToPhoenixGeometry(super.write(geometry));
        int geometryPhoenixLength = geometryPhoenixBytes.length;
        byte[] phoenixBytes = new byte[geometryPhoenixLength + ConfigConstant.PHOENIX_REST_LENGTH];
        //init geometryBytes
        System.arraycopy(geometryPhoenixBytes, 0, phoenixBytes, ConfigConstant.SPATIAL_PHOENIX_GEOMETRY_FROM, geometryPhoenixLength);

        //init classType
        int classType = 0;
        try {
            classType = WellKnownUtil.getClassType(geometry);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        byte[] classTypeBytes = ByteUtil.intToBytes(classType);
        System.arraycopy(classTypeBytes, 0, phoenixBytes, ConfigConstant.SPATIAL_PHOENIX_CLASS_TYPE_FROM, ConfigConstant.SPATIAL_PHOENIX_CLASS_TYPE_LENGTH);

        //init basic
        phoenixBytes[0] = ConfigConstant.GEOMETRY_START;
        phoenixBytes[1] = ConfigConstant.GEOMETRY_LITTLE_ENDIAN;
        phoenixBytes[ConfigConstant.SPATIAL_PHOENIX_MBR_END_FROM] = ConfigConstant.GEOMETRY_MBR_END;
        phoenixBytes[phoenixBytes.length - 1] = (byte) 0xFE;

        //init SRID
        int SRID = geometry.getSRID();
        byte[] SRIDBytes = ByteUtil.intToBytes(SRID);
        System.arraycopy(SRIDBytes, 0, phoenixBytes, ConfigConstant.SPATIAL_PHOENIX_SRID_FROM, ConfigConstant.SPATIAL_PHOENIX_SRID_LENGTH);

        //init envelope
        Envelope envelope = geometry.getEnvelopeInternal();
        double minx = envelope.getMinX();
        double maxx = envelope.getMaxX();
        double miny = envelope.getMinY();
        double maxy = envelope.getMaxY();

        byte[] minxBytes = ByteUtil.doubleToByteArray(minx);
        byte[] maxxBytes = ByteUtil.doubleToByteArray(maxx);
        byte[] minyBytes = ByteUtil.doubleToByteArray(miny);
        byte[] maxyBytes = ByteUtil.doubleToByteArray(maxy);
        System.arraycopy(minxBytes, 0, phoenixBytes, ConfigConstant.SPATIAL_PHOENIX_MBR_MIN_X_FROM, ConfigConstant.SPATIAL_PHOENIX_MBR_MIN_X_LENGTH);
        System.arraycopy(minyBytes, 0, phoenixBytes, ConfigConstant.SPATIAL_PHOENIX_MBR_MIN_Y_FROM, ConfigConstant.SPATIAL_PHOENIX_MBR_MIN_Y_LENGTH);
        System.arraycopy(maxxBytes, 0, phoenixBytes, ConfigConstant.SPATIAL_PHOENIX_MBR_MAX_X_FROM, ConfigConstant.SPATIAL_PHOENIX_MBR_MAX_X_LENGTH);
        System.arraycopy(maxyBytes, 0, phoenixBytes, ConfigConstant.SPATIAL_PHOENIX_MBR_MAX_Y_FROM, ConfigConstant.SPATIAL_PHOENIX_MBR_MAX_Y_LENGTH);
        return phoenixBytes;
    }


    public PhoenixWKBWriter() {
        super();
    }


}
