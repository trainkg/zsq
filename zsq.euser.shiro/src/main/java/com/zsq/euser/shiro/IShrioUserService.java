package com.zsq.euser.shiro;

/**
 * 用户相关
 */
public interface IShrioUserService {

	/**
	 * 区域普通的用户名加密码的登陆
	 */
	public void login(String name,String password);
}
