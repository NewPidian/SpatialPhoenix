package parser;

import entity.GeometryColumnsEntity;
import net.sf.jsqlparser.JSQLParserException;

import java.io.StringReader;
import java.sql.Connection;
import java.util.List;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/30
 */
public class UpsertParser extends SpatialSqlParser {
    /**
     * 将sql语句改为Phoenix支持的SQL
     *
     * @param statement
     * @param connection
     * @param list       出参，获取表对应的空间列集合
     * @return
     * @throws JSQLParserException
     */
    @Override
    public String parse(String statement, Connection connection, List<GeometryColumnsEntity> list) throws JSQLParserException {
        getManager().parse(new StringReader(statement));
        return null;
    }
}
