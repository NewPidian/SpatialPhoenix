package parser;

import entity.GeometryColumnsEntity;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.statement.create.table.ColDataType;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import util.DBUtil;
import util.ParserUtil;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/22
 */
public class CreateTableParser extends SpatialSqlParser {


    public CreateTableParser() {
    }

    /**
     * 将sql语句改为Phoenix支持的SQL
     * 暂时不支持空间列索引
     * 记录Geometry_Column元数据信息
     *
     * @param statement
     * @param connection
     * @param list       出参，获取表对应的空间列集合
     * @return
     * @throws JSQLParserException
     */
    @Override
    public String parse(String statement, Connection connection, List<GeometryColumnsEntity> list) throws JSQLParserException {
        CreateTable createTable = (CreateTable) getManager().parse(new StringReader(statement));
        String tableName = createTable.getTable().getName();
        String schemaName = createTable.getTable().getSchemaName();
        for (ColumnDefinition definition : createTable.getColumnDefinitions()) {
            int srid = 0;
            if (definition.getColumnName().equals("srid") || definition.getColumnName().equals("SRID")) {
                List<String> specString = definition.getColumnSpecStrings();
                for (int i = 0; i < specString.size(); i++) {
                    if ((i < specString.size() - 2) && (specString.get(i).equals("DEFAULTVALUE") || specString.get(i).equals("defultvalue"))) {
                        srid = Integer.parseInt(specString.get(i + 2));
                    }
                }
            }
            /**
             * if it is Spatial Column
             * change it into String ColDataType
             * and
             * add info into geometry_column
             */
            if (ParserUtil.isGeometryType(definition)) {
                String geometryType = definition.getColDataType().getDataType();
                /**
                 * 设置VARCHAR(8000)
                 */
                ColDataType colDataType = new ColDataType();
                colDataType.setDataType("varchar(8000)");
                definition.setColDataType(colDataType);
//                definition.getColDataType().setDataType("VARCHAR(8000)");
                GeometryColumnsEntity entity = new GeometryColumnsEntity();
                entity.setSrid(srid);
                if (schemaName != null) entity.setSchemaName(schemaName);
                if (tableName != null) entity.setTableName(tableName);
                entity.setGeometryColumn(definition.getColumnName());
                entity.setType(geometryType);
                //设置成default=2
                entity.setCoordinateDimension(2);
                list.add(entity);
                addGeometryColumn(entity, connection);
            }
        }
        String phoenixSql = createTable.toString().toUpperCase();
        return phoenixSql;
    }

    /**
     * 插入一条GeometryColumns数据.
     *
     * @param entity
     * @param connection
     * @return
     * @throws SQLException
     */
    private int addGeometryColumn(GeometryColumnsEntity entity, Connection connection) {
        Statement statement = null;
        int res = 0;
        try {
            statement = connection.createStatement();
            StringBuffer sb = new StringBuffer();
            UUID uuid = UUID.randomUUID();
            sb.append("UPSERT INTO MZ_GEOMETRY_COLUMN ( id ,f_table_name,f_geometry_column,type,coordinate_dimension,srid) VALUES ( ");
            sb.append("'" + uuid.toString() + "'" + " ,");

            sb.append("'" + entity.getTableName() + "' ,");
            sb.append("'" + entity.getGeometryColumn() + "'" + " ,");
            sb.append("'" + entity.getType() + "' ,");
            sb.append(entity.getCoordinateDimension() + " ,");
            sb.append(entity.getSrid() + " )");
            res = statement.executeUpdate(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeStatement(statement);
        }
        return res;
    }


}
