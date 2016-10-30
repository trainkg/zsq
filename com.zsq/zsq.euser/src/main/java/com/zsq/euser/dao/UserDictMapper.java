package com.zsq.euser.dao;

import com.zsq.euser.entity.UserDict;

public interface UserDictMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserDict record);

    int insertSelective(UserDict record);

    UserDict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserDict record);

    int updateByPrimaryKey(UserDict record);
}