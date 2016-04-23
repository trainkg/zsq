package org.zsq.gui.app.core;


import java.sql.Connection;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * 上下文信息, 单例
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: ZsqContext.java, V1.0.0 2016年4月14日 下午5:17:28 $
 */
@Slf4j
public class ZsqContext {
	
	public static final String ZSQ_GUI_NAMESPACE = "http://www.zsq.com/gui";
	
	@Getter
	BasicDataSource ds;
	
	@Getter @Setter
	String dbUserName = "root";
	@Getter @Setter
	String dbPassword = "a123456";
	@Getter @Setter
	String driverClass = "com.mysql.jdbc.Driver";
	@Getter @Setter
	String dbURL = "jdbc:mysql://localhost:3306/mysql?autoReconnect=true";
	
	
	private static ZsqContext single=null;  
	
	public void initContext() {
		log.info("[初始化] 初始化开始");
		initdatabase();
		log.info("[初始化] 上下文初始化结束");
	}
	
	private void initdatabase() {
		ds = new BasicDataSource();
        ds.setDriverClassName(driverClass);
        ds.setUsername(dbUserName);
        ds.setPassword(dbPassword);
        ds.setUrl(dbURL);
	}

	public static synchronized ZsqContext getInstance() {
        if (single == null) {  
            single = new ZsqContext();
        }  
        return single;
	}

	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public QueryRunner getQueryRuner(){
		QueryRunner run = new QueryRunner(ds);
		return run;
	}
	
}
