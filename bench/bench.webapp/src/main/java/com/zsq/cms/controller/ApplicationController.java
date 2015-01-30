package com.zsq.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zsq.cms.BaseAction;
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
	@RequestMapping(value="t1",method={RequestMethod.GET})
	public String systemIndex1(){
		seUser.deleteUserById("1");
		return "index";
	}
	
	/**
	 * 系统根页面
	 */
	@RequestMapping(value="t1",method={RequestMethod.POST})
	public String systemIndex2(){
		seUser.deleteUserById("1");
		return "index";
	}
	
	/**
	 * 系统根页面
	 */
	@RequestMapping("t2")
	public String systemIndex(){
		return "/index";
	}
	
}