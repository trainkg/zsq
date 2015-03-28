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
		log.info("update shiro session {}",session);
	}

	@Override
	protected void doDelete(Session session) {
		log.info("delete shiro session {}",session);
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		log.info("create shiro session {}", session);
		assignSessionId(session, sessionId);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		log.debug("read shiro session id {}",sessionId);
		return null;
	}

}
