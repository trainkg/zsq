package com.zsq.core.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * 支持发出事件的service 
 * @author zhuyy
 */
public abstract class EventService implements ApplicationEventPublisherAware {
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 事件发布器
	 */
	protected ApplicationEventPublisher publisher;
	
	public EventService() {
	}

	@Override
	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
	
}
