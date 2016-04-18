package org.zsq.gui.app.gen;

import lombok.Getter;
import lombok.Setter;

/**
 * 单表生成信息配置
 * 
 * mysql 表DDL信息在 information_schema.tables 中
 * select table_name,table_comment from information_schema.tables  where table_schema = 'dytables ' and table_name ='tt';
 * 
 * -- 查看约束信息
 * select TABLE_NAME,COLUMN_NAME,CONSTRAINT_NAME,REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME from information_schema.KEY_COLUMN_USAGE where TABLE_NAME = 'tT';
 * 
 * @author peculiar.1@163.com
 * @version $ID: TableConfig.java, V1.0.0 2016年4月18日 上午11:51:04 $
 */
@Getter
@Setter
public class TableGenConfig {

	/**
	 * JSON格式 
	 */
	private String commit;
	
	private String schema;
	private String tableName;
	
	public String getModelName(){
		return null;
	}
	
}
