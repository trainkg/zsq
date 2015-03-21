/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser;


import org.springframework.util.Assert;

import com.zsq.euser.entity.User;
import com.zsq.modelbase.SpringActionEvent;

/**
 * 用户事件
 * 
 * @author peculiar.1@163.com
 * @version $ID: UserEvent.java, V1.0.0 2015年3月21日 下午8:12:15 $
 */
public class UserEvent extends SpringActionEvent{

	private static final long serialVersionUID = 1L;
	/**
	 * 事件关联对象
	 */
	private User user;

	/**
	 * 默认行为是删除
	 */
	public UserEvent(Object source, User user) {
		super(source,EventAction.DELETE);
		this.user = user;
	}

	public UserEvent(Object source, User user, EventAction action) {
		super(source,action);
		Assert.notNull(user);
		Assert.notNull(action);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
