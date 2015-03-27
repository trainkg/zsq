package com.zsq.shiro;

import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * J2cache Manager
 * @author zhuyy
 *
 */
public class J2CacheManager  implements CacheManager{
	
	private J2cache cache;
	
	@SuppressWarnings("unchecked")
	@Override
	public J2cache getCache(String name) throws CacheException {
		if(cache == null){
			cache = new J2cache();
		}
		return cache;
	}


}
