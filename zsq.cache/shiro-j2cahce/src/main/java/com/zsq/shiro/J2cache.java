package com.zsq.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;

import org.apache.shiro.ShiroException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于OSCHINA的J2cache实现shiro的cache实现 利用j2cache L1 L2,以及分布式特性
 * 
 * @author zhuyy
 * 
 * @param <K>
 * @param <V>
 */
public class J2cache implements Cache<Object, CacheObject> {

	/**
	 * J2cache channel
	 */
	private Logger log = LoggerFactory.getLogger(getClass());
	private CacheChannel channel;
	public static final String DEFALT_REGION = "#ZSQ_SHIRO#";
	private String region = DEFALT_REGION;

	public CacheChannel getChannel() {
		return channel;
	}

	public void setChannel(CacheChannel channel) {
		this.channel = channel;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public CacheObject get(Object key) throws CacheException {
		return channel.get(getRegion(), key);
	}

	@Override
	public CacheObject put(Object key, CacheObject value) throws CacheException {
		channel.set(getRegion(), key, value);
		return value;
	}

	@Override
	public CacheObject remove(Object key) throws CacheException {
		channel.evict(getRegion(), key);
		return null;
	}

	@Override
	public void clear() throws CacheException {
		channel.clear(getRegion());
	}

	@Override
	public int size() {
		return keys().size();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<Object> keys() {
		// TODO Auto-generated method stub
		try {
			List keys = channel.keys(getRegion());
			if (!CollectionUtils.isEmpty(keys)) {
                return Collections.unmodifiableSet(new LinkedHashSet<Object>(keys));
            } else {
                return Collections.emptySet();
            }
		} catch (Exception e) {
			throw new ShiroException(e);
		}
	}

	@Override
	public Collection<CacheObject> values() {
		if (log.isTraceEnabled()) {
            log.trace("获取所有的值");
        }
		try {
			Set<Object> keys = keys();
			if(!CollectionUtils.isEmpty(keys)){
				List<CacheObject> list = new ArrayList<CacheObject>();
				for (Object key : keys) {
					list.add(get(key));
				}
				 return Collections.unmodifiableList(list);
			}else{
				return Collections.emptyList();
			}
		} catch (CacheException e) {
			throw new ShiroException(e);
		}
	}

}
