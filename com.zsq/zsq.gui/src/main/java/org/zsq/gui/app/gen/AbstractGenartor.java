package org.zsq.gui.app.gen;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.zsq.gui.app.db.ddl.TableDDLInfo;

import zsq.triankg.core.template.TemplateContext;

/**
 * 抽象生成类，提供一些生成类必要的信息和工具
 * 
 * @author peculiar.1@163.com
 * @version $ID: AbstractGenartor.java, V1.0.0 2016年4月22日 下午10:13:23 $
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractGenartor implements Genarator {
	/**
	 * 文件路径生成器，决定生成文件存放位置和名称。
	 * @return
	 */
	public SwitchPath pathHander;
	
	private TemplateContext templateContext;
	/**生成文件的默认编码*/
	private String fileEncoding = "utf-8";
	
	public AbstractGenartor(SwitchPath pathHander){
		this.pathHander = pathHander;
	}
	/**
	 * 获取
	 * @return
	 */
	public String getPackagePath(){
		return "com.test.dd.pojo";
	}

	@Override
	public void genaratorIfNeed(GenContext context, TableDDLInfo config) {
		if(careConfig(context, config)){
			genaratorHander(context,config);
		}
	}

	public abstract void genaratorHander(GenContext context, TableDDLInfo config);

	@Override
	public boolean careConfig(GenContext context, TableDDLInfo config) {
		return true;
	}

	/**
	 * 获取当前配置应该存放的文件位置
	 * @return
	 */
	public File getGenrateFile(){
		return pathHander.getPath();
	}
	
}
