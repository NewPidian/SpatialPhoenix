package execute;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.apache.phoenix.iterate.ResultIterator;
import org.apache.phoenix.jdbc.PhoenixResultSet;
import org.apache.phoenix.jdbc.PhoenixStatement;
import org.apache.phoenix.schema.tuple.Tuple;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件描述：空间结果集的实现
 * 主要添加 getGeometry方法。
 * 作者： bamboo
 * 时间： 2016/12/22
 */
public class SpatialPhoenixResultSet {
    private PhoenixResultSet rs;

    public SpatialPhoenixResultSet(PhoenixResultSet rs) throws SQLException {
        this.rs = rs;
    }


    /**
     * 只用到WKT格式的
     *
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    public Geometry getGeometry(int columnIndex) throws SQLException, ParseException {
        String geometryStr = rs.getString(columnIndex);
        return new WKTReader().read(new StringReader(geometryStr));
    }

    /**
     * 只用到WKT格式的
     *
     * @param columnLabel
     * @return
     * @throws SQLException
     */
    public Geometry getGeometry(String columnLabel) throws SQLException, ParseException {
        String geometryStr = rs.getString(columnLabel);
        return new WKTReader().read(new StringReader(geometryStr));
    }

    public boolean absolute(int row) throws SQLException {
        return rs.absolute(row);
    }

    public void afterLast() throws SQLException {
        rs.afterLast();
    }

    public void beforeFirst() throws SQLException {
        rs.beforeFirst();
    }

    public void cancelRowUpdates() throws SQLException {
        rs.cancelRowUpdates();
    }

    public void clearWarnings() throws SQLException {
        rs.clearWarnings();
    }

    public void close() throws SQLException {
        rs.close();
    }

    public void deleteRow() throws SQLException {
        rs.deleteRow();
    }

    public int findColumn(String columnLabel) throws SQLException {
        return rs.findColumn(columnLabel);
    }

    public boolean first() throws SQLException {
        return rs.first();
    }

    public Array getArray(int columnIndex) throws SQLException {
        return rs.getArray(columnIndex);
    }

