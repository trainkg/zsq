package com.zsq.om;

import com.zsq.om.entity.Organization;
import com.zsq.om.entity.OrganizationSearchVO;

/**
 * 基本组织对外接口开放 
 * @author zhuyy
 */
public interface OrgBaseService {
	
	/**
	 * 获取ID对应的组织信息,只包含自身信息
	 * @param id 组织ID
	 * @return Organization
	 */
	public Organization findById(String id);
	
	/**
	 * 获取指定ID下面的所有的组织类型
	 * @param id
	 * @return
	 */
	public Organization findAllSubOrganization(String id);
	
	/**
	 * 创建一个组织信息
	 * @param org
	 * @return 创建后的信息
	 */
	public Organization createOrg(Organization org);
	
	/**
	 * 删除指定ID的组织
	 * @param id 被删除对象的ID
	 * @param keep 是否需要保留子节点,当KEEP为true的时候保留,否则子节点全部一并删除
	 */
	public void deleteById(String id, boolean keep);
	
	
	/**
	 * 根据封装好的VO条件查询组织信息
	 * @param vo
	 */
	public void seachByVO(OrganizationSearchVO vo);
}
