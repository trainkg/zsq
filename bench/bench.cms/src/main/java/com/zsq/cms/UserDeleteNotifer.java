package com.zsq.cms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.zsq.user.UserDeleteEvent;

/**
 * CMS 模块删除用户监听
 * @author zhuyy
 */
@Component("CMSUserDeleteNotifer")
public class UserDeleteNotifer implements ApplicationListener<UserDeleteEvent> {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ICmsService seCms;
	
	@Override
	public void onApplicationEvent(UserDeleteEvent event) {
		String id = event.getUserId();
		log.info("【CMS】接受到删除用户事件 删除用户ID {}",id);
		seCms.deleteByUserId(id);
		log.info("【CMS】删除本模块和此用户有关的信息");
	}

}
