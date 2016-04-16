/*
 * Created by JFormDesigner on Sat Apr 16 14:38:47 CST 2016
 */

package org.zsq.gui.app;

import java.awt.*;
import javax.swing.*;
import org.zsq.gui.app.db.*;

/**
 * @author zhu yy
 */
public class AppFrame extends JFrame {
	public AppFrame() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - zhu yy
		panel3 = new JPanel();
		panel2 = new DBConfigPanel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		panel4 = new TableList();

		//======== this ========
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== panel3 ========
		{

			// JFormDesigner evaluation mark
			panel3.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel3.getBorder())); panel3.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel3.setLayout(new BorderLayout());
			panel3.add(panel2, BorderLayout.EAST);
		}
		contentPane.add(panel3, BorderLayout.WEST);

		//---- label2 ----
		label2.setText("text");
		contentPane.add(label2, BorderLayout.EAST);

		//---- label3 ----
		label3.setText("text");
		contentPane.add(label3, BorderLayout.NORTH);

		//---- label4 ----
		label4.setText("text");
		contentPane.add(label4, BorderLayout.SOUTH);
		contentPane.add(panel4, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - zhu yy
	private JPanel panel3;
	private DBConfigPanel panel2;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private TableList panel4;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
