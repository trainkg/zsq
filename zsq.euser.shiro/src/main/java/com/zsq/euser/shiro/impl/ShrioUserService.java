package com.zsq.euser.shiro.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.zsq.euser.shiro.IShrioUserService;

@Service
public class ShrioUserService implements IShrioUserService {

	public void login(String name, String password) {
		Assert.notNull(name);
		Assert.notNull(password);
	}

}
