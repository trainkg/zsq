package com.zsq.euser.dao;

import java.util.List;

import com.zsq.euser.entity.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

	/**
	 * 获取系统所有的资源信息
	 * @return
	 */
	List<Resource> getAllResources();

	/**
	 * 获取一个对应的所有的资源列表
	 * @param roleId
	 * @return
	 */
	List<Resource> getRoleResources(String roleId);
}