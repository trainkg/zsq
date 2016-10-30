package org.zsq.gui.app.web.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * table 定义视图
 * 
 * @author peculiar.1@163.com
 * @version $ID: TableDefined.java, V1.0.0 2016年10月30日 上午10:24:37 $
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TableDefined {

	@JsonProperty("text")
	private String tableName;
}
