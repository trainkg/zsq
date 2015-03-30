/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser;

import javax.validation.constraints.NotNull;

/**
 * 
 * 简单登陆表单信息
 * 
 * @author peculiar.1@163.com
 * @version $ID: LoginForm.java, V1.0.0 2015年3月28日 下午5:33:50 $
 */
public class SimpleLoginForm {

	@NotNull
	private String userName;
	
	@NotNull
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
