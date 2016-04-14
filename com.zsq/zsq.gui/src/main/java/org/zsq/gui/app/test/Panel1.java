/*
 * Created by JFormDesigner on Tue Apr 12 14:11:07 CST 2016
 */

package org.zsq.gui.app.test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.zsq.gui.app.db.DbPopupMenu;

/**
 * @author zhu yy
 */
public class Panel1 extends JPanel {
	public Panel1() {
		initComponents();
	}

	private void list1MouseClicked(MouseEvent e) {
		// TODO add your code here
		System.out.println("打开数据库信息列表");
		maybeShowPopup(e);
	}

	private void list1MousePressed(MouseEvent e) {
		list1.setSelectedIndex(list1.locationToIndex(e.getPoint())); //获取鼠标点击的项
		maybeShowPopup(e);
	}
	

	private void list1MouseReleased(MouseEvent e) {
		maybeShowPopup(e);
	}
	
	//弹出菜单
    private void maybeShowPopup(MouseEvent e) {
           if (e.isPopupTrigger()&&list1.getSelectedIndex()!=-1) {
            
            //获取选择项的值
        	int index =  list1.getSelectedIndex();
            Object selected = list1.getModel().getElementAt(index);
            final JPopupMenu menu = new DbPopupMenu();
	        menu.show(this, e.getPoint().x, e.getPoint().y);
	        
	        //list1.setSelectedIndex(index);
           }
       }

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - zhu yy
		scrollPane1 = new JScrollPane();
		list1 = new JList<>();

		//======== this ========

		// JFormDesigner evaluation mark
		/*setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Eva11luation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});*/

		setLayout(new GridLayout());

		//======== scrollPane1 ========
		{

			//---- list1 ----
			list1.setToolTipText("\u8fd9\u4e2a\u662f\u63d0\u793a\u4fe1\u606f");
			list1.setModel(new AbstractListModel<String>() {
				String[] values = {
					"1,2",
					"312",
					"123",
					"123",
					"\u5f20\u4e09",
					"\u5386\u53f2",
					"\u5386\u53f2",
					"\u5386\u53f2",
					"\u5386\u53f2",
					"\u5386\u53f2",
					"\u5386\u53f2",
					"\u5386\u53f2",
					"\u5386\u53f2",
					"\u5386\u53f2",
					"\u6d4b\u8bd5\u4e00\u4e0b\u957f\u7684\u4fe1\u606f",
					"\u6d4b\u8bd5\u4e00\u4e0b\u957f\u7684\u4fe1\u606f",
					"\u6d4b\u8bd5\u4e00\u4e0b\u957f\u7684\u4fe1\u606f",
					"\u6d4b\u8bd5\u4e00\u4e0b\u957f\u7684\u4fe1\u606f",
					"\u6d4b\u8bd5\u4e00\u4e0b\u957f\u7684\u4fe1\u606f"
				};
				@Override
				public int getSize() { return values.length; }
				@Override
				public String getElementAt(int i) { return values[i]; }
			});
			list1.setPreferredSize(new Dimension(200, 323));
			list1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					list1MousePressed(e);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					list1MouseReleased(e);
				}
			});
			scrollPane1.setViewportView(list1);
		}
		add(scrollPane1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - zhu yy
	private JScrollPane scrollPane1;
	private JList<String> list1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
