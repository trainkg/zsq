package com.zsq.party.service.code.impl;

import com.zsq.party.service.code.AbstractPartyCodeGenerator;
import com.zsq.party.service.code.CodeGenerator;

/**
 * Default party code generator.
 * 
 * @author peculiar.1@163.com
 * @version $ID: DefaultCodeGenerator.java, V1.0.0 2018年10月1日 上午11:29:18 $
 */
public class DefaultCodeGenerator extends AbstractPartyCodeGenerator implements
		CodeGenerator {
	
	@Override
	public String generateCode() {
		return getPartyName();
	}

}
