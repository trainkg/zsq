package org.zsq.gui.app.gen;

import java.io.File;

/**
 * path 路径生成方案
 * 
 * 路径主要分为2部分，模块文件路径 又{@link ModelManager}管理,模块下文件路径生成方案由 switchPath处理
 * 
 * @author peculiar.1@163.com
 * @version $ID: SwitchPath.java, V1.0.0 2016年4月22日 下午10:18:19 $
 */
public interface SwitchPath {
	
	/**
	 * 获取路径生成器生成存放路径
	 * @return
	 */
	public File getPath();
}
