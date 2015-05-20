package com.zsq.user.entity;

import com.zsq.euser.entity.User;

/**
 * 用户基本信息扩展 -- 教育相关
 * 
 * @author zhuyy
 */
public class UserInfo {
	
	private User user;
	/**
	 * 学位
	 */
	private String degree;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

}
