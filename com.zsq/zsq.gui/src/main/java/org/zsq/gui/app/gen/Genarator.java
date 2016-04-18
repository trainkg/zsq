package org.zsq.gui.app.gen;

public interface Genarator {
	
	/**
	 * 根据表生成配置生成相关的信息
	 * @param config
	 */
	public void genaratorIfNeed(GenContext context,TableGenConfig config);
}
