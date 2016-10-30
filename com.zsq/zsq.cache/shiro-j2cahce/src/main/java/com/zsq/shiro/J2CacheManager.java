package com.zsq.shiro;

import net.oschina.j2cache.CacheChannel;

import org.apache.shiro.ShiroException;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * J2cache Manager
 * @author zhuyy
 *
 */
public class J2CacheManager implements CacheManager,Initializable,Destroyable{
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	private J2cache cache;
	
	@Override
	public J2cache getCache(String name) throws CacheException {
		if(log.isTraceEnabled()){
			log.trace("get cache name is {}", name);
		}
		System.out.println("===============================================");
		System.out.println("===============================================");
		System.out.println("===============================================");
		System.out.println("=============get cahe name "+name+"============");
		System.out.println("===============================================");
		System.out.println("===============================================");
		System.out.println("===============================================");
		System.out.println("===============================================");
		if(cache == null){
			cache = new J2cache(CacheChannel.getInstance());
		}
		return cache;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("============================ close cacleManager -------------------- ");
		log.info("distory J2CacheManager");
		cache.getChannel().close();
	}

	@Override
	public void init() throws ShiroException {
		log.info("init J2CacheManager");
	}


}
