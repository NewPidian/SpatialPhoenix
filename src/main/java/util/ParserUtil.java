package util;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/21
 */
public class ParserUtil {

    /**
     * 判断列定义的数据类型是否为空间数据类型
     *
     * @param columnDefinition
     * @return
     */
    public static boolean isGeometryType(ColumnDefinition columnDefinition) {
        String dataType = columnDefinition.getColDataType().getDataType().toUpperCase();
        if ("GEOMETRY".equals(dataType)) return true;
        if ("POINT".equals(dataType)) return true;
        if ("LINESTRING".equals(dataType)) return true;
        if ("POLYGON".equals(dataType)) return true;
        if ("MULTIPOINT".equals(dataType)) return true;
        if ("MULTILINESTRING".equals(dataType)) return true;
        if ("MULTIPOLYGON".equals(dataType)) return true;
        if ("GEOMETRYCOLLECTION".equals(dataType)) return true;
        return false;
    }


    /**
     * @param table
     * @param columnNameList
     * @param connection
     * @return
     */
    public static List<String> isSpitialTable(Table table, List<String> columnNameList, Connection connection) {
        List<String> geometryList = new ArrayList<String>();
        return geometryList;
    }



}
