/**
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser.dao;

import com.zsq.euser.entity.User;
import com.zsq.modelbase.Page;

/**
 * 用户查询封装
 * 
 * @author peculiar.1@163.com
 * @version $ID: UserSearchVO.java, V1.0.0 2015年3月19日 下午9:54:37 $
 */
public class UserSearchVO extends Page<User> {

	/**
	 * 人员所在状态列表
	 */
	private int[] status;

	private String name;

	public int[] getStatus() {
		return status;
	}

	public void setStatus(int[] status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
