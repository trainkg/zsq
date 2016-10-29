package org.zsq.gui.app.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zsq.gui.app.web.vo.DBConnectConfig;

@Controller("/db")
@RequestMapping("/db")
public class ConfigResource {

	@RequestMapping("/connects")
	@ResponseBody
	public List<DBConnectConfig> getDBConnectionConfigs(){
		List<DBConnectConfig> list = new ArrayList<DBConnectConfig>();
		list.add(new DBConnectConfig("test"));
		list.add(new DBConnectConfig("test1"));
		return list;
	}
}
