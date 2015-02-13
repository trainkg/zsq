package com.zsq.workflow.test;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * JAVA 任务
 * 
 * @author zhuyy
 */
public class JavaServiceTask implements JavaDelegate {

	private Expression name;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("[执行] JAVA service task. " + name.getExpressionText());
	}

	public void setName(Expression name) {
		this.name = name;
	}

}
