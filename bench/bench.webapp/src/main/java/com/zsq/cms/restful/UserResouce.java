package com.zsq.cms.restful;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsq.cms.restful.vo.User;

/**
 * 用户资源信息表 
 * @author zhuyy
 */
@Controller
@RequestMapping("/ru")
public class UserResouce {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	@ResponseBody
	public List<User> userInfo(@PathVariable String id){
		List<User> list = new ArrayList<>();
		list.add(new User("1","张苏"));
		list.add(new User("2","立场"));
		return list;
	}
	
	/**
	 * 删除用户
	 * @param id
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void removeUser(@PathVariable String id){
		log.info("delete user id {}",id);
	}
	
	/**
	 * 更新用户
	 * @param id 必须是这样的设计..
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public void updateUser(@RequestBody User body){
		log.info("update user,{} {}",body.getId(),body.getName());
	}
	
	/**
	 * 更新用户
	 * @param id
	 */
	@RequestMapping(value="/user",method=RequestMethod.POST)
	@ResponseBody
	public void addUser(@RequestBody User body){
		log.info("add user,{} {}",body.getId(),body.getName());
	}
	
	
}
