package com.zsq.user;

public interface IUserService {
	
	/**
	 * 根据id 删除系统用户, 同时向整个系统广播删除用户ID业务事件
	 * @param id
	 */
	public void deleteUserById(String id);
}
