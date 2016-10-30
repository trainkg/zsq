package com.zsq.euser.dao;

import java.util.List;

import com.zsq.euser.entity.Role;

public interface RoleMapper {
	int deleteByPrimaryKey(String id);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	/**
	 * 获取一个人的相关角色设定, 只包含直接关联的角色
	 * @param userId
	 * @return 用户关联所有角色信息列表
	 */
	List<Role> getUserRoles(String userId);

	/**
	 * 返回系统所有的角色信息列表
	 * @return
	 */
	List<Role> getAllRoles();
}