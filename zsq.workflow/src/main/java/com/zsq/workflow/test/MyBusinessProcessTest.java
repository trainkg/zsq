package com.zsq.workflow.test;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
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

  /*@Autowired
  @Rule
  public ActivitiRule activitiSpringRule;*/

  @Test
  @Deployment
  public void simpleProcessTest() {
	Map<String,Object> variables = new HashMap<String,Object>();
	
    runtimeService.startProcessInstanceByKey("simpleProcess");
    System.out.println(taskService.createTaskQuery().count());
    /*
    System.out.println(task.getName());
    taskService.complete(task.getId());
    System.out.println(runtimeService.createProcessInstanceQuery().count());;*/
  }
}