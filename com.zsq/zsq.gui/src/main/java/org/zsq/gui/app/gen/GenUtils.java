package org.zsq.gui.app.gen;

import org.zsq.gui.app.db.ddl.TableDDLInfo;

/**
 * 生成文件工具类
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: GenUtils.java, V1.0.0 2016年4月18日 上午11:58:38 $
 */
public class GenUtils {
	public static GenContext context;
	
	public static void genrator(TableDDLInfo config){
		context.genrator(config);
	}
	
}
