package com.zsq.shiro;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * session DAO 
 * @author zhuyy
 */
public class J2cacheSessionDao extends CachingSessionDAO {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void doUpdate(Session session) {
		log.debug("update shiro session");
	}

	@Override
	protected void doDelete(Session session) {
		log.debug("delete shiro session");
	}

	@Override
	protected Serializable doCreate(Session session) {
		log.debug("create shiro session");
		return null;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		log.debug("read shiro session");
		return null;
	}

}
