package org.zsq.gui.app.gen;

import lombok.Getter;
import lombok.Setter;

/**
 * 生成文件全局配置, 目前思想， 采用maven默认的搜寻路径
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: GlobalConfig.java, V1.0.0 2016年4月18日 上午11:54:27 $
 */
@Getter 
@Setter
public class GenGlobalConfig {
	
	/**
	 * 项目基础目录
	 */
	private String basePath;
	
	private String company;
	private String projectName;
	
	/**
	 * 模块路径管理
	 */
	public ModelManager manager;
	
	public GenGlobalConfig(String basePath) {
		manager = new MavenModelManager(basePath);
	}
	
}
