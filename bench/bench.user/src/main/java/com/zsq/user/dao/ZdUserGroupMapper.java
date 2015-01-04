package com.zsq.user.dao;

import com.zsq.user.entity.ZdUserGroup;

public interface ZdUserGroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZdUserGroup record);

    int insertSelective(ZdUserGroup record);

    ZdUserGroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZdUserGroup record);

    int updateByPrimaryKey(ZdUserGroup record);
}