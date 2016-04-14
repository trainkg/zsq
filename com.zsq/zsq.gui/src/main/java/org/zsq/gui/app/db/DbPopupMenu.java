/*
 * Created by JFormDesigner on Thu Apr 14 13:35:41 CST 2016
 */

package org.zsq.gui.app.db;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.zsq.gui.app.Application;

/**
 * @author zhu yy
 */
public class DbPopupMenu extends JPopupMenu {
	public DbPopupMenu() {
		initComponents();
	}

	private void menuItem1MouseReleased(MouseEvent e) {
		//TODO打开新建面板
		DBConfiginfoDialog dialog = new DBConfiginfoDialog(Application.mainFrame);
		dialog.setVisible(true);
	}

	private void menuItem2MouseReleased(MouseEvent e) {
		System.out.println(e);
		//删除对应配置
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - zhu yy
		menuItem1 = new JMenuItem();
		menuItem5 = new JMenuItem();
		menuItem2 = new JMenuItem();
		separator1 = new JSeparator();
		menuItem4 = new JMenuItem();
		menuItem3 = new JMenuItem();

		//======== this ========
		setInheritsPopupMenu(true);
		setMinimumSize(new Dimension(182, 250));

		//---- menuItem1 ----
		menuItem1.setText("\u65b0\u5efa\u94fe\u63a5");
		menuItem1.setPreferredSize(new Dimension(140, 22));
		menuItem1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				menuItem1MouseReleased(e);
			}
		});
		add(menuItem1);

		//---- menuItem5 ----
		menuItem5.setText("\u94fe\u63a5\u5c5e\u6027");
		add(menuItem5);

		//---- menuItem2 ----
		menuItem2.setText("\u5220\u9664\u94fe\u63a5");
		menuItem2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				menuItem2MouseReleased(e);
			}
		});
		add(menuItem2);
		add(separator1);

		//---- menuItem4 ----
		menuItem4.setText("\u83dc\u5355\u4e00");
		add(menuItem4);

		//---- menuItem3 ----
		menuItem3.setText("\u83dc\u5355\u4e8c");
		add(menuItem3);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - zhu yy
	private JMenuItem menuItem1;
	private JMenuItem menuItem5;
	private JMenuItem menuItem2;
	private JSeparator separator1;
	private JMenuItem menuItem4;
	private JMenuItem menuItem3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
