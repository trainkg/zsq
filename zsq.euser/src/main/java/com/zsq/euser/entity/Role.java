/**
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser.entity;

import java.util.List;

/**
 * 角色
 * 
 * @author peculiar.1@163.com
 * @version $ID: Role.java, V1.0.0 2015年3月14日 下午9:21:46 $
 */
public class Role {

	private String id;
	private String name;
	/**
	 * 角色关联用户列表
	 */
	private List<User> users;
	/**
	 * 角色拥有资源列表
	 */
	private List<Resource> resources;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

}
