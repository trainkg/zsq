/*
 * Created by JFormDesigner on Fri Apr 15 12:00:15 CST 2016
 */

package org.zsq.gui.app.db;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.zsq.gui.app.db.service.DBmetaService;

/**
 * @author zhu yy
 */
@Deprecated
public class TableList extends JPanel {
	
	String 			database;
	List<String> 	tables;
	
	public TableList() {
		initComponents();
	}
	
	private void preLoadTables(){
		//tables = DBmetaService.getTables();
	}
	
	private void initTables(){
		for (String tableName : tables) {
			JLabel label1 = new JLabel();
			label1.setText(tableName);
			label1.setPreferredSize(new Dimension(200, 20));
			label1.setBorder(new EmptyBorder(5, 5, 5, 5));
			label1.setIconTextGap(10);
			add(label1);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - zhu yy
		//======== this ========
		preLoadTables();//预读取数据

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		initTables();//初始化TABLE
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - zhu yy
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
