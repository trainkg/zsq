package org.zsq.gui.app.gen;

import java.io.File;

import org.zsq.gui.app.db.ddl.TableDDLInfo;

/**
 * MAVEN 默认规则下的文件存放路径,标准maven结构信息定义
 * 
 * 主要分成项目位置,模块生成方案,java文件根路径
 * 
 * @author peculiar.1@163.com
 * @version $ID: MavenModelManager.java, V1.0.0 2016年4月23日 下午2:16:00 $
 */
public class MavenModelManager implements ModelManager {
	private String projectBasePath;
	
	public MavenModelManager(String basePath) {
		this.projectBasePath = basePath;
	}

	@Override
	public File getJavaBasePathFile(TableDDLInfo info) {
		String modelBase = getPathWithSchame(info);
		return new File(projectBasePath+"/"+modelBase+"/src/main/java") ;
	}

	@Override
	public File getConfigBasePathFile(TableDDLInfo info) {
		String modelBase = getPathWithSchame(info);
		return new File(projectBasePath+"/"+modelBase+"/src/main/resources") ;
	}
	
	/**
	 * 支持对表的schame定义进行maven结构分析
	 * @param info
	 * @return
	 */
	public static String getPathWithSchame(TableDDLInfo info){
		String modelName = info.getModelPath();
		return modelName;
	}

}
