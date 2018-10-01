package com.zsq.party.resourse.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsq.party.modal.Party;


/**
 * party 基础信息http信息资源集合
 * @author peculiar.1@163.com
 * @version $ID: BasicInfoResourse.java, V1.0.0 2018年10月1日 上午11:11:18 $
 */
@Controller
@RequestMapping
public class BasicInfoResourse {
	
	
	/**
	 * 加载party列表
	 * @return
	 */
	@RequestMapping("/loadParty")
	@ResponseBody
	public List<Party> loadAllParty(){
		return null;
	}
	
}
