package com.zsq.euser;

/**
 * 加密接口
 * @author zhuyy
 */
public interface EncryptService<O,T> {
	
	/**
	 * 加密服务
	 * @param object
	 * @return
	 */
	public T encrypt(O object);
}
