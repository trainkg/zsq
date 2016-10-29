package org.zsq.gui.app.web.vo;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class DBConnectConfig {

	@JsonProperty("text")
	private String dbName;
	private String group;

	public DBConnectConfig() {
	}

	public DBConnectConfig(String dbName) {
		this.dbName = dbName;
	}
}
