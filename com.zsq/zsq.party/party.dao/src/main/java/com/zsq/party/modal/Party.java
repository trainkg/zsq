package com.zsq.party.modal;

import lombok.Getter;
import lombok.Setter;

/**
 * party 基础信息 
 * @author peculiar.1@163.com
 * @version $ID: Party.java, V1.0.0 2018年10月1日 上午11:13:46 $
 */
@Getter
@Setter
public class Party {
	
	/**
	 * 主键 
	 */
	private Long partyId;
	
	/**
	 * 别名
	 */
	private String partyName;
	
	/**
	 * 真实名称
	 */
	private String realName;
	
	private String code;
}
