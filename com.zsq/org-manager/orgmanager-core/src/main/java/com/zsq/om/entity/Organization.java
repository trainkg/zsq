package com.zsq.om.entity;

import java.util.List;

/**
 * 基础 ORG
 * 
 * @author TrainKG
 */
public class Organization {

	private String id;
	/**
	 * 上级的组织结构
	 */
	private Organization parent;

	/**
	 * 组织编号
	 */
	private String orgCode;

	/**
	 * 组织名称
	 */
	private String orgName;

	/**
	 * 子节点列表
	 */
	private List<Organization> subNodeList;

	/**
	 * 是否是顶级节点
	 * 
	 * @return
	 */
	public boolean isTop() {
		return getParent() == null;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public List<Organization> getSubNodeList() {
		return subNodeList;
	}

	public void setSubNodeList(List<Organization> subNodeList) {
		this.subNodeList = subNodeList;
	}

}
