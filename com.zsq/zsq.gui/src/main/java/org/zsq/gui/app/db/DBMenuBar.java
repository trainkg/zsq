package org.zsq.gui.app.db;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * DB 控制页面 右键导航
 * @author Administrator
 */
public class DBMenuBar extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
	public DBMenuBar() {
		initMenu();
	}

	private void initMenu() {
		JMenu m1 = new JMenu("新建链接");
		JMenu m2 = new JMenu("删除链接");
		add(m1);
		add(m2);
	}
	
	
}
