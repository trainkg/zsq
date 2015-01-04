package com.zsq.th3.dao;

import com.zsq.th3.entity.SiteRefLink;

public interface SiteRefLinkMapper {
    int deleteByPrimaryKey(String id);

    int insert(SiteRefLink record);

    int insertSelective(SiteRefLink record);

    SiteRefLink selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SiteRefLink record);

    int updateByPrimaryKeyWithBLOBs(SiteRefLink record);

    int updateByPrimaryKey(SiteRefLink record);
}