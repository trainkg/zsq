/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser;

import java.util.List;

import com.zsq.euser.entity.Resource;
import com.zsq.euser.entity.User;

/**
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: ResourceHolder.java, V1.0.0 2015年3月21日 下午7:10:19 $
 */
public interface ResourceHolder {
	
	/**
	 * 抓起系统的人员相应的权限信息
	 * @return
	 */
	public List<Resource> getUserResource(User user);
}
