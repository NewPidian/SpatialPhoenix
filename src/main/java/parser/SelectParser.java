package parser;

import entity.GeometryColumnsEntity;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;

import java.io.StringReader;
import java.sql.Connection;
import java.util.List;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/23
 */
public class SelectParser extends SpatialSqlParser {

    public SelectParser() {
        super();
    }

    /**
     * 将sql语句改为Phoenix支持的SQL
     * 获取空间列集合
     *
     * @param statement
     * @param connection
     * @param list       出参，获取表对应的空间列集合
     * @return
     * @throws JSQLParserException
     */
    @Override
    public String parse(String statement, Connection connection, List<GeometryColumnsEntity> list) throws JSQLParserException {
        Select select = (Select) getManager().parse(new StringReader(statement));
        return select.toString().toUpperCase();
    }
}
