package org.zsq.gui.app.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 常规DB链接
 * @author Administrator
 */
@Getter
@Setter
public class DBConfig {
	
	private String name;
	private String host;
	private int port;
	private String username;
	private String password;
	private boolean savePass;
	
}
