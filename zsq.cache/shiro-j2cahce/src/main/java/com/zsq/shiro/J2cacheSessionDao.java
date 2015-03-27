package com.zsq.shiro;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

/**
 * session DAO 
 * @author zhuyy
 */
public class J2cacheSessionDao extends CachingSessionDAO {

	@Override
	protected void doUpdate(Session session) {
		
	}

	@Override
	protected void doDelete(Session session) {
		
	}

	@Override
	protected Serializable doCreate(Session session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
