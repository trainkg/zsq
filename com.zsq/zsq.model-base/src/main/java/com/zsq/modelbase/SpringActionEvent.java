/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.modelbase;

import org.springframework.context.ApplicationEvent;

/**
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: SpringActionEvent.java, V1.0.0 2015年3月21日 下午8:16:06 $
 */
public abstract class SpringActionEvent extends ApplicationEvent implements
		ActionEvent {

	private static final long serialVersionUID = 1L;
	private EventAction action;
	
	public SpringActionEvent(Object source,EventAction action) {
		super(source);
		this.action = action;
	}

	public EventAction getAction() {
		return action;
	}

	public void setAction(EventAction action) {
		this.action = action;
	}

}
