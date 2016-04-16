/*
 * Created by JFormDesigner on Sat Apr 16 13:25:51 CST 2016
 */

package org.zsq.gui.app.db;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import lombok.Getter;
import lombok.Setter;

import org.zsq.gui.app.entity.DBConfig;

/**
 * @author zhu yy
 */
public class DBListPanel extends JScrollPane {
	
	@Getter @Setter
	List<DBConfig> configs;
	public DBListPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - zhu yy
		//preCreation();
		list1 = new JList();
		//postCreation();

		//======== this ========

		//---- list1 ----
		loadDBListModal();
		initListInfo();
		setViewportView(list1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	private void initListInfo() {
		list1.setModel(new AbstractListModel<String>() {
			String[] values = {
				"1"
			};
			@Override
			public int getSize() { return values.length; }
			@Override
			public String getElementAt(int i) { return values[i]; }
		});
		
	}

	private void loadDBListModal() {
		configs = new ArrayList<DBConfig>();
		configs.add(new DBConfig("mysql 数据库", "localhost", 3306, "root", "a123456", true));
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - zhu yy
	private JList list1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
