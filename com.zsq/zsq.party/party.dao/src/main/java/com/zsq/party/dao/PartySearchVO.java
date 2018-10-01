package com.zsq.party.dao;

import lombok.Getter;
import lombok.Setter;

import com.zsq.modelbase.Page;
import com.zsq.party.modal.Party;

/**
 * party 查询条件封装
 * @author peculiar.1@163.com
 * @version $ID: PartySearchVO.java, V1.0.0 2018年10月1日 上午11:51:51 $
 */
@Getter
@Setter
public class PartySearchVO extends Page<Party>{
	private String partyName;
}
