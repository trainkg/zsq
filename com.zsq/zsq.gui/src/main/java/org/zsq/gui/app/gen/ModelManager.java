package org.zsq.gui.app.gen;

import java.io.File;

import org.zsq.gui.app.db.ddl.TableDDLInfo;

/**
 * 自动化工具模块化切分管理 
 * @author peculiar.1@163.com
 * @version $ID: ModelManager.java, V1.0.0 2016年4月23日 下午2:13:18 $
 */
public interface ModelManager {
	/**
	 * 根据table配置信息获取JAVA文件存放的根路径
	 * @return
	 */
	public File getJavaBasePathFile(TableDDLInfo info);
	
	/**
	 * 根据table配置信息获取配置文件存放的根路径
	 * @return
	 */
	public File getConfigBasePathFile(TableDDLInfo info);
}
