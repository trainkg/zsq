/**
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser;

import java.util.List;
import java.util.Map;

import com.zsq.euser.dao.UserSearchVO;
import com.zsq.euser.entity.Resource;
import com.zsq.euser.entity.Role;
import com.zsq.euser.entity.User;

/**
 * 基本用户信息模块
 * 
 * @author peculiar.1@163.com
 * @version $ID: IEUserService.java, V1.0.0 2015年3月14日 下午9:32:31 $
 */
public abstract interface IEUserService {

	/**
	 * 根据用户ID 加载用户信息
	 * 
	 * @param userId
	 */
	public User findUserById(String userId);

	/**
	 * 通过查询封装VO 查询用户信息
	 * 
	 * @param vo
	 */
	public void searchUserByVO(UserSearchVO vo);

	/**
	 * 获取系统所有活动的用户列表
	 * 
	 * @return
	 */
	public List<User> getAllActiveUser();

	/**
	 * 根据ID 加载角色信息
	 * 
	 * @param roleId
	 * @return
	 */
	public Role findRoleById(String roleId);

	/**
	 * 查询用户的关联角色列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<Role> getUserRoles(String userId);

	/**
	 * 获取系统所有的角色列表
	 */
	public List<Role> getAllRoles();

	/**
	 * 获取系统所有的资源信息
	 * 
	 * @return List<Resource>
	 */
	public List<Resource> getAllResources();

	/**
	 * 获取系统所有的资源列表信息 按照资源类型划分
	 * 
	 * @return key-value key:类型ID,value:对应的资源列表
	 */
	public Map<String, List<Resource>> getAllResourcesForMap();

	/**
	 * 获取角色的对应的资源信息列表
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Resource> getRoleResources(String roleId);

	/**
	 * 获取人员的对应的资源信息列表
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Resource> getUserResources(String userId);

	/**
	 * 获取多个角色对应的资源列表, 将会排除重复的资源列表信息
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Resource> getRoleResources(String[] roleIds);

	/**
	 * 获取角色列表分别对应的权限列表, 按照角色划分
	 * 
	 * @param roleids
	 * @return
	 */
	public Map<String, List<Resource>> getRolesResources(String[] roleids);

	/**
	 * 获取拥有指定资源信息的所有角色列表
	 * 
	 * @param resourceId
	 * @return
	 */
	public List<Role> getHasRousourceRoles(String resourceId);
	
	/**
	 * 根据resourceid 加载对应的资源信息
	 * @param rid 资源ID
	 * @return
	 */
	public Resource getResourceById(String rid);
	
	/**
	 * 添加用户
	 * 
	 * <br>会广播发出添加人员信息事件
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 根据登录名查询用户信息
	 * @param loginName
	 * @return
	 */
	public User findUserByLoginName(String loginName);
	
}