    public Array getArray(String columnLabel) throws SQLException {
        return rs.getArray(columnLabel);
    }

    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        return rs.getAsciiStream(columnIndex);
    }

    public InputStream getAsciiStream(String columnLabel) throws SQLException {
        return rs.getAsciiStream(columnLabel);
    }

    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        return rs.getBigDecimal(columnIndex);
    }

    public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
        return rs.getBigDecimal(columnLabel);
    }

    public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        return rs.getBigDecimal(columnIndex, scale);
    }

    public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
        return rs.getBigDecimal(columnLabel, scale);
    }

    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        return rs.getBinaryStream(columnIndex);
    }

    public InputStream getBinaryStream(String columnLabel) throws SQLException {
        return rs.getBinaryStream(columnLabel);
    }

    public Blob getBlob(int columnIndex) throws SQLException {
        return rs.getBlob(columnIndex);
    }

    public Blob getBlob(String columnLabel) throws SQLException {
        return rs.getBlob(columnLabel);
    }

    public boolean getBoolean(int columnIndex) throws SQLException {
        return rs.getBoolean(columnIndex);
    }

    public boolean getBoolean(String columnLabel) throws SQLException {
        return rs.getBoolean(columnLabel);
    }

    public byte[] getBytes(int columnIndex) throws SQLException {
        return rs.getBytes(columnIndex);
    }

    public byte[] getBytes(String columnLabel) throws SQLException {
        return rs.getBytes(columnLabel);
    }

    public byte getByte(int columnIndex) throws SQLException {
        return rs.getByte(columnIndex);
    }

    public byte getByte(String columnLabel) throws SQLException {
        return rs.getByte(columnLabel);
    }

    public Reader getCharacterStream(int columnIndex) throws SQLException {
        return rs.getCharacterStream(columnIndex);
    }

    public Reader getCharacterStream(String columnLabel) throws SQLException {
        return rs.getCharacterStream(columnLabel);
    }

    public Clob getClob(int columnIndex) throws SQLException {
        return rs.getClob(columnIndex);
    }

    public Clob getClob(String columnLabel) throws SQLException {
        return rs.getClob(columnLabel);
    }

    public int getConcurrency() throws SQLException {
        return rs.getConcurrency();
    }

    public String getCursorName() throws SQLException {
        return rs.getCursorName();
    }

    public Date getDate(int columnIndex) throws SQLException {
        return rs.getDate(columnIndex);
    }

    public Date getDate(String columnLabel) throws SQLException {
        return rs.getDate(columnLabel);
    }

    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        return rs.getDate(columnIndex, cal);
    }

    public Date getDate(String columnLabel, Calendar cal) throws SQLException {
        return rs.getDate(columnLabel, cal);
    }

    public double getDouble(int columnIndex) throws SQLException {
        return rs.getDouble(columnIndex);
    }

    public double getDouble(String columnLabel) throws SQLException {
        return rs.getDouble(columnLabel);
    }

    public int getFetchDirection() throws SQLException {
        return rs.getFetchDirection();
    }

    public int getFetchSize() throws SQLException {
        return rs.getFetchSize();
    }

    public float getFloat(int columnIndex) throws SQLException {
        return rs.getFloat(columnIndex);
    }

    public float getFloat(String columnLabel) throws SQLException {
        return rs.getFloat(columnLabel);
    }

    public int getHoldability() throws SQLException {
        return rs.getHoldability();
    }

    public int getInt(int columnIndex) throws SQLException {
        return rs.getInt(columnIndex);
    }

    public int getInt(String columnLabel) throws SQLException {
        return rs.getInt(columnLabel);
    }

    public long getLong(int columnIndex) throws SQLException {
        return rs.getLong(columnIndex);
    }

    public long getLong(String columnLabel) throws SQLException {
        return rs.getLong(columnLabel);
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return rs.getMetaData();
    }

    public Reader getNCharacterStream(int columnIndex) throws SQLException {
        return rs.getNCharacterStream(columnIndex);
    }

    public Reader getNCharacterStream(String columnLabel) throws SQLException {
        return rs.getNCharacterStream(columnLabel);
    }

    public NClob getNClob(int columnIndex) throws SQLException {
        return rs.getNClob(columnIndex);
    }

    public NClob getNClob(String columnLabel) throws SQLException {
        return rs.getNClob(columnLabel);
    }

    public String getNString(int columnIndex) throws SQLException {
        return rs.getNString(columnIndex);
    }

    public String getNString(String columnLabel) throws SQLException {
        return rs.getNString(columnLabel);
    }

    public Object getObject(int columnIndex) throws SQLException {
        return rs.getObject(columnIndex);
    }

    public Object getObject(String columnLabel) throws SQLException {
        return rs.getObject(columnLabel);
    }

    public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
        return rs.getObject(columnIndex, map);
    }

    public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
        return rs.getObject(columnLabel, map);
    }

    public Ref getRef(int columnIndex) throws SQLException {
        return rs.getRef(columnIndex);
    }

    public Ref getRef(String columnLabel) throws SQLException {
        return rs.getRef(columnLabel);
    }

    public int getRow() throws SQLException {
        return rs.getRow();
    }

    public RowId getRowId(int columnIndex) throws SQLException {
        return rs.getRowId(columnIndex);
    }

    public RowId getRowId(String columnLabel) throws SQLException {
        return rs.getRowId(columnLabel);
    }

    public SQLXML getSQLXML(int columnIndex) throws SQLException {
        return rs.getSQLXML(columnIndex);
    }

    public SQLXML getSQLXML(String columnLabel) throws SQLException {
        return rs.getSQLXML(columnLabel);
    }

    public short getShort(int columnIndex) throws SQLException {
        return rs.getShort(columnIndex);
    }

    public short getShort(String columnLabel) throws SQLException {
        return rs.getShort(columnLabel);
    }

    public PhoenixStatement getStatement() throws SQLException {
        return rs.getStatement();
    }

    public String getString(int columnIndex) throws SQLException {
        return rs.getString(columnIndex);
    }

    public String getString(String columnLabel) throws SQLException {
        return rs.getString(columnLabel);
    }

    public Time getTime(int columnIndex) throws SQLException {
        return rs.getTime(columnIndex);
    }

    public Time getTime(String columnLabel) throws SQLException {
        return rs.getTime(columnLabel);
    }

    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        return rs.getTime(columnIndex, cal);
    }

    public Time getTime(String columnLabel, Calendar cal) throws SQLException {
        return rs.getTime(columnLabel, cal);
    }

    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        return rs.getTimestamp(columnIndex);
    }

    public Timestamp getTimestamp(String columnLabel) throws SQLException {
        return rs.getTimestamp(columnLabel);
    }

    public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        return rs.getTimestamp(columnIndex, cal);
    }

    public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
        return rs.getTimestamp(columnLabel, cal);
    }

    public int getType() throws SQLException {
        return rs.getType();
    }

    public URL getURL(int columnIndex) throws SQLException {
        return rs.getURL(columnIndex);
    }

    public URL getURL(String columnLabel) throws SQLException {
        return rs.getURL(columnLabel);
    }

    public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        return rs.getUnicodeStream(columnIndex);
    }

    public InputStream getUnicodeStream(String columnLabel) throws SQLException {
        return rs.getUnicodeStream(columnLabel);
    }

    public SQLWarning getWarnings() throws SQLException {
        return rs.getWarnings();
    }

    public void insertRow() throws SQLException {
        rs.insertRow();
    }

    public boolean isAfterLast() throws SQLException {
        return rs.isAfterLast();
    }

    public boolean isBeforeFirst() throws SQLException {
        return rs.isBeforeFirst();
    }

    public boolean isClosed() throws SQLException {
        return rs.isClosed();
    }

    public boolean isFirst() throws SQLException {
        return rs.isFirst();
    }

    public boolean isLast() throws SQLException {
        return rs.isLast();
    }

    public boolean last() throws SQLException {
        return rs.last();
    }

    public void moveToCurrentRow() throws SQLException {
        rs.moveToCurrentRow();
    }

    public void moveToInsertRow() throws SQLException {
        rs.moveToInsertRow();
    }

    public Tuple getCurrentRow() {
        return rs.getCurrentRow();
    }

    public boolean next() throws SQLException {
        return rs.next();
    }

    public boolean previous() throws SQLException {
        return rs.previous();
    }

    public void refreshRow() throws SQLException {
        rs.refreshRow();
    }

    public boolean relative(int rows) throws SQLException {
        return rs.relative(rows);
    }

    public boolean rowDeleted() throws SQLException {
        return rs.rowDeleted();
    }

    public boolean rowInserted() throws SQLException {
        return rs.rowInserted();
    }

    public boolean rowUpdated() throws SQLException {
        return rs.rowUpdated();
    }

    public void setFetchDirection(int direction) throws SQLException {
        rs.setFetchDirection(direction);
    }

    public void setFetchSize(int rows) throws SQLException {
        rs.setFetchSize(rows);
    }

    public void updateArray(int columnIndex, Array x) throws SQLException {
        rs.updateArray(columnIndex, x);
    }

    public void updateArray(String columnLabel, Array x) throws SQLException {
        rs.updateArray(columnLabel, x);
    }

    public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
        rs.updateAsciiStream(columnIndex, x);
    }

    public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
        rs.updateAsciiStream(columnLabel, x);
    }

    public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
        rs.updateAsciiStream(columnIndex, x, length);
    }

    public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
        rs.updateAsciiStream(columnLabel, x, length);
    }

    public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
        rs.updateAsciiStream(columnIndex, x, length);
    }

    public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
        rs.updateAsciiStream(columnLabel, x, length);
    }

    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
        rs.updateBigDecimal(columnIndex, x);
    }

    public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
        rs.updateBigDecimal(columnLabel, x);
    }

    public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
        rs.updateBinaryStream(columnIndex, x);
    }

    public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
        rs.updateBinaryStream(columnLabel, x);
    }

    public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
        rs.updateBinaryStream(columnIndex, x, length);
    }

    public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
        rs.updateBinaryStream(columnLabel, x, length);
    }

    public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
        rs.updateBinaryStream(columnIndex, x, length);
    }

    public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
        rs.updateBinaryStream(columnLabel, x, length);
    }

    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        rs.updateBlob(columnIndex, x);
    }

    public void updateBlob(String columnLabel, Blob x) throws SQLException {
        rs.updateBlob(columnLabel, x);
    }

    public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
        rs.updateBlob(columnIndex, inputStream);
    }

    public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
        rs.updateBlob(columnLabel, inputStream);
    }

    public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
        rs.updateBlob(columnIndex, inputStream, length);
    }

    public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
        rs.updateBlob(columnLabel, inputStream, length);
    }

    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        rs.updateBoolean(columnIndex, x);
    }

    public void updateBoolean(String columnLabel, boolean x) throws SQLException {
        rs.updateBoolean(columnLabel, x);
    }

    public void updateByte(int columnIndex, byte x) throws SQLException {
        rs.updateByte(columnIndex, x);
    }

    public void updateByte(String columnLabel, byte x) throws SQLException {
        rs.updateByte(columnLabel, x);
    }

    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        rs.updateBytes(columnIndex, x);
    }

    public void updateBytes(String columnLabel, byte[] x) throws SQLException {
        rs.updateBytes(columnLabel, x);
    }

    public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
        rs.updateCharacterStream(columnIndex, x);
    }

    public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
        rs.updateCharacterStream(columnLabel, reader);
    }

    public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
        rs.updateCharacterStream(columnIndex, x, length);
    }

    public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
        rs.updateCharacterStream(columnLabel, reader, length);
    }

    public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        rs.updateCharacterStream(columnIndex, x, length);
    }

    public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        rs.updateCharacterStream(columnLabel, reader, length);
    }

    public void updateClob(int columnIndex, Clob x) throws SQLException {
        rs.updateClob(columnIndex, x);
    }

    public void updateClob(String columnLabel, Clob x) throws SQLException {
        rs.updateClob(columnLabel, x);
    }

    public void updateClob(int columnIndex, Reader reader) throws SQLException {
        rs.updateClob(columnIndex, reader);
    }

    public void updateClob(String columnLabel, Reader reader) throws SQLException {
        rs.updateClob(columnLabel, reader);
    }

    public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
        rs.updateClob(columnIndex, reader, length);
    }

    public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
        rs.updateClob(columnLabel, reader, length);
    }

    public void updateDate(int columnIndex, Date x) throws SQLException {
        rs.updateDate(columnIndex, x);
    }

    public void updateDate(String columnLabel, Date x) throws SQLException {
        rs.updateDate(columnLabel, x);
    }

    public void updateDouble(int columnIndex, double x) throws SQLException {
        rs.updateDouble(columnIndex, x);
    }

    public void updateDouble(String columnLabel, double x) throws SQLException {
        rs.updateDouble(columnLabel, x);
    }

    public void updateFloat(int columnIndex, float x) throws SQLException {
        rs.updateFloat(columnIndex, x);
    }

    public void updateFloat(String columnLabel, float x) throws SQLException {
        rs.updateFloat(columnLabel, x);
    }

    public void updateInt(int columnIndex, int x) throws SQLException {
        rs.updateInt(columnIndex, x);
    }

    public void updateInt(String columnLabel, int x) throws SQLException {
        rs.updateInt(columnLabel, x);
    }

    public void updateLong(int columnIndex, long x) throws SQLException {
        rs.updateLong(columnIndex, x);
    }

    public void updateLong(String columnLabel, long x) throws SQLException {
        rs.updateLong(columnLabel, x);
    }

    public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
        rs.updateNCharacterStream(columnIndex, x);
    }

    public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
        rs.updateNCharacterStream(columnLabel, reader);
    }

    public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        rs.updateNCharacterStream(columnIndex, x, length);
    }

    public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        rs.updateNCharacterStream(columnLabel, reader, length);
    }

    public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        rs.updateNClob(columnIndex, nClob);
    }

    public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
        rs.updateNClob(columnLabel, nClob);
    }

    public void updateNClob(int columnIndex, Reader reader) throws SQLException {
        rs.updateNClob(columnIndex, reader);
    }

    public void updateNClob(String columnLabel, Reader reader) throws SQLException {
        rs.updateNClob(columnLabel, reader);
    }

    public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
        rs.updateNClob(columnIndex, reader, length);
    }

    public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
        rs.updateNClob(columnLabel, reader, length);
    }

    public void updateNString(int columnIndex, String nString) throws SQLException {
        rs.updateNString(columnIndex, nString);
    }

    public void updateNString(String columnLabel, String nString) throws SQLException {
        rs.updateNString(columnLabel, nString);
    }

    public void updateNull(int columnIndex) throws SQLException {
        rs.updateNull(columnIndex);
    }

    public void updateNull(String columnLabel) throws SQLException {
        rs.updateNull(columnLabel);
    }

    public void updateObject(int columnIndex, Object x) throws SQLException {
        rs.updateObject(columnIndex, x);
    }

    public void updateObject(String columnLabel, Object x) throws SQLException {
        rs.updateObject(columnLabel, x);
    }

    public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
        rs.updateObject(columnIndex, x, scaleOrLength);
    }

    public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
        rs.updateObject(columnLabel, x, scaleOrLength);
    }

    public void updateRef(int columnIndex, Ref x) throws SQLException {
        rs.updateRef(columnIndex, x);
    }

    public void updateRef(String columnLabel, Ref x) throws SQLException {
        rs.updateRef(columnLabel, x);
    }

    public void updateRow() throws SQLException {
        rs.updateRow();
    }

    public void updateRowId(int columnIndex, RowId x) throws SQLException {
        rs.updateRowId(columnIndex, x);
    }

    public void updateRowId(String columnLabel, RowId x) throws SQLException {
        rs.updateRowId(columnLabel, x);
    }

    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
        rs.updateSQLXML(columnIndex, xmlObject);
    }

    public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
        rs.updateSQLXML(columnLabel, xmlObject);
    }

    public void updateShort(int columnIndex, short x) throws SQLException {
        rs.updateShort(columnIndex, x);
    }

    public void updateShort(String columnLabel, short x) throws SQLException {
        rs.updateShort(columnLabel, x);
    }

    public void updateString(int columnIndex, String x) throws SQLException {
        rs.updateString(columnIndex, x);
    }

    public void updateString(String columnLabel, String x) throws SQLException {
        rs.updateString(columnLabel, x);
    }

    public void updateTime(int columnIndex, Time x) throws SQLException {
        rs.updateTime(columnIndex, x);
    }

    public void updateTime(String columnLabel, Time x) throws SQLException {
        rs.updateTime(columnLabel, x);
    }

    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
        rs.updateTimestamp(columnIndex, x);
    }

    public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
        rs.updateTimestamp(columnLabel, x);
    }

    public boolean wasNull() throws SQLException {
        return rs.wasNull();
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return rs.isWrapperFor(iface);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return rs.unwrap(iface);
    }

    public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        return rs.getObject(columnIndex, type);
    }

    public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
        return rs.getObject(columnLabel, type);
    }

    public ResultIterator getUnderlyingIterator() {
        return rs.getUnderlyingIterator();
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method
     * must consistently return the same integer, provided no information
     * used in {@code equals} comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link Object#equals(Object)}
     * method, then calling the {@code hashCode} method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hash tables.
     * </ul>
     * <p>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java<font size="-2"><sup>TM</sup></font> programming language.)
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    public int hashCode() {
        return rs.hashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * {@code x}, {@code x.equals(x)} should return
     * {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * {@code x} and {@code y}, {@code x.equals(y)}
     * should return {@code true} if and only if
     * {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * {@code x}, {@code y}, and {@code z}, if
     * {@code x.equals(y)} returns {@code true} and
     * {@code y.equals(z)} returns {@code true}, then
     * {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * {@code x} and {@code y}, multiple invocations of
     * {@code x.equals(y)} consistently return {@code true}
     * or consistently return {@code false}, provided no
     * information used in {@code equals} comparisons on the
     * objects is modified.
     * <li>For any non-null reference value {@code x},
     * {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    public boolean equals(Object obj) {
        return rs.equals(obj);
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     *
     * By convention, the returned object should be obtained by calling
     * {@code rs.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     *
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code rs.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code rs.clone}
     * need to be modified.
     *
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     *
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Cloneable
     */


    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    public String toString() {
        return rs.toString();
    }

    /**
     * Called by the garbage collector on an object when garbage collection
     * determines that there are no more references to the object.
     * A subclass overrides the {@code finalize} method to dispose of
     * system resources or to perform other cleanup.
     * <p>
     * The general contract of {@code finalize} is that it is invoked
     * if and when the Java<font size="-2"><sup>TM</sup></font> virtual
     * machine has determined that there is no longer any
     * means by which this object can be accessed by any thread that has
     * not yet died, except as a result of an action taken by the
     * finalization of some other object or class which is ready to be
     * finalized. The {@code finalize} method may take any action, including
     * making this object available again to other threads; the usual purpose
     * of {@code finalize}, however, is to perform cleanup actions before
     * the object is irrevocably discarded. For example, the finalize method
     * for an object that represents an input/output connection might perform
     * explicit I/O transactions to break the connection before the object is
     * permanently discarded.
     * <p>
     * The {@code finalize} method of class {@code Object} performs no
     * special action; it simply returns normally. Subclasses of
     * {@code Object} may override this definition.
     * <p>
     * The Java programming language does not guarantee which thread will
     * invoke the {@code finalize} method for any given object. It is
     * guaranteed, however, that the thread that invokes finalize will not
     * be holding any user-visible synchronization locks when finalize is
     * invoked. If an uncaught exception is thrown by the finalize method,
     * the exception is ignored and finalization of that object terminates.
     * <p>
     * After the {@code finalize} method has been invoked for an object, no
     * further action is taken until the Java virtual machine has again
     * determined that there is no longer any means by which this object can
     * be accessed by any thread that has not yet died, including possible
     * actions by other objects or classes which are ready to be finalized,
     * at which point the object may be discarded.
     * <p>
     * The {@code finalize} method is never invoked more than once by a Java
     * virtual machine for any given object.
     * <p>
     * Any exception thrown by the {@code finalize} method causes
     * the finalization of this object to be halted, but is otherwise
     * ignored.
     *
     * @throws Throwable the {@code Exception} raised by this method
     */

}
