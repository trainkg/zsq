package com.zsq.th3.dao;

import com.zsq.th3.entity.Poster;

public interface PosterMapper {
    int deleteByPrimaryKey(String id);

    int insert(Poster record);

    int insertSelective(Poster record);

    Poster selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Poster record);

    int updateByPrimaryKey(Poster record);
}