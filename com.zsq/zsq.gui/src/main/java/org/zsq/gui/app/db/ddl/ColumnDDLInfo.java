package org.zsq.gui.app.db.ddl;

import java.sql.Types;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * 单个表字段配置信息 information_schema.columns
 * 
 * <pre>
 * 	<strong>mysql</strong>
 * select * from information_schema.columns  where table_schema ='dytables ' and table_name = 'tt'
 * </pre>
 * 
 * @author Administrator
 */
@Getter
@Setter
public class ColumnDDLInfo {

	/**
	 * 支持将字段描述采用JSON形式直接定义
	 */
	private Map<String,String> colCmtMap;
	private String tableSchema;
	private String tableName;
	private String name;
	private String columnDefault;
	private boolean nullable;
	private Types type;
    private int length;
    
    private TableDDLInfo tableInfo;
}
