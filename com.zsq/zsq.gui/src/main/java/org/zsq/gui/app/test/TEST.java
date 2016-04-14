/*
 * Created by JFormDesigner on Tue Apr 12 14:04:13 CST 2016
 */

package org.zsq.gui.app.test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author zhu yy
 */
public class TEST extends JFrame {
	public TEST() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - zhu yy
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		panel1 = new Panel1();
		label1 = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setTitle("\u6d4b\u8bd5\u6807\u9898\u4fe1\u606f");
		setMinimumSize(new Dimension(600, 600));
		setVisible(true);
		setIconImage(null);
		setOpacity(0.8F);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(10, 10));

		//======== dialogPane ========
		{
			dialogPane.setBorder(Borders.createEmptyBorder("7dlu, 7dlu, 7dlu, 7dlu"));

			// JFormDesigner evaluation mark
			dialogPane.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setLayout(new BorderLayout());

				//---- panel1 ----
				panel1.setForeground(Color.orange);
				contentPanel.add(panel1, BorderLayout.WEST);

				//---- label1 ----
				label1.setText("\u8fd9\u4e2a\u662f\u5934\u90e8");
				contentPanel.add(label1, BorderLayout.NORTH);

				//---- textField1 ----
				textField1.setText("\u8fd9\u662f\u811a\u6b65");
				contentPanel.add(textField1, BorderLayout.SOUTH);

				//---- textField2 ----
				textField2.setText("\u8fd9\u4e2a\u662f\u53f3\u4fa7");
				contentPanel.add(textField2, BorderLayout.EAST);

				//---- textField3 ----
				textField3.setText("\u8fd9\u662f\u4e2d\u90e8");
				contentPanel.add(textField3, BorderLayout.CENTER);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(Borders.createEmptyBorder("5dlu, 0dlu, 0dlu, 0dlu"));
				buttonBar.setLayout(new FormLayout(
					"$glue, $button, $rgap, $button",
					"pref"));

				//---- okButton ----
				okButton.setText("OK");
				buttonBar.add(okButton, CC.xy(2, 1));

				//---- cancelButton ----
				cancelButton.setText("Cancel");
				buttonBar.add(cancelButton, CC.xy(4, 1));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - zhu yy
	private JPanel dialogPane;
	private JPanel contentPanel;
	private Panel1 panel1;
	private JLabel label1;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
