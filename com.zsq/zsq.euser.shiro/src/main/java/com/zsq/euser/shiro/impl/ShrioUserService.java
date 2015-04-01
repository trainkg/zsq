package com.zsq.euser.shiro.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.zsq.euser.EncryptService;
import com.zsq.euser.entity.User;
import com.zsq.euser.shiro.IShrioUserService;

@Service
public class ShrioUserService implements IShrioUserService {
	
	@Autowired
	private EncryptService<User, String> seEncry;
	
	public void login(String name, String password) {
		Assert.notNull(name);
		Assert.notNull(password);
		User user = new User(name,password);
		UsernamePasswordToken token = new UsernamePasswordToken(name, seEncry.encrypt(user));
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()){
			subject.login(token);
		}
	}

}
