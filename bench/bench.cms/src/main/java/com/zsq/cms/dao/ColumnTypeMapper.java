package com.zsq.cms.dao;

import com.zsq.cms.entity.ColumnType;

public interface ColumnTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ColumnType record);

    int insertSelective(ColumnType record);

    ColumnType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ColumnType record);

    int updateByPrimaryKey(ColumnType record);
}