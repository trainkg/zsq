/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package zsq.file.core;

import javax.jcr.GuestCredentials;
import javax.jcr.Repository;
import javax.jcr.Session;

import org.apache.jackrabbit.commons.JcrUtils;

/**
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: Main.java, V1.0.0 2015年3月29日 下午7:46:39 $
 */
public class MainApplication {
	
	public static void main(String[] args) throws Exception {
		Repository repository = JcrUtils.getRepository(); 
		Session session = repository.login(new GuestCredentials()); 
		try { 
		String user = session.getUserID(); 
		String name = repository.getDescriptor(Repository.REP_NAME_DESC); 
		System.out.println( 
		"Logged in as " + user + " to a " + name + " repository."); 
		} finally { 
		session.logout(); 
		} 
	}
}
