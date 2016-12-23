package geometry.convert;

import java.io.IOException;
import java.util.Properties;

/**
 * 文件描述：Binary配置常量
 * 作者： bamboo
 * 时间： 2016/12/19
 */
public class ConfigConstant {
    private static Properties config;

    static {
        config = new Properties();
        try {
            config.load(ConfigConstant.class.getClassLoader().getResourceAsStream("spatial.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**
         * 几何类型CLASS_TYPE信息
         */
        SPATIAL_PHOENIX_POINT = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_POINT"));
        SPATIAL_PHOENIX_LINESTRING = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_LINESTRING"));
        SPATIAL_PHOENIX_POLYGON = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_POLYGON"));
        SPATIAL_PHOENIX_MULTIPOINT = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MULTIPOINT"));
        SPATIAL_PHOENIX_MULTILINESTRING = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MULTILINESTRING"));
        SPATIAL_PHOENIX_MULTIPOLYGON = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MULTIPOLYGON"));
        SPATIAL_PHOENIX_GEOMETRYCOLLECTION = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_GEOMETRYCOLLECTION"));


        /**
         *  BLOB存储格式
         */
        SPATIAL_PHOENIX_START_FROM = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_START_FROM"));
        SPATIAL_PHOENIX_START_LENGTH = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_START_LENGTH"));
        SPATIAL_PHOENIX_ENDIAN_FROM = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_ENDIAN_FROM"));
        SPATIAL_PHOENIX_ENDIAN_LENGTH = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_ENDIAN_LENGTH"));
        SPATIAL_PHOENIX_SRID_FROM = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_SRID_FROM"));
        SPATIAL_PHOENIX_SRID_LENGTH = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_SRID_LENGTH"));
        SPATIAL_PHOENIX_MBR_MIN_X_FROM = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MBR_MIN_X_FROM"));
        SPATIAL_PHOENIX_MBR_MIN_X_LENGTH = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MBR_MIN_X_LENGTH"));
        SPATIAL_PHOENIX_MBR_MIN_Y_FROM = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MBR_MIN_Y_FROM"));
        SPATIAL_PHOENIX_MBR_MIN_Y_LENGTH = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MBR_MIN_Y_LENGTH"));
        SPATIAL_PHOENIX_MBR_MAX_X_FROM = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MBR_MAX_X_FROM"));
        SPATIAL_PHOENIX_MBR_MAX_X_LENGTH = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MBR_MAX_X_LENGTH"));
        SPATIAL_PHOENIX_MBR_MAX_Y_FROM = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MBR_MAX_Y_FROM"));
        SPATIAL_PHOENIX_MBR_MAX_Y_LENGTH = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MBR_MAX_Y_LENGTH"));
        SPATIAL_PHOENIX_MBR_END_FROM = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MBR_END_FROM"));
        SPATIAL_PHOENIX_MBR_END_LENGTH = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_MBR_END_LENGTH"));
        SPATIAL_PHOENIX_CLASS_TYPE_FROM = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_CLASS_TYPE_FROM"));
        SPATIAL_PHOENIX_CLASS_TYPE_LENGTH = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_CLASS_TYPE_LENGTH"));
        SPATIAL_PHOENIX_GEOMETRY_FROM = Integer.parseInt(config.getProperty("SPATIAL_PHOENIX_GEOMETRY_FROM"));


        /**
         * 几何类型具体内部格式
         */

        POINT_X_COORDINATE_LENGTH = Integer.parseInt(config.getProperty("POINT_X_COORDINATE_LENGTH"));
        POINT_Y_COORDINATE_LENGTH = Integer.parseInt(config.getProperty("POINT_Y_COORDINATE_LENGTH"));
        LINESTRING_NUMBER_OF_POINTS_LENGTH = Integer.parseInt(config.getProperty("LINESTRING_NUMBER_OF_POINTS_LENGTH"));
        POLYGON_NUMBER_OF_LINESTRINGS_LENGTH = Integer.parseInt(config.getProperty("POLYGON_NUMBER_OF_LINESTRINGS_LENGTH"));
        MULTIPOINT_NUMBER_OF_POINTS_LENGTH = Integer.parseInt(config.getProperty("MULTIPOINT_NUMBER_OF_POINTS_LENGTH"));
        MULTILINSTRING_NUMBER_OF_LINESTRINGS_LENGTH = Integer.parseInt(config.getProperty("MULTILINSTRING_NUMBER_OF_LINESTRINGS_LENGTH"));
        MULTIPOLYGON_NUMBER_OF_POLYGONS_LENGTH = Integer.parseInt(config.getProperty("MULTIPOLYGON_NUMBER_OF_POLYGONS_LENGTH"));
        GEOMETRYCOLLECTION_NUMBER_OF_ENTITIES_LENGTH = Integer.parseInt(config.getProperty("GEOMETRYCOLLECTION_NUMBER_OF_ENTITIES_LENGTH"));
        COLLECTION_START_FROM = Integer.parseInt(config.getProperty("COLLECTION_START_FROM"));
        COLLECTION_START_LENGTH = Integer.parseInt(config.getProperty("COLLECTION_START_LENGTH"));

//        COLLECTION_START = Byte.parseByte(config.getProperty("COLLECTION_START"));

        COLLECTION_CLASS_TYPE_FROM = Integer.parseInt(config.getProperty("COLLECTION_CLASS_TYPE_FROM"));
        COLLECTION_CLASS_TYPE_LENGTH = Integer.parseInt(config.getProperty("COLLECTION_CLASS_TYPE_LENGTH"));
        COLLECTION_CLASS_TYPE_POINT = Integer.parseInt(config.getProperty("COLLECTION_CLASS_TYPE_POINT"));
        COLLECTION_CLASS_TYPE_LINESTRING = Integer.parseInt(config.getProperty("COLLECTION_CLASS_TYPE_LINESTRING"));
        COLLECTION_CLASS_TYPE_POLYGON = Integer.parseInt(config.getProperty("COLLECTION_CLASS_TYPE_POLYGON"));
        COLLECTION_GEOMETRY_FROM = Integer.parseInt(config.getProperty("COLLECTION_GEOMETRY_FROM"));

        PHOENIX_REST_LENGTH = Integer.parseInt(config.getProperty("PHOENIX_REST_LENGTH"));


        /**
         *    WKT格式的定义
         */
        WKT_START_INDEX = Integer.parseInt(config.getProperty("WKT_START_INDEX"));
        WKT_SRID_INDEX = Integer.parseInt(config.getProperty("WKT_SRID_INDEX"));
        WKT_CLASSTYPE_INDEX = Integer.parseInt(config.getProperty("WKT_CLASSTYPE_INDEX"));
        WKT_MBR_MINX_INDEX = Integer.parseInt(config.getProperty("WKT_MBR_MINX_INDEX"));
        WKT_MBR_MINY_INDEX = Integer.parseInt(config.getProperty("WKT_MBR_MINY_INDEX"));
        WKT_MBR_MAXX_INDEX = Integer.parseInt(config.getProperty("WKT_MBR_MAXX_INDEX"));
        WKT_MBR_MAXY_INDEX = Integer.parseInt(config.getProperty("WKT_MBR_MAXY_INDEX"));
        WKT_GEOMETRY_LENGTH_INDEX = Integer.parseInt(config.getProperty("WKT_GEOMETRY_LENGTH_INDEX"));
        WKT_GEOMETRY_CONTENT_INDEX = Integer.parseInt(config.getProperty("WKT_GEOMETRY_CONTENT_INDEX"));
        WKT_END_INDEX = Integer.parseInt(config.getProperty("WKT_END_INDEX"));
        WKT_LENGTH = Integer.parseInt(config.getProperty("WKT_LENGTH"));

    }

    /**
     * 几何类型CLASS_TYPE信息
     */
    public static int SPATIAL_PHOENIX_POINT;
    public static int SPATIAL_PHOENIX_LINESTRING;
    public static int SPATIAL_PHOENIX_POLYGON;
    public static int SPATIAL_PHOENIX_MULTIPOINT;
    public static int SPATIAL_PHOENIX_MULTILINESTRING;
    public static int SPATIAL_PHOENIX_MULTIPOLYGON;
    public static int SPATIAL_PHOENIX_GEOMETRYCOLLECTION;

    /**
     * 位标识符
     */
    public static byte GEOMETRY_START = (byte) (0x00);
    public static byte GEOMETRY_BIG_ENDIAN = (byte) (0x00);
    public static byte GEOMETRY_LITTLE_ENDIAN = (byte) (0x01);
    public static byte GEOMETRY_MBR_END = (byte) (0x7C);
    public static byte GEOMETRY_END = (byte) (0xFE);


    /**
     * BLOB存储格式
     */
    public static int SPATIAL_PHOENIX_START_FROM;
    public static int SPATIAL_PHOENIX_START_LENGTH;
    public static int SPATIAL_PHOENIX_ENDIAN_FROM;
    public static int SPATIAL_PHOENIX_ENDIAN_LENGTH;
    public static int SPATIAL_PHOENIX_SRID_FROM;
    public static int SPATIAL_PHOENIX_SRID_LENGTH;
    public static int SPATIAL_PHOENIX_MBR_MIN_X_FROM;
    public static int SPATIAL_PHOENIX_MBR_MIN_X_LENGTH;
    public static int SPATIAL_PHOENIX_MBR_MIN_Y_FROM;
    public static int SPATIAL_PHOENIX_MBR_MIN_Y_LENGTH;
    public static int SPATIAL_PHOENIX_MBR_MAX_X_FROM;
    public static int SPATIAL_PHOENIX_MBR_MAX_X_LENGTH;
    public static int SPATIAL_PHOENIX_MBR_MAX_Y_FROM;
    public static int SPATIAL_PHOENIX_MBR_MAX_Y_LENGTH;
    public static int SPATIAL_PHOENIX_MBR_END_FROM;
    public static int SPATIAL_PHOENIX_MBR_END_LENGTH;
    public static int SPATIAL_PHOENIX_CLASS_TYPE_FROM;
    public static int SPATIAL_PHOENIX_CLASS_TYPE_LENGTH;
    public static int SPATIAL_PHOENIX_GEOMETRY_FROM;

    /**
     * 几何类型具体内部格式
     */

    public static int POINT_X_COORDINATE_LENGTH;
    public static int POINT_Y_COORDINATE_LENGTH;
    public static int LINESTRING_NUMBER_OF_POINTS_LENGTH;
    public static int POLYGON_NUMBER_OF_LINESTRINGS_LENGTH;
    public static int MULTIPOINT_NUMBER_OF_POINTS_LENGTH;
    public static int MULTILINSTRING_NUMBER_OF_LINESTRINGS_LENGTH;
    public static int MULTIPOLYGON_NUMBER_OF_POLYGONS_LENGTH;
    public static int GEOMETRYCOLLECTION_NUMBER_OF_ENTITIES_LENGTH;
    public static int COLLECTION_START_FROM;
    public static int COLLECTION_START_LENGTH;
    public static byte COLLECTION_START = (byte) (0x69);
    public static int COLLECTION_CLASS_TYPE_FROM;
    public static int COLLECTION_CLASS_TYPE_LENGTH;
    public static int COLLECTION_CLASS_TYPE_POINT;
    public static int COLLECTION_CLASS_TYPE_LINESTRING;
    public static int COLLECTION_CLASS_TYPE_POLYGON;
    public static int COLLECTION_GEOMETRY_FROM;


    /**
     * 除了Geometry以外的所有数据长度
     */
    public static int PHOENIX_REST_LENGTH;


    /**
     * WKT格式的定义
     */
    public static int WKT_START_INDEX;
    public static int WKT_SRID_INDEX;
    public static int WKT_CLASSTYPE_INDEX;
    public static int WKT_MBR_MINX_INDEX;
    public static int WKT_MBR_MINY_INDEX;
    public static int WKT_MBR_MAXX_INDEX;
    public static int WKT_MBR_MAXY_INDEX;
    public static int WKT_GEOMETRY_LENGTH_INDEX;
    public static int WKT_GEOMETRY_CONTENT_INDEX;
    public static int WKT_END_INDEX;
    public static int WKT_LENGTH;
}
