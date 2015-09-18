package com.zsq.euser.shiro;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 用户相关,抽象系统的登录服务
 */
public interface IShrioUserService {

	/**
	 * 区域普通的用户名加密码的登陆
	 * <br> 包含全局的SESSION用户信息初始化
	 * @throws AuthenticationException shiro 框架的登录失败异常信息
	 */
	public void login(String name,String password) throws AuthenticationException;
	
}
