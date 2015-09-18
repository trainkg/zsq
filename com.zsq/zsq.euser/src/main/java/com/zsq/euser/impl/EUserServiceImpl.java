/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.zsq.euser.EncryptService;
import com.zsq.euser.IEUserService;
import com.zsq.euser.UserEvent;
import com.zsq.euser.dao.ResourceMapper;
import com.zsq.euser.dao.RoleMapper;
import com.zsq.euser.dao.UserMapper;
import com.zsq.euser.dao.UserSearchVO;
import com.zsq.euser.entity.Resource;
import com.zsq.euser.entity.Role;
import com.zsq.euser.entity.User;
import com.zsq.euser.entity.UserDict;
import com.zsq.modelbase.ActionEvent.EventAction;
import com.zsq.modelbase.EventService;

/**
 * 基本用户信息实现
 * 
 * 如果项目中只需要使用基础USER模块, 那么需要在在spring的配置文件中声明该BEAN
 * 
 * @author peculiar.1@163.com
 * @version $ID: EUserServiceImpl.java, V1.0.0 2015年3月20日 下午8:06:27 $
 */
public class EUserServiceImpl extends EventService implements IEUserService {

	@Autowired
	protected UserMapper daoUser;
	@Autowired
	protected ResourceMapper daoRes;
	@Autowired
	protected RoleMapper daoRole;
	@Autowired
	protected EncryptService<?, ?> seEncrypt;

	public User findUserById(String userId) {
		Assert.notNull(userId);
		return daoUser.selectByPrimaryKey(userId);
	}

	public void searchUserByVO(UserSearchVO vo) {

	}

	public List<User> getAllActiveUser() {
		return null;
	}

	public Role findRoleById(String roleId) {
		Assert.notNull(roleId);
		return daoRole.selectByPrimaryKey(roleId);
	}

	public List<Role> getUserRoles(String userId) {
		Assert.notNull(userId);
		return daoRole.getUserRoles(userId);
	}

	public List<Role> getAllRoles() {
		return daoRole.getAllRoles();
	}

	public List<Resource> getAllResources() {
		return daoRes.getAllResources();
	}

	public Map<String, List<Resource>> getAllResourcesForMap() {
		List<Resource> list = getAllResources();
		Map<String, List<Resource>> map = new HashMap<String, List<Resource>>();
		for (Resource resource : list) {
			UserDict type = resource.getType();
			String tid = type.getId();
			List<Resource> rlist = map.get(tid);
			if (rlist == null) {
				rlist = new ArrayList<Resource>();
				map.put(tid, rlist);
			}
			rlist.add(resource);
		}
		return map;
	}

	public List<Resource> getRoleResources(String roleId) {
		Assert.notNull(roleId);
		return daoRes.getRoleResources(roleId);
	}

	public List<Resource> getUserResources(String userId) {
		return null;
	}

	public List<Resource> getRoleResources(String[] roleIds) {
		return null;
	}

	public Map<String, List<Resource>> getRolesResources(String[] roleids) {
		return null;
	}

	public List<Role> getHasRousourceRoles(String resourceId) {
		return null;
	}

	public Resource getResourceById(String rid) {
		Assert.notNull(rid);
		return daoRes.selectByPrimaryKey(rid);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void addUser(User user) {
		daoUser.insert(user);
		publisher.publishEvent(new UserEvent(this, user, EventAction.ADD));
	}
	
	public User findUserByLoginName(String loginName) {
		Assert.notNull(loginName);
		return daoUser.findUserByLoginName(loginName);
	}

}
