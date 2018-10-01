package com.zsq.plat.common.menu;

import java.util.List;

/**
 * 菜单服务
 * 
 * @author peculiar.1@163.com
 * @version $ID: IMenuService.java, V1.0.0 2017年12月9日 下午6:57:34 $
 */
public interface IMenuService {
	
	/**
	 * 根据节点获取子节点菜单
	 * @param menuid
	 * @return
	 */
	public List<Menu> getChildrens(int menuid);
	
	
	/**
	 * 获取自身节点信息
	 * @param menuid
	 * @return
	 */
	public Menu getMenu(int menuid);
	
	/**
	 * 获取自身节点以及子节点信息
	 * @param menuId
	 * @return
	 */
	public Menu getFirstMenu(int menuId);
	
	/**
	 * 获取全节点信息
	 * @param menuId
	 * @return
	 */
	public Menu getFullMenu(int menuId);
}
