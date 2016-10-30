package com.zsq.workflow.test;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

public class MyEventListener implements ActivitiEventListener {

	@Override
	public void onEvent(ActivitiEvent event) {
		System.out.println("event type ================================="+event.getType());
		System.out.println("=================================="+event.getExecutionId());
		switch (event.getType()) {
		case JOB_EXECUTION_SUCCESS:
			System.out.println("完成任务");
			break;
		default:
			break;
		}
	}

	@Override
	public boolean isFailOnException() {
		return false;
	}

}
