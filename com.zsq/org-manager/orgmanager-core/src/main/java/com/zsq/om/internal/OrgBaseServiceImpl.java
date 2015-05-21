package com.zsq.om.internal;

import org.springframework.beans.factory.annotation.Autowired;

import com.zsq.om.OrgBaseService;
import com.zsq.om.dao.OrganizationMapper;
import com.zsq.om.entity.Organization;
import com.zsq.om.entity.OrganizationSearchVO;

/**
 * 基本组织service实现 
 * @author zhuyy
 */
public class OrgBaseServiceImpl implements OrgBaseService {
	
	@Autowired
	protected OrganizationMapper daoOrg;
	
	public Organization findById(String id) {
		return null;
	}

	public Organization findAllSubOrganization(String id) {
		return null;
	}

	public Organization createOrg(Organization org) {
		return null;
	}

	public void deleteById(String id, boolean keep) {

	}

	public void seachByVO(OrganizationSearchVO vo) {

	}

}
