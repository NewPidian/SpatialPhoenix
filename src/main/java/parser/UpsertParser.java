package parser;

import entity.GeometryColumnsEntity;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.expression.operators.relational.ItemsListVisitor;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.upsert.Upsert;
import util.GeometryColumnsUtil;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/30
 */
public class UpsertParser extends SpatialSqlParser {
    /**
     * 将sql语句改为Phoenix支持的SQL
     * 此处为插入或者更新语句，需要做的工作就是将插入的列,判断是不是
     * 空间列，如果是空间列，则需要转换为Phoenix支持的空间列
     *
     * @param statement
     * @param connection
     * @param list       出参，获取表对应的空间列集合
     *                   todo 在考虑是否将WKT转化为PhoenixWKT格式
     * @return
     * @throws JSQLParserException
     */
    @Override
    public String parse(String statement, Connection connection, List<GeometryColumnsEntity> list) throws JSQLParserException, SQLException {
        Upsert upsert = (Upsert) getManager().parse(new StringReader(statement));
//        String tableName = upsert.getTable().getName();
//        list = GeometryColumnsUtil.getEntityByTableName(tableName, connection);
        return upsert.toString().toUpperCase();

//        /**
//         * todo 不一定是对的，待验证
//         * 如果是subSelect，则直接返回，这样是没错的。
//         */
//        if (upsert.getSelect() != null) {
//            return upsert.toString().toUpperCase();
//        }
//        /**
//         * 不为空则说明是更新某些列，需要获取列名称
//         */
//        if (upsert.getColumns() != null) {
//            List<Column> columns = upsert.getColumns();
//            for (int i = 0; i < columns.size(); i++) {
//                String columnName = columns.get(i).getColumnName();
//                for (int j = 0; j < list.size(); j++) {
//                    /**
//                     * 存在空间列,
//                     */
//                    GeometryColumnsEntity entity = list.get(j);
//                    if (entity.getGeometryColumn().equals(columnName)) {
////                        upsertGeometryColumn(upsert, entity.getGeometryColumn(), );
//                    }
//                }
//            }
//        } else {
//            /**为空，说明upsert的是整个表*/
//
//        }

    }


}
