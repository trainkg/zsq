package org.zsq.gui.app.db.ddl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 约束信息  主键外检 部分约束信息，生成过程中关注的数据
 * @author Administrator
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ConstraintDDLInfo {

	public static final String PARIMARY = "PRIMARY KEY";
	public static final String FORENGN  = "FOREIGN KEY";
	
	private String tableName;
	private String constraintType;
	private String columnName;
	private String refTableName;
	private String ordinalPosition;
}
