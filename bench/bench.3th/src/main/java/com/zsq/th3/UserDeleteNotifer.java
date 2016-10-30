package com.zsq.th3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.zsq.user.UserDeleteEvent;

/**
 * CMS 模块删除用户监听
 * @author zhuyy
 */
@Component("th3UserDeleteNotifer")
public class UserDeleteNotifer implements ApplicationListener<UserDeleteEvent> {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	
	@Override
	public void onApplicationEvent(UserDeleteEvent event) {
		String id = event.getUserId();
		log.info("[3th]接受到删除用户事件 删除用户ID {}",id);
		log.info("[3th]删除本模块和此用户有关的信息");
	}

}
