package com.zsq.plat.system.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsq.plat.common.menu.IMenuService;
import com.zsq.plat.common.menu.Menu;
import com.zsq.plat.common.menu.MenuConstant;

/**
 * 菜单控制
 * @author peculiar.1@163.com
 * @version $ID: MenuController.java, V1.0.0 2017年12月9日 下午6:47:49 $
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@RequestMapping("/mlayer")
	public List<Menu> get1LayerMenus(){
		return seMenu.getChildrens(MenuConstant.BASE_MANU_ID);
	}
	
	@Autowired
	private IMenuService seMenu;
}
