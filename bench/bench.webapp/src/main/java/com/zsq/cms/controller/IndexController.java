package com.zsq.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zsq.cms.BaseAction;

/**
 * 根路径
 * @author zhuyy
 */
@Controller
@RequestMapping
public class IndexController extends BaseAction {
	
	/**
	 * 系统首页信息
	 * @return
	 */
	@RequestMapping(value="sindex",method={RequestMethod.GET})
	public String systemIndex(){
		return "index";
	}
}
