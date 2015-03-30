package com.zsq.workflow.test;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventDispatcher;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;

public class DispatchEventListener implements ActivitiEventDispatcher {

	@Override
	public void addEventListener(ActivitiEventListener listenerToAdd) {
		
	}

	@Override
	public void addEventListener(ActivitiEventListener listenerToAdd,
			ActivitiEventType... types) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEventListener(ActivitiEventListener listenerToRemove) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispatchEvent(ActivitiEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
