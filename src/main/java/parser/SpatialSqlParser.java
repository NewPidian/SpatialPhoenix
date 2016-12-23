package parser;

import entity.GeometryColumnsEntity;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/21
 */
public abstract class SpatialSqlParser {
    private static CCJSqlParserManager manager= new CCJSqlParserManager();


    public SpatialSqlParser() {
    }

    public CCJSqlParserManager getManager() {
        return manager;
    }

    public void setManager(CCJSqlParserManager manager) {
        this.manager = manager;
    }


    /**
     * 将sql语句改为Phoenix支持的SQL
     * @param statement
     * @param connection
     * @param list 出参，获取表对应的空间列集合
     * @return
     * @throws JSQLParserException
     */
    public abstract String parse(String statement, Connection connection, List<GeometryColumnsEntity> list) throws JSQLParserException;
}
