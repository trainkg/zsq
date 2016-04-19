package org.zsq.gui.app.db.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.zsq.gui.app.core.ZsqContext;
import org.zsq.gui.app.db.ddl.ColumnDDLInfo;
import org.zsq.gui.app.db.ddl.ConstraintDDLInfo;
import org.zsq.gui.app.db.ddl.TableDDLInfo;

/**
 * 提供一些数据库元数据业务支撑
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: DBmetaService.java, V1.0.0 2016年4月14日 下午5:24:24 $
 */
public class DBmetaService {
	
	/**
	 * table 列表
	 * @return
	 * @throws SQLException
	 */
	public static List<String> getTables(){
		QueryRunner run = ZsqContext.getInstance().getQueryRuner();
		try {
			return run.query("show tables", new ResultSetHandler<List<String>>(){
				@Override
				public List<String> handle(ResultSet rs) throws SQLException {
					List<String> list = new ArrayList<String>();
					while (rs.next()) {
						list.add(rs.getString(1));
					}
					return list;
				}
			});
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 切换数据库
	 * @param name
	 */
	public static void changeDB(String name){
		QueryRunner run = ZsqContext.getInstance().getQueryRuner();
		try {
			run.query("use "+name, new ResultSetHandler<Object>(){
				@Override
				public Object handle(ResultSet rs) throws SQLException {
					return null;
				}
			});
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 获取表定义相关的约束信息
	 * @param schema
	 * @param tableName
	 * @param type 约束类型
	 * @return
	 */
	public List<ConstraintDDLInfo> getTableConstraintDDlInfo(String schema,String tableName,String type){
		QueryRunner run = ZsqContext.getInstance().getQueryRuner();
		try {
			
			String sql = "SELECT t.TABLE_NAME, t.CONSTRAINT_TYPE, c.COLUMN_NAME, c.ORDINAL_POSITION "
						 +"FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS AS t, INFORMATION_SCHEMA.KEY_COLUMN_USAGE AS c "
						 +"WHERE t.TABLE_NAME = c.TABLE_NAME "
						 +"AND t.TABLE_SCHEMA = ? "
						 +"AND t.CONSTRAINT_TYPE = ? and t.table_name = ?";
						 
			return run.query(sql, new ResultSetHandler<List<ConstraintDDLInfo>>(){
				@Override
				public List<ConstraintDDLInfo> handle(ResultSet rs) throws SQLException {
					List<ConstraintDDLInfo> list = new ArrayList<ConstraintDDLInfo>();
					//TODO
					return list;
				}
			},schema,type,tableName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获取TABLE的ddl信息
	 * @return
	 */
	public TableDDLInfo getTableDDLInfo(String schema,String tableName){
		QueryRunner run = ZsqContext.getInstance().getQueryRuner();
		try {
			
			String sql = "select TABLE_SCHEMA,TABLE_NAME,TABLE_COLLATION from information_schema.tables  where table_schema = ? and table_name = ?";
						 
			return run.query(sql, new ResultSetHandler<TableDDLInfo>(){
				@Override
				public TableDDLInfo handle(ResultSet rs) throws SQLException {
					TableDDLInfo ddl = new TableDDLInfo();
					//TODO
					return ddl;
				}
			},schema,tableName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获取单表下面所有字段的DDL信息
	 * @param schema
	 * @param tableName
	 * @return
	 */
	public List<ColumnDDLInfo> getTableColumnDDLInfo(String schema,String tableName){
		QueryRunner run = ZsqContext.getInstance().getQueryRuner();
		try {
			
			String sql = "select table_schema,table_name,column_name,column_default,is_nullable,data_type,character_maximum_length,NUMERIC_PRECISION,column_type from information_schema.columns  where table_schema =? and table_name = ?";
			return run.query(sql, new ResultSetHandler<List<ColumnDDLInfo>>(){
				@Override
				public List<ColumnDDLInfo> handle(ResultSet rs) throws SQLException {
					List<ColumnDDLInfo> list = new ArrayList<ColumnDDLInfo>();
					//TODO
					return list;
				}
			},schema,tableName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public TableDDLInfo getFullTableDDLInfo(String schema,String tableName){
		TableDDLInfo info = getTableDDLInfo(schema, tableName);
		info.setPrimaryInfos(getTableConstraintDDlInfo(schema, tableName, ConstraintDDLInfo.PARIMARY));
		info.setForeignInfos(getTableConstraintDDlInfo(schema, tableName, ConstraintDDLInfo.FORENGN));
		info.setColumnInfos(getTableColumnDDLInfo(schema, tableName));
		return info;
	}
	
	
}
