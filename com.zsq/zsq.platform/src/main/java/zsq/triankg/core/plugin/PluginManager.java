package zsq.triankg.core.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * 插件依赖管理器
 * 
 * @author peculiar.1@163.com
 * @version $ID: PluginContext.java, V1.0.0 2016年4月21日 下午8:33:41 $
 */
@Getter
@Setter
public class PluginManager {
	
	/**
	 * plugin 插件配置文件描述 ,系统加载的时候回读取系统所有的插件结构定义文件，插件结构描述分散在各个插件信息文件中
	 */
	public static final String PLUGIN_CONFIG_XML = "zsq-plugin";
	/**
	 * 基础路径
	 */
	public static final String ROOT_PLUGIN_ID = "zsqroot";
	
	/**
	 * 系统所有的插件
	 */
	private List<BaseAbstratPlugin> allPlugins;
	/**
	 * 插件结构最大层级
	 */
	private int maxLevel;
	
	/**
	 *  初始化插件依赖结构
	 */
	public void initPlugins(){
		allPlugins = internalLoadPlugins();
		
		analysePlugins();
	}
	
	/*
	 * 分析插件依赖关系,以及插件层级关系, 检查是否有回环依赖问题
	 */
	private void analysePlugins() {
		Map<String,Integer> indexs = new HashMap<String,Integer>();
		internalInitLevel(PLUGIN_CONFIG_XML, indexs);
	}
	
	private void internalInitLevel(String refId,Map<String,Integer> indexs){
		List<BaseAbstratPlugin> plus = getRefPlugin(refId);
		for (BaseAbstratPlugin onelvl : plus) {
			checkLoopRef(onelvl);
			String ref = onelvl.getPluginId();
			Integer i = 1;
			onelvl.setLevel(i);
			indexs.put(ref, i);
			internalInitLevel(ref, indexs);
		}
	}

	/*
	 * 检查插件是否回环
	 * @param onelvl
	 */
	private void checkLoopRef(BaseAbstratPlugin onelvl) throws IllegalArgumentException{
		String key = onelvl.getPluginId();
		List<String> list = new ArrayList<String>();
		internalCheckLoopRef(key,list,key);
	}

	private void internalCheckLoopRef(String key, List<String> list, String pk) {
		List<BaseAbstratPlugin> plus = getRefPlugin(key);
		for (BaseAbstratPlugin baseAbstratPlugin : plus) {
			String parentKey = baseAbstratPlugin.getPluginId();
			list.add(parentKey);
			if(list.contains(key)){
				throw new IllegalArgumentException("插件 "+key+" 和插件 "+parentKey+" 存在回环引用");
			}
			internalCheckLoopRef(key, list,parentKey);
		}
	}

	/**
	 * 扫描系统中所有的插件定义XML
	 * @return
	 */
	private List<BaseAbstratPlugin> internalLoadPlugins() {
		return null;
	}
	
	/**
	 * 移除插件
	 * TODO
	 */
	public void removePlugin(){
		//no-support
	}
	
	
	/**
	 * 获取直接依赖指定插件的插件列表
	 */
	public List<BaseAbstratPlugin> getRefPlugin(String refId){
		List<BaseAbstratPlugin> plugins = new ArrayList<BaseAbstratPlugin>();
		for (BaseAbstratPlugin plg : allPlugins) {
			if(plg.getRefPluginsIds().contains(refId)){
				plugins.add(plg);
			}
		}
		return plugins;
	}
	
}
