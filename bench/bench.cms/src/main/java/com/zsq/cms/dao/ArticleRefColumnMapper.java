package com.zsq.cms.dao;

import com.zsq.cms.entity.ArticleRefColumn;

public interface ArticleRefColumnMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleRefColumn record);

    int insertSelective(ArticleRefColumn record);

    ArticleRefColumn selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleRefColumn record);

    int updateByPrimaryKey(ArticleRefColumn record);
}