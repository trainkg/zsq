package org.zsq.gui.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * 自动化平台设置全局设定 
 * 
 * 生成对应的全局配置XML文件
 * 
 * @author peculiar.1@163.com
 * @version $ID: ApplicationConfig.java, V1.0.0 2016年10月30日 下午2:19:07 $
 */
@Getter
@Setter
@XmlRootElement(name="applicationConfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApplicationConfig  {
	
	public ApplicationConfig() {
		modelConfigList = new ArrayList<ModelConfig>();
		modelConfigList.add(new ModelConfig("123","123","123","123","123","123","123"));
	}
	
	@XmlElement
	private List<ModelConfig> modelConfigList;
}
