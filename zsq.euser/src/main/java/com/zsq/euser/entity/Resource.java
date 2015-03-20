package com.zsq.euser.entity;

public class Resource {
	private String id;

	private String name;

	private String code;

	private UserDict type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UserDict getType() {
		return type;
	}

	public void setType(UserDict type) {
		this.type = type;
	}

}