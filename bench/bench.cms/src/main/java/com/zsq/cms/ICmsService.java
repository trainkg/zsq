package com.zsq.cms;

public interface ICmsService {
	
	/**
	 * 删除CMS 模块和指定用户有关的信息
	 * @param id
	 */
	public void deleteByUserId(String id);
}
