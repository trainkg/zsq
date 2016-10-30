package org.zsq.gui.app.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 自动化平台设置全局设定 
 * 
 * @author peculiar.1@163.com
 * @version $ID: ApplicationConfig.java, V1.0.0 2016年10月30日 下午2:19:07 $
 */
@Getter
@Setter
public class ApplicationConfig {
	
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
