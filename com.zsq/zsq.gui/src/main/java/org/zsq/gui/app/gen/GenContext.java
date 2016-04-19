package org.zsq.gui.app.gen;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.zsq.gui.app.db.ddl.TableDDLInfo;

/**
 * 生成文件上下文控制，管理全局配置
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: GenContext.java, V1.0.0 2016年4月18日 上午11:52:50 $
 */
@NoArgsConstructor
public class GenContext {
	
	@Getter
	private GenGlobalConfig config;
	
	/**
	 * 生效的生成器
	 */
	@Getter @Setter
	private List<Genarator> gens;
	
    protected void genrator(TableDDLInfo config2) {
		if(gens != null && !gens.isEmpty()){
			for (Genarator gen : gens) {
				gen.genaratorIfNeed(this, config2);
			}
		}
	}
	
	
}
