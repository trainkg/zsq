/**
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser.dao;

import java.util.List;

/**
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: Resource.java, V1.0.0 2015年3月14日 下午9:25:25 $
 */
public class Resource {

	private String id;

	private String name;

	/**
	 * 资源编号 唯一
	 */
	private String code;

	/**
	 * 资源类型
	 */
	private ResouceTypeMapper type;

	/**
	 * 拥有该资源的角色列表
	 */
	private List<Role> roles;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ResouceTypeMapper getType() {
		return type;
	}

	public void setType(ResouceTypeMapper type) {
		this.type = type;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
