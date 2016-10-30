package com.zsq.euser.dao;

import com.zsq.euser.entity.UserPermission;

public interface UserPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    UserPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);
}