package zsq.triankg.core;

import zsq.triankg.core.plugin.PluginManager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * 系统上下文
 * 
 * @author peculiar.1@163.com
 * @version $ID: ApplicatonContext.java, V1.0.0 2016年4月21日 下午8:16:25 $
 */
@Getter
@Setter
@NoArgsConstructor
public class ApplicatonContext {
	private PluginManager pluginManager;
}
