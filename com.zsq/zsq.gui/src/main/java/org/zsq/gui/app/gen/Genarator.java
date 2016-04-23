package org.zsq.gui.app.gen;

import org.zsq.gui.app.db.ddl.TableDDLInfo;

import zsq.triankg.core.ZsqException;


public interface Genarator {
	/**
	 * 根据表生成配置生成相关的信息
	 * @param config
	 */
	public void genaratorIfNeed(GenContext context, TableDDLInfo config) throws ZsqException;
	
	/**
	 * 判断当前生成器是否对配置敏感
	 * @param context
	 * @param config
	 */
	public boolean careConfig(GenContext context, TableDDLInfo config) throws ZsqException;
	
}
