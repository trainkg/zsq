package com.zsq.plat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zsq.gui.app.entity.ApplicationConfig;
import org.zsq.gui.app.entity.ModelConfig;

/**
 * 系统相关子页面,主要配合EASY UI使用,easy ui 本身没有对panel内提供强大的渲染功能,还是通过HREF通过后端的渲染功能来解决这个问题。
 * 
 * @author peculiar.1@163.com
 * @version $ID: ConfigController.java, V1.0.0 2016年10月30日 下午3:53:42 $
 */
@Controller
@RequestMapping("/dbconfig")
public class ConfigController {
	
	@Autowired
	private ApplicationConfig config;
	
	/*@Value("#{genCore.genConfigFileBasePath}")
	private String test;*/
	
	/**
	 * 获取系统所有模块设定
	 */
	@RequestMapping("/models")
	@ResponseBody
	public List<ModelConfig> getAllModels(){
		List<ModelConfig> configList = config.getModelConfigList();
		return configList;
	}
	
	
}
