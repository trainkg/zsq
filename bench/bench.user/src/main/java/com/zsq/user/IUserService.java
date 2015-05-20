package com.zsq.user;

import com.zsq.euser.IEUserService;

public interface IUserService extends IEUserService {
	
	/**
	 * 根据id 删除系统用户, 同时向整个系统广播删除用户ID业务事件
	 * @param id
	 */
	public void deleteUserById(String id);
}
