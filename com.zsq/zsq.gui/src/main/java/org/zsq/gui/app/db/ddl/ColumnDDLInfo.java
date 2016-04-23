package org.zsq.gui.app.db.ddl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

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
@XmlAccessorType(XmlAccessType.NONE)
public class ColumnDDLInfo{

	/**
	 * 支持将字段描述采用JSON形式直接定义
	 */
	@XmlElement
	private String colCmt;
	@XmlElement
	private String tableSchema;
	@XmlElement
	private String tableName;
	@XmlElement
	private String columnName;
	@XmlElement
	private String columnDefault;
	@XmlElement
	private boolean isNullable;
	@XmlElement
	private String dataType;
	@XmlElement
    private int characterMaximumLength;
	@XmlElement
    private int numericPrecision;
	@XmlElement
    private String columnType;
    
    private TableDDLInfo tableInfo;

}
