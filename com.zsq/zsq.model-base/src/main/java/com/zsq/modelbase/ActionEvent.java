/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.modelbase;

/**
 * 带有常用的操作的事件对象  如删除 修改 删除等
 * 
 * @author peculiar.1@163.com
 * @version $ID: ActionEvent.java, V1.0.0 2015年3月21日 下午8:10:23 $
 */
public interface ActionEvent {
	/**
	 * 时间对象行为定义
	 */
	public enum EventAction {
		ADD, DELETE, UPDATE
	}
	
	public EventAction getAction();
}
