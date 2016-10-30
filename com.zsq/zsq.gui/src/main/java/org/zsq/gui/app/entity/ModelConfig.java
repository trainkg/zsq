package org.zsq.gui.app.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import lombok.Getter;
import lombok.Setter;

/**
 * 单模块配置文件
 * 
 * @author peculiar.1@163.com
 * @version $ID: ModelConfig.java, V1.0.0 2016年10月30日 下午3:28:19 $
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.NONE)
public class ModelConfig {

	/**
	 * 生成中DAO文件存放路径
	 */
	private String daoPath;
	/**
	 * service 存放路径
	 */
	private String servicePath;
	/**
	 * controller 文件存放路径
	 */
	private String controllPath;
	
	/**
	 * js存放路径
	 */
	private String jsPath;
	
	/**
	 * JSP文件存放路径 
	 */
	private String jspPath;
	
}
