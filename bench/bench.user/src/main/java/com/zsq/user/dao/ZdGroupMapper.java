package com.zsq.user.dao;

import com.zsq.user.entity.ZdGroup;

public interface ZdGroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZdGroup record);

    int insertSelective(ZdGroup record);

    ZdGroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZdGroup record);

    int updateByPrimaryKey(ZdGroup record);
}