package com.zsq.plat.service.system.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zsq.plat.common.menu.IMenuService;
import com.zsq.plat.common.menu.Menu;
import com.zsq.plat.service.dao.MenuDao;

@Service
@Transactional
public class MenuService implements  IMenuService{

	@Override
	public List<Menu> getChildrens(int menuid) {
		return null;
	}

	@Override
	public Menu getMenu(int menuid) {
		return null;
	}

	@Override
	public Menu getFirstMenu(int menuId) {
		return null;
	}

	@Override
	public Menu getFullMenu(int menuId) {
		return null;
	}

	
	@Autowired
	private MenuDao daoMenu;
}
