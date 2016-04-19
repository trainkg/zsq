package org.zsq.gui.app.db.ddl;

import java.util.List;
import java.util.Map;

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
public class TableDDLInfo {

	/**
	 * 支持将字段描述采用JSON形式直接定义
	 */
	private Map<String,String> commit;
	private String tableSchema;
	private String tableCollation;
	private String schema;
	private String tableName;
	
	public String getModelName(){
		return null;
	}
    
    private List<ConstraintDDLInfo> primaryInfos;
    private List<ConstraintDDLInfo> foreignInfos; 
    private List<ColumnDDLInfo> 	columnInfos;
    
    
	public void setColumnInfos(List<ColumnDDLInfo> 	columnInfos){
		this.columnInfos = columnInfos;
		for (ColumnDDLInfo columnDDLInfo : columnInfos) {
			columnDDLInfo.setTableInfo(this);
		}
	}

}
