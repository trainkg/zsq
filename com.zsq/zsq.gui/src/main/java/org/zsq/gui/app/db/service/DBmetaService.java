package org.zsq.gui.app.db.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.zsq.gui.app.core.ZsqContext;

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
	
	
	
}
