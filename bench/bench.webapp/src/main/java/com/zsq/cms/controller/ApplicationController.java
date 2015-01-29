package com.zsq.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsq.user.IUserService;

/**
 * 系統application控制器 
 * @author zhuyy
 */
@Controller
@RequestMapping("/test")
public class ApplicationController extends BaseAction {
	
	@Autowired
	private IUserService seUser;
	/**
	 * 系统根页面
	 */
	@RequestMapping("t1")
	public String systemIndex1(){
		seUser.deleteUserById("1");
		return "/index";
	}
	
	/**
	 * 系统根页面
	 */
	@RequestMapping("t2")
	public String systemIndex(){
		return "/index";
	}
	
}
