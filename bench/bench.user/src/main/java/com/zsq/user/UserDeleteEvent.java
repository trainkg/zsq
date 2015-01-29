package com.zsq.user;

import org.springframework.context.ApplicationEvent;

/**
 * 用户模块的删除用户事件 
 * @author zhuyy
 */
public class UserDeleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 被删除的用户ID 
	 */
	private final String userId;
	
	public UserDeleteEvent(Object source,String id) {
		super(source);
		this.userId = id;
	}

	public String getUserId() {
		return userId;
	}
	
	
	
}
