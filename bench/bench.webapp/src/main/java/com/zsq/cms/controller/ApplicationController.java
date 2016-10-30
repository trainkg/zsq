package com.zsq.cms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zsq.cms.BaseAction;
import com.zsq.euser.IEUserService;
import com.zsq.euser.entity.Resource;
import com.zsq.euser.entity.Role;
import com.zsq.euser.entity.User;
import com.zsq.user.IUserService;

/**
 * 系統application控制器 
 * @author zhuyy
 */
@Controller
@RequestMapping("/test")
public class ApplicationController extends BaseAction {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private IUserService seUser;
	@Autowired
	private IEUserService seEuser;
	/**
	 * 系统根页面
	 */
	@RequestMapping(value="t1",method={RequestMethod.GET})
	public String systemIndex1(){
		log.info("[delete] 测试删除");
		seUser.deleteUserById("1");
		Resource res = seEuser.getResourceById("1");
		List<Role> list = seEuser.getUserRoles("1");
		User user = new User();
		user.setUsername("朱元宇");
		user.setPassword("123456");
		seEuser.addUser(user);
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
