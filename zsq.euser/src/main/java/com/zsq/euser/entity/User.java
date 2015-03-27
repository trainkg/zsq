package com.zsq.euser.entity;

import java.util.List;

/**
 * 基本人员信息
 * 
 * @author peculiar.1@163.com
 * @version $ID: User.java, V1.0.0 2015年3月20日 下午8:37:28 $
 */
public class User {

	private String id;

	private String username;

	/**
	 * 用户登陆名使用 全局唯一
	 */
	private String loginName;

	private String password;

	private Short sex;

	private String email;

	private String homeaddress;

	private String phone;

	private int status;

	/**
	 * 用户拥有的资源列表
	 */
	private List<Resource> userResource;

	/**
	 * 用户拥有的角色列表
	 */
	private List<Role> roles;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Resource> getUserResource() {
		return userResource;
	}

	public void setUserResource(List<Resource> userResource) {
		this.userResource = userResource;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}