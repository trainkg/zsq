package com.zsq.cms.dao;

import com.zsq.cms.entity.ArticleColumn;

public interface ArticleColumnMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleColumn record);

    int insertSelective(ArticleColumn record);

    ArticleColumn selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleColumn record);

    int updateByPrimaryKey(ArticleColumn record);
}