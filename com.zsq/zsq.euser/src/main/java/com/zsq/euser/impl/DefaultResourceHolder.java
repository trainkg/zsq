/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.zsq.euser.IEUserService;
import com.zsq.euser.ResourceHolder;
import com.zsq.euser.entity.Resource;
import com.zsq.euser.entity.User;

/**
 * 抓取资源默认实现
 * 
 * @author peculiar.1@163.com
 * @version $ID: DefaultResourceHolder.java, V1.0.0 2015年3月21日 下午7:15:08 $
 */
public class DefaultResourceHolder implements ResourceHolder {

	@Autowired
	private IEUserService seEuser;
	
	public List<Resource> getUserResource(User user) {
		Assert.notNull(user);
		return seEuser.getUserResources(user.getId());
	}

}
