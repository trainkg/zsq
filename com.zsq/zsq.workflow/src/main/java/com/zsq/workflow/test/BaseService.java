package com.zsq.workflow.test;

import org.activiti.engine.delegate.DelegateExecution;

/**
 * 用户自定义相关service 
 * @author zhuyy
 */
public class BaseService {
	
	/**
	 * 无参数service
	 * @param name
	 */
	public void printMessage(DelegateExecution execution,Object myVar){
		System.out.println("[执行] Spring component" + execution);
		System.out.println(execution.getVariable("r2"));
		System.out.println("myVar is" + myVar);
		System.out.println("[执行] 打印名称 ...");
	}
}
