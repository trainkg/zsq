package com.zsq.cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zsq.cms.BaseAction;
import com.zsq.euser.SimpleLoginForm;
import com.zsq.euser.shiro.IShrioUserService;

/**
 * 根路径
 * @author zhuyy
 */
@Controller
@RequestMapping
public class IndexController extends BaseAction {
	
	@Autowired
	private IShrioUserService seShiroUser;
	/**
	 * 系统首页信息
	 * @return
	 */
	@RequestMapping(value="sindex",method={RequestMethod.GET})
	public String systemIndex(){
		return "index";
	}
	
	
	@RequestMapping(value="/login",method={RequestMethod.GET})
	public void login(@Valid @ModelAttribute SimpleLoginForm user,BindingResult rs){
		seShiroUser.login(user.getUserName(),user.getPassword());
	}
	
}
