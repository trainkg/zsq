/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.zsq.euser.IEUserService;
import com.zsq.euser.dao.ResourceMapper;
import com.zsq.euser.dao.UserMapper;
import com.zsq.euser.dao.UserSearchVO;
import com.zsq.euser.entity.Resource;
import com.zsq.euser.entity.Role;
import com.zsq.euser.entity.User;

/**
 * 基本用户信息实现
 * @author peculiar.1@163.com
 * @version $ID: EUserServiceImpl.java, V1.0.0 2015年3月20日 下午8:06:27 $
 */
@Service
public class EUserServiceImpl implements IEUserService {

	@Autowired
	private UserMapper daoUser;
	@Autowired
	private ResourceMapper daoRes;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> getUserRoles(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Resource> getAllResources() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, List<Resource>> getAllResourcesForMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Resource> getRoleResources(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Resource> getUserResources(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Resource> getRoleResources(String[] roleIds) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, List<Resource>> getRolesResources(String[] roleids) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> getHasRousourceRoles(String resourceId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource getResourceById(String rid) {
		Assert.notNull(rid);
		return daoRes.selectByPrimaryKey(rid);
	}
	

}
