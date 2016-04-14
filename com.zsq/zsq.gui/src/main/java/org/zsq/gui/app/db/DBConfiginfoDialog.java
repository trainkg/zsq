/*
 * Created by JFormDesigner on Thu Apr 14 14:39:32 CST 2016
 */

package org.zsq.gui.app.db;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import lombok.Getter;
import lombok.Setter;

import org.zsq.gui.app.entity.DBConfig;

/**
 * @author zhu yy
 */
public class DBConfiginfoDialog extends JDialog {
	
	@Getter @Setter
	private DBConfig config = new DBConfig();
	
	public DBConfiginfoDialog(Frame owner) {
		super(owner);
		initComponents();
	}
	
	public DBConfiginfoDialog(Frame owner, DBConfig config) {
		super(owner);
		initComponents();
		if(config != null){
			this.config = config;
		}else{
			this.config = new DBConfig();
		}
	}

	public DBConfiginfoDialog(Dialog owner) {
		super(owner);
		initComponents();
	}
	
	public DBConfiginfoDialog(Dialog owner,DBConfig config) {
		super(owner);
		initComponents();
		if(config != null){
			this.config = config;
		}else{
			this.config = new DBConfig();
		}
	}

	private void cancelButtonMouseReleased(MouseEvent e) {
		this.setVisible(false);
	}

	private void okButtonMouseReleased(MouseEvent e) {
		//保存链接信息到本地
		config = getBeanInfo();
	}
	
	

	private DBConfig getBeanInfo() {
		config.setHost(ip.getText());
		config.setName(name.getText());
		config.setPort(Integer.valueOf(port.getText()));
		config.setPassword(String.valueOf(password.getPassword()));
		config.setSavePass(savepass.isSelected());
		config.setUsername(username.getText());
		
		return null;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - zhu yy
		ResourceBundle bundle = ResourceBundle.getBundle("org.zsq.gui.app.db.dbconfigdialog");
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		tabbedPane1 = new JTabbedPane();
		panel2 = new JPanel();
		label2 = new JLabel();
		name = new JTextField();
		label3 = new JLabel();
		ip = new JTextField();
		label4 = new JLabel();
		port = new JTextField();
		label5 = new JLabel();
		username = new JTextField();
		label6 = new JLabel();
		password = new JPasswordField();
		savepass = new JCheckBox();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setMinimumSize(new Dimension(580, 490));
		setTitle(bundle.getString("DBConfiginfoDialog.this.title"));
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

					//======== panel2 ========
					{
						panel2.setLayout(new GridBagLayout());
						((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {208, 236, 0};
						((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
						((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
						((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

						//---- label2 ----
						label2.setText(bundle.getString("DBConfiginfoDialog.label2.text"));
						panel2.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
						panel2.add(name, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- label3 ----
						label3.setText(bundle.getString("DBConfiginfoDialog.label3.text"));
						panel2.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
						panel2.add(ip, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- label4 ----
						label4.setText(bundle.getString("DBConfiginfoDialog.label4.text"));
						panel2.add(label4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
						panel2.add(port, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- label5 ----
						label5.setText(bundle.getString("DBConfiginfoDialog.label5.text"));
						panel2.add(label5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
						panel2.add(username, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- label6 ----
						label6.setText(bundle.getString("DBConfiginfoDialog.label6.text"));
						panel2.add(label6, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
							new Insets(0, 0, 5, 5), 0, 0));
						panel2.add(password, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- savepass ----
						savepass.setText(bundle.getString("DBConfiginfoDialog.savepass.text"));
						panel2.add(savepass, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
					}
					tabbedPane1.addTab(bundle.getString("DBConfiginfoDialog.panel2.tab.title"), panel2);
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
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						okButtonMouseReleased(e);
					}
				});
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("\u53d6\u6d88");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						cancelButtonMouseReleased(e);
					}
				});
				buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
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
	private JTabbedPane tabbedPane1;
	private JPanel panel2;
	private JLabel label2;
	private JTextField name;
	private JLabel label3;
	private JTextField ip;
	private JLabel label4;
	private JTextField port;
	private JLabel label5;
	private JTextField username;
	private JLabel label6;
	private JPasswordField password;
	private JCheckBox savepass;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
