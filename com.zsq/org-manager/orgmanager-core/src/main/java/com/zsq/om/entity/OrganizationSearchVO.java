package com.zsq.om.entity;

import com.zsq.modelbase.Page;

/**
 * 封装好的组织查询对象 
 * @author zhuyy
 */
public class OrganizationSearchVO extends Page<Organization> {
	
	public OrganizationSearchVO(boolean needPage, boolean autoCount) {
		super();
		setNeedPage(needPage);
		setAutoCount(autoCount);
	}
}
