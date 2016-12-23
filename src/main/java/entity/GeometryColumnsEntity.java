package entity;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/22
 */
public class GeometryColumnsEntity {
    private int id;
    private String schemaName;
    private String tableName;
    private String geometryColumn;
    private String type;
    private int coordinateDimension;
    private int srid;

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getGeometryColumn() {
        return geometryColumn;
    }

    public void setGeometryColumn(String geometryColumn) {
        this.geometryColumn = geometryColumn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCoordinateDimension() {
        return coordinateDimension;
    }

    public void setCoordinateDimension(int coordinateDimension) {
        this.coordinateDimension = coordinateDimension;
    }

    public int getSrid() {
        return srid;
    }

    public void setSrid(int srid) {
        this.srid = srid;
    }


    public GeometryColumnsEntity(int id, String schemaName, String tableName, String geometryColumn, String type, int coordinateDimension, int srid) {
        this.id = id;
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.geometryColumn = geometryColumn;
        this.type = type;
        this.coordinateDimension = coordinateDimension;
        this.srid = srid;
    }

    public GeometryColumnsEntity() {
    }
}
