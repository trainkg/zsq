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
		System.out.println("JavaServiceTask execution is "+ execution);
		System.out.println("[执行] JAVA service task. " + name.getExpressionText());
		execution.setVariable("r2", "test return info defined in process");
	}

	public void setName(Expression name) {
		this.name = name;
	}

}
