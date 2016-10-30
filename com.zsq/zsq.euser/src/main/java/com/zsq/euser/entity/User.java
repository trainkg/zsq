package com.zsq.euser.entity;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * 基本人员信息
 * 
 * @author peculiar.1@163.com
 * @version $ID: User.java, V1.0.0 2015年3月20日 下午8:37:28 $
 */
public class User implements Principal {

	/*
	 * 用户状态
	 */
	enum UserStatus {
		// 激活,删除,锁定,未激活
		ACTIVE, REMOVED, LOCKED, UNACTIVE
	}
	
	/**
	 * 用户性别
	 * @author zhuyy
	 *
	 */
	enum Sex{
		MAN,FEMALE,OTHER
	}

	public User() {
	}

	public User(String name, String password) {
		this.username = name;
		this.password = password;
	}

	private String id;

	/**
	 * 用户别名
	 */
	private String username;

	/**
	 * 用户登陆名使用 全局唯一
	 */
	private String loginName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 性别
	 */
	private Sex sex;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 地址
	 */
	private String homeaddress;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 用户状态
	 */
	private UserStatus status;

	/**
	 * 创建时间
	 */
	private Date createDate;

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

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
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

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
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

	public String getName() {
		return getId();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}