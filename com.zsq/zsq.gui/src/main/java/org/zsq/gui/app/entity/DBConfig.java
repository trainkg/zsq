package org.zsq.gui.app.entity;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 常规DB链接
 * @author Administrator
 * @deprecated
 * 采用整合spring方案,不再管理数据库连接
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
@Deprecated
public class DBConfig {
	private String name;
	private String host;
	private int port = 3306;
	private String username;
	private String password;
	private boolean savePass;
}
