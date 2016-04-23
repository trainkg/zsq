package org.zsq.gui.app.db.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.lang3.StringUtils;
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
@Slf4j
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
	public static List<ConstraintDDLInfo> getTableConstraintDDlInfo(String schema,String tableName,String type){
		QueryRunner run = ZsqContext.getInstance().getQueryRuner();
		try {
			
			final String[] cols = new String[]{"t.TABLE_NAME", "t.CONSTRAINT_TYPE", "c.COLUMN_NAME", "c.ORDINAL_POSITION"};
			String sql = "SELECT  "+ StringUtils.join(cols, ',')
						 +" FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS AS t, INFORMATION_SCHEMA.KEY_COLUMN_USAGE AS c "
						 +"WHERE t.TABLE_NAME = c.TABLE_NAME "
						 +"AND t.TABLE_SCHEMA = ? "
						 +"AND t.CONSTRAINT_TYPE = ? and t.table_name = ?";
						 
			return run.query(sql, new ResultSetHandler<List<ConstraintDDLInfo>>(){
				
				@Override
				public List<ConstraintDDLInfo> handle(ResultSet rs) throws SQLException {
					List<ConstraintDDLInfo> list = new ArrayList<ConstraintDDLInfo>();
					while (rs.next()) {
						ConstraintDDLInfo info = new ConstraintDDLInfo();
						extract(rs,info,cols);
						list.add(info);
					}
					return list;
				}
			},schema,type,tableName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	protected static void extract(ResultSet rs,Object info, String[] cols) {
		for (int i = 0; i < cols.length; i++) {
			String col = cols[i];
			String colName = col;
			if(StringUtils.contains(col,'.')){
				colName = StringUtils.split(col, '.')[1];
			}
			String pojoFeildName = camelName(colName);
			try {
				BeanUtils.setProperty(info, pojoFeildName, rs.getObject(colName));
			} catch (Exception e) {
				log.warn("{} set property {} failed .",info.getClass(),pojoFeildName);
				log.warn("exception info",e);
				continue;
			} 
		} 
	}

	/**
	 * 获取TABLE的ddl信息
	 * @return
	 */
	public static TableDDLInfo getTableDDLInfo(String schema,String tableName){
		QueryRunner run = ZsqContext.getInstance().getQueryRuner();
		try {
			
			final String[] cols = new String[]{"TABLE_SCHEMA","TABLE_NAME","TABLE_COLLATION"};
			String sql = "select "+StringUtils.join(cols, ',')+" from information_schema.tables  where table_schema = ? and table_name = ?";
						 
			return run.query(sql, new ResultSetHandler<TableDDLInfo>(){
				@Override
				public TableDDLInfo handle(ResultSet rs) throws SQLException {
					while (rs.next()) {
						TableDDLInfo ddl = new TableDDLInfo();
						extract(rs,ddl,cols);
						return ddl;
					}
					return null;
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
	public static List<ColumnDDLInfo> getTableColumnDDLInfo(String schema,String tableName){
		QueryRunner run = ZsqContext.getInstance().getQueryRuner();
		try {
			final String[] cols = new String[]{"table_schema","table_name","column_name","column_default","is_nullable","data_type","character_maximum_length","NUMERIC_PRECISION","column_type"};
			String sql = "select "+ StringUtils.join(cols, ',')+" from information_schema.columns  where table_schema =? and table_name = ?";
			return run.query(sql, new ResultSetHandler<List<ColumnDDLInfo>>(){
				@Override
				public List<ColumnDDLInfo> handle(ResultSet rs) throws SQLException {
					List<ColumnDDLInfo> list = new ArrayList<ColumnDDLInfo>();
					while (rs.next()) {
						ColumnDDLInfo info = new ColumnDDLInfo();
						extract(rs,info,cols);
						list.add(info);
					}
					return list;
				}
			},schema,tableName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 表单全部信息
	 * @param schema
	 * @param tableName
	 * @return
	 */
	public static TableDDLInfo getFullTableDDLInfo(String schema,String tableName){
		TableDDLInfo info = getTableDDLInfo(schema, tableName);
		info.setPrimaryInfos(getTableConstraintDDlInfo(schema, tableName, ConstraintDDLInfo.PARIMARY));
		info.setForeignInfos(getTableConstraintDDlInfo(schema, tableName, ConstraintDDLInfo.FORENGN));
		info.setColumnInfos(getTableColumnDDLInfo(schema, tableName));
		return info;
	}
	
	/**
	 * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
	 * 例如：HelloWorld->HELLO_WORLD
	 * @param name 转换前的驼峰式命名的字符串
	 * @return 转换后下划线大写方式命名的字符串
	 */
	public static String underscoreName(String name) {
	    StringBuilder result = new StringBuilder();
	    if (name != null && name.length() > 0) {
	        // 将第一个字符处理成大写
	        result.append(name.substring(0, 1).toUpperCase());
	        // 循环处理其余字符
	        for (int i = 1; i < name.length(); i++) {
	            String s = name.substring(i, i + 1);
	            // 在大写字母前添加下划线
	            if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
	                result.append("_");
	            }
	            // 其他字符直接转成大写
	            result.append(s.toUpperCase());
	        }
	    }
	    return result.toString();
	}
	 
	/**
	 * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
	 * 例如：HELLO_WORLD->HelloWorld
	 * @param name 转换前的下划线大写方式命名的字符串
	 * @return 转换后的驼峰式命名的字符串
	 */
	public static String camelName(String name) {
	    StringBuilder result = new StringBuilder();
	    // 快速检查
	    if (name == null || name.isEmpty()) {
	        // 没必要转换
	        return "";
	    } else if (!name.contains("_")) {
	        // 不含下划线，仅将首字母小写
	        return name.substring(0, 1).toLowerCase() + name.substring(1);
	    }
	    // 用下划线将原始字符串分割
	    String camels[] = name.split("_");
	    for (String camel :  camels) {
	        // 跳过原始字符串中开头、结尾的下换线或双重下划线
	        if (camel.isEmpty()) {
	            continue;
	        }
	        // 处理真正的驼峰片段
	        if (result.length() == 0) {
	            // 第一个驼峰片段，全部字母都小写
	            result.append(camel.toLowerCase());
	        } else {
	            // 其他的驼峰片段，首字母大写
	            result.append(camel.substring(0, 1).toUpperCase());
	            result.append(camel.substring(1).toLowerCase());
	        }
	    }
	    return result.toString();
	}
	
}
