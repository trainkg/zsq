package com.zsq.plat.common.menu;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {
	
	private int id;
	private String code;
	private String name;
	
	/**
	 * 菜单访问对象连接
	 */
	private String uri;
	/**
	 * 执行脚步
	 */
	private String script;
	
	private Menu parent;
	
	/**
	 * 子节点， 排序
	 */
	private List<Menu> chirdrens;
	 
}
