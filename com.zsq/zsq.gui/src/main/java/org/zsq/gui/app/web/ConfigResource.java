package org.zsq.gui.app.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zsq.gui.app.db.service.DBmetaService;
import org.zsq.gui.app.web.vo.DBConnectConfig;
import org.zsq.gui.app.web.vo.TableDefined;

@Controller
@RequestMapping("/db")
public class ConfigResource {
	
	@Autowired
	private DBmetaService seDBmeta;

	
	/**
	 * 当前版本不考虑提供配置连接,采用统一连接配置,系统中只存在一个数据库连接
	 * @return
	 */
	@RequestMapping("/connects")
	@ResponseBody
	@Deprecated
	public List<DBConnectConfig> getDBConnectionConfigs(){
		System.out.println();
		List<DBConnectConfig> list = new ArrayList<DBConnectConfig>();
		list.add(new DBConnectConfig("test"));
		list.add(new DBConnectConfig("test1"));
		return list;
	}
	
	/**
	 * 获取系统配置中的所有的数据库表定义
	 */
	@RequestMapping("/tables")
	@ResponseBody
	public List<TableDefined>  getAllTables(){
		List<TableDefined> list = new ArrayList<TableDefined>();
		List<String> tables = seDBmeta.getTables();
		for (String tableName : tables) {
			list.add(new TableDefined(tableName));
		}
		return list;
	}
	
}
