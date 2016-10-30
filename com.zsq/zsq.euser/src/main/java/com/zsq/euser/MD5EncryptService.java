/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.euser;


/**
 * 系统用户加密服务
 * @author peculiar.1@163.com
 * @version $ID: MD5EncryptService.java, V1.0.0 2015年3月28日 下午2:27:18 $
 */
public class MD5EncryptService implements EncryptService{

	/* (non-Javadoc)
	 * @see com.zsq.euser.EncryptService#Encrypt(java.lang.Object)
	 */
	public String encrypt(String plaintext ) {
		return plaintext;
	}

}
