package com.zsq.user.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.zsq.core.spring.EventService;
import com.zsq.euser.dao.UserMapper;
import com.zsq.user.IUserService;
import com.zsq.user.UserDeleteEvent;

/**
 * 内部实现 
 * 
 * @author zhuyy
 */
@Service
@Transactional
public class UserServiceImpl extends EventService implements IUserService{
	
	@Autowired
	private UserMapper daoUser;
	
	@Override
	public void deleteUserById(String id) {
		log.info("[开始] 删除用户 {}",id);
		Assert.notNull(id);
		System.out.println(daoUser.selectByPrimaryKey("1"));
		UserDeleteEvent deleteEvent = new UserDeleteEvent(this, id);
		publisher.publishEvent(deleteEvent);
		//do-something
		log.info("[结束] 删除用户");
	}
	
}
