package org.zsq.gui.app.db.ddl;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.zsq.gui.app.core.ZsqContext;

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
@NoArgsConstructor
@XmlRootElement(name="table",namespace=ZsqContext.ZSQ_GUI_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class TableDDLInfo {

	/**
	 * 支持将字段描述采用JSON形式直接定义
	 */
	private String commit;
	private String tableSchema;
	/**
	 * 模块在项目中的相对路径
	 */
	private String modelPath;
	/**
	 * table对应表所在模块名称
	 */
	private String modelName;
	private String tableCollation;
	
	private String schema;
	//@XmlElement(required = true ,nillable=true)
	private String tableName;
	
	@XmlElementWrapper(name="primarys")
	@XmlElement
    private List<ConstraintDDLInfo> primaryInfos;
	
	@XmlElementWrapper(name="foreigns")
	@XmlElement
    private List<ConstraintDDLInfo> foreignInfos;
	
	@XmlElementWrapper(name="columns")
	@XmlElement
    private List<ColumnDDLInfo> 	columnInfos;
    
    
	public void setColumnInfos(List<ColumnDDLInfo> 	columnInfos){
		this.columnInfos = columnInfos;
		for (ColumnDDLInfo columnDDLInfo : columnInfos) {
			columnDDLInfo.setTableInfo(this);
		}
	}
	
	/**
	 * 如果备注是一些JSON结构 那么从中提取一些可用的信息
	 */
	public void getInfoForCommit(){
	}
	
	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance(TableDDLInfo.class);
		context.createMarshaller().marshal(new TableDDLInfo(), System.out);
		String ss = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ns2:table xmlns:ns2=\"http://www.zsq.com/gui\"><commit><entry><key>a</key><value>123</value></entry><entry><key>b</key><value>123</value></entry></commit><primarys><constraint><columnName>username</columnName><constraintType>123</constraintType><refTableName>tt</refTableName><tableName>tableName</tableName></constraint><constraint><columnName>username</columnName><constraintType>123</constraintType><refTableName>tt</refTableName><tableName>tableName</tableName></constraint></primarys></ns2:table>";
		TableDDLInfo info = (TableDDLInfo) context.createUnmarshaller().unmarshal(new ByteArrayInputStream(ss.getBytes()));
		System.out.println(info);
	}
}
