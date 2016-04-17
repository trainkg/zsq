/*
 * Created by JFormDesigner on Sat Apr 16 14:54:40 CST 2016
 */

package org.zsq.gui.app.db;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author zhu yy
 */
public class TabelConfig extends JDialog {
	public TabelConfig(Frame owner) {
		super(owner);
		initComponents();
	}

	public TabelConfig(Dialog owner) {
		super(owner);
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - zhu yy
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		tabbedPane1 = new JTabbedPane();
		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		textField1 = new JTextField();
		label2 = new JLabel();
		textField2 = new JTextField();
		label3 = new JLabel();
		panel3 = new JPanel();
		checkBox2 = new JCheckBox();
		checkBox3 = new JCheckBox();
		checkBox4 = new JCheckBox();
		checkBox5 = new JCheckBox();
		panel6 = new JPanel();
		label4 = new JLabel();
		panel4 = new JPanel();
		checkBox7 = new JCheckBox();
		checkBox8 = new JCheckBox();
		checkBox9 = new JCheckBox();
		checkBox10 = new JCheckBox();
		panel7 = new JPanel();
		panel8 = new JPanel();
		textField4 = new JTextField();
		checkBox11 = new JCheckBox();
		button1 = new JButton();
		label5 = new JLabel();
		panel5 = new JPanel();
		radioButton1 = new JRadioButton();
		radioButton2 = new JRadioButton();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();
		panel9 = new JPanel();
		label8 = new JLabel();
		textField3 = new JTextField();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

			// JFormDesigner evaluation mark
			dialogPane.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setLayout(new BorderLayout(5, 5));

				//======== tabbedPane1 ========
				{

					//======== panel1 ========
					{
						panel1.setLayout(new BorderLayout());

						//======== panel2 ========
						{
							panel2.setLayout(new GridBagLayout());
							((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {73, 88, 12, 415, 62, 0};
							((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {22, 0, 0, 99, 0};
							((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
							((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

							//---- label1 ----
							label1.setText("\u5bf9\u8c61\u540d\u79f0\uff1a");
							panel2.add(label1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
								GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
								new Insets(0, 0, 5, 5), 0, 0));
							panel2.add(textField1, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 5, 5), 0, 0));

							//---- label2 ----
							label2.setText("\u751f\u6210\u5730\u5740\uff1a");
							panel2.add(label2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
								GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
								new Insets(0, 0, 5, 5), 0, 0));
							panel2.add(textField2, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 5, 5), 0, 0));

							//---- label3 ----
							label3.setText("CURD\u7c7b\u578b\uff1a");
							panel2.add(label3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
								GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
								new Insets(0, 0, 0, 5), 0, 0));

							//======== panel3 ========
							{
								panel3.setLayout(new GridLayout());

								//---- checkBox2 ----
								checkBox2.setText("save");
								panel3.add(checkBox2);

								//---- checkBox3 ----
								checkBox3.setText("update");
								panel3.add(checkBox3);

								//---- checkBox4 ----
								checkBox4.setText("delete");
								panel3.add(checkBox4);

								//---- checkBox5 ----
								checkBox5.setText("search");
								panel3.add(checkBox5);
							}
							panel2.add(panel3, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 5), 0, 0));
						}
						panel1.add(panel2, BorderLayout.CENTER);
					}
					tabbedPane1.addTab("\u6570\u636e\u64cd\u4f5c", panel1);

					//======== panel6 ========
					{
						panel6.setLayout(new GridBagLayout());
						((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {85, 63, 352, 62, 63, 0};
						((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
						((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
						((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

						//---- label4 ----
						label4.setText("\u4e1a\u52a1\u529f\u80fd\u5217\u8868\uff1a");
						panel6.add(label4, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));

						//======== panel4 ========
						{
							panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

							//---- checkBox7 ----
							checkBox7.setText("\u65b0\u5efa");
							panel4.add(checkBox7);

							//---- checkBox8 ----
							checkBox8.setText("\u5220\u9664");
							panel4.add(checkBox8);

							//---- checkBox9 ----
							checkBox9.setText("\u4fee\u6539");
							panel4.add(checkBox9);

							//---- checkBox10 ----
							checkBox10.setText("\u67e5\u8be2");
							panel4.add(checkBox10);
						}
						panel6.add(panel4, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));
					}
					tabbedPane1.addTab("\u4e1a\u52a1\u5c42", panel6);

					//======== panel7 ========
					{
						panel7.setLayout(new GridBagLayout());
						((GridBagLayout)panel7.getLayout()).columnWidths = new int[] {0, 0, 0};
						((GridBagLayout)panel7.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)panel7.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
						((GridBagLayout)panel7.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
					}
					tabbedPane1.addTab("\u63a7\u5236\u5c42", panel7);

					//======== panel8 ========
					{
						panel8.setLayout(new GridBagLayout());
						((GridBagLayout)panel8.getLayout()).columnWidths = new int[] {0, 79, 272, 0, 0};
						((GridBagLayout)panel8.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)panel8.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
						((GridBagLayout)panel8.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

						//---- textField4 ----
						textField4.setText("\u751f\u6210\u9009\u62e9\u5668\uff1a");
						panel8.add(textField4, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));

						//---- checkBox11 ----
						checkBox11.setText("\u751f\u6210");
						panel8.add(checkBox11, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));

						//---- button1 ----
						button1.setText("\u914d\u7f6e\u9009\u62e9\u5668");
						panel8.add(button1, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- label5 ----
						label5.setText("\u521b\u5efa\u6570\u636e\u6a21\u5f0f\uff1a");
						panel8.add(label5, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));

						//======== panel5 ========
						{
							panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

							//---- radioButton1 ----
							radioButton1.setText("\u5355\u9875\u5e94\u7528");
							panel5.add(radioButton1);

							//---- radioButton2 ----
							radioButton2.setText("\u591a\u9875\u5e94\u7528");
							panel5.add(radioButton2);
						}
						panel8.add(panel5, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));
					}
					tabbedPane1.addTab("\u89c6\u56fe", panel8);
				}
				contentPanel.add(tabbedPane1, BorderLayout.CENTER);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- okButton ----
				okButton.setText("\u786e\u5b9a");
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("\u53d6\u6d88");
				buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);

			//======== panel9 ========
			{
				panel9.setLayout(new GridBagLayout());
				((GridBagLayout)panel9.getLayout()).columnWidths = new int[] {93, 490, 0};
				((GridBagLayout)panel9.getLayout()).rowHeights = new int[] {0, 0, 0};
				((GridBagLayout)panel9.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
				((GridBagLayout)panel9.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

				//---- label8 ----
				label8.setText("\u8868\u6240\u5c5e\u6a21\u5757\uff1a");
				panel9.add(label8, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
				panel9.add(textField3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));
			}
			dialogPane.add(panel9, BorderLayout.NORTH);
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
	private JTabbedPane tabbedPane1;
	private JPanel panel1;
	private JPanel panel2;
	private JLabel label1;
	private JTextField textField1;
	private JLabel label2;
	private JTextField textField2;
	private JLabel label3;
	private JPanel panel3;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JCheckBox checkBox4;
	private JCheckBox checkBox5;
	private JPanel panel6;
	private JLabel label4;
	private JPanel panel4;
	private JCheckBox checkBox7;
	private JCheckBox checkBox8;
	private JCheckBox checkBox9;
	private JCheckBox checkBox10;
	private JPanel panel7;
	private JPanel panel8;
	private JTextField textField4;
	private JCheckBox checkBox11;
	private JButton button1;
	private JLabel label5;
	private JPanel panel5;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel panel9;
	private JLabel label8;
	private JTextField textField3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
