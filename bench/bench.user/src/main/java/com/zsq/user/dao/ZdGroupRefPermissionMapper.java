package com.zsq.user.dao;

import com.zsq.user.entity.ZdGroupRefPermission;

public interface ZdGroupRefPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZdGroupRefPermission record);

    int insertSelective(ZdGroupRefPermission record);

    ZdGroupRefPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZdGroupRefPermission record);

    int updateByPrimaryKey(ZdGroupRefPermission record);
}