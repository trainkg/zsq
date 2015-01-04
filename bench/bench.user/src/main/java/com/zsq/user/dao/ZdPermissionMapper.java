package com.zsq.user.dao;

import com.zsq.user.entity.ZdPermission;

public interface ZdPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZdPermission record);

    int insertSelective(ZdPermission record);

    ZdPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZdPermission record);

    int updateByPrimaryKey(ZdPermission record);
}