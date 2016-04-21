package zsq.triankg.core.plugin;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 插件信息
 * 
 * @author peculiar.1@163.com
 * @version $ID: BaseAbstratPlugin.java, V1.0.0 2016年4月21日 下午8:24:03 $
 */
@Getter
@Setter
@NoArgsConstructor
public class BaseAbstratPlugin implements Plugin {
	
	/**
	 * 系统全局唯一标示
	 */
	private String pluginId;
	
	/**
	 * 分析结果, 插件所在层级
	 */
	private int level;
	
	/**
	 * 插件依赖关系， 由插件配置文件中标明， 依赖关系中只存在直接依赖，不存在简介依赖
	 * 
	 * PA --> PB --> PC
	 * 			 --> PD
	 * 如果配置了
	 * 
	 * PA --> PD
	 *    --> PB 
	 * 
	 * 那么 PA --> PB也不是直接依赖关系，因为在他的PB依赖中已经存在PD了
	 */
	private List<BaseAbstratPlugin> dependcyPlugins;
	
	
	public void setLevel(int i){
		this.level = i;
		setDependcyPluginsLevel(dependcyPlugins,i+1);
	}
	
	private void setDependcyPluginsLevel(
			List<BaseAbstratPlugin> dependcyPlugins2, int i) {
		if(dependcyPlugins2 != null){
			for (BaseAbstratPlugin baseAbstratPlugin : dependcyPlugins2) {
				baseAbstratPlugin.setLevel(i);
				setDependcyPluginsLevel(baseAbstratPlugin.getDependcyPlugins(), i+1);
			}
		}
	}

	/**
	 * 获取所有依赖插件ID列表
	 * @return
	 */
	public  List<String> getRefPluginsIds(){
		if(dependcyPlugins != null){
			List<String> ids = new ArrayList<String>(dependcyPlugins.size());
			for (BaseAbstratPlugin plg : dependcyPlugins) {
				ids.add(plg.getPluginId());
			}
		}
		return null;
	}
}
