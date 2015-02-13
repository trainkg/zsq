package com.zsq.workflow.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-context.xml")
public class MyBusinessProcessTest {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	/*
	 * @Autowired
	 * 
	 * @Rule public ActivitiRule activitiSpringRule;
	 */

	@Test
	@Deployment
	public void simpleProcessTest() {
		Map<String, Object> variables = new HashMap<String, Object>();

		fillProccessVariables(variables);
		ProcessInstance instance = runtimeService.startProcessInstanceByKey("simpleProcess",variables);
		System.out.println(taskService.createTaskQuery().count());
		/*
		 * System.out.println(task.getName());
		 * taskService.complete(task.getId());
		 * System.out.println(runtimeService.
		 * createProcessInstanceQuery().count());;
		 */
	}

	/**
	 * 填充流程启动参数
	 * 
	 * @param variables
	 */
	private void fillProccessVariables(Map<String, Object> variables) {
		variables.put("a1", "test1");
		variables.put("a2", 1);
		variables.put("a3", new ArrayList<String>());
		variables.put("echo", "System.out.println(\"定义在JAVA代码中的打印信息\")");
//		variables.put("seBean", new JavaServiceTask());
	}
}