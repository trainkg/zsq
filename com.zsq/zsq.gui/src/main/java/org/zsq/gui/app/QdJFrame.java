 /**
 * 
 */
package org.zsq.gui.app;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * 清单生成界面
 * 
 * @author jihailong
 * 
 */
public class QdJFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6251351149714639136L;

	GridBagLayout g = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	JLabel noteInformation, userName, password,bbk;
	JLabel sex, birthday;
	JTextField textUserName, textUserPassword, textBbk;
	JRadioButton sexMan, sexGirl;
	JComboBox year, month;
	JButton submit;
	JTextArea result;

	final String[] MONTH = { "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月",
			"9月", "10月", "11月", "12月" };

	QdJFrame() {
		initGUI();
	}

	QdJFrame(String str) {
		super(str);
		initGUI();
	}

	private void initGUI() {
		setVisible(true);
		setSize(400, 400);
		setBackground(Color.white);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// 调用方法
		addComponent();
		setLayout(g);
		setResizable(true);
		submit.addActionListener(this);
	}

	public void addComponent() {
		// 个人信息登记
		noteInformation = new JLabel("清单信息：");
		add(g, c, noteInformation, 0, 0, 1, 1);
		// 用户名
		userName = new JLabel("姓名：");
		add(g, c, userName, 0, 1, 1, 1);
		// 用户名输入框
		textUserName = new JTextField(10);
		textUserName.setText("朱元宇");
		add(g, c, textUserName, 1, 1, 2, 1);
		// 清单内容简介：
		password = new JLabel("清单内容：");
		add(g, c, password, 0, 2, 1, 1);
		// 清单内容简介输入框
		textUserPassword = new JTextField(20);
		textUserPassword.setText("bug修复");
		add(g, c, textUserPassword, 1, 2, 2, 1);
		
		bbk = new JLabel("版本库：");
		add(g, c, bbk, 0, 3, 1, 1);
		
		textBbk = new JTextField(10);
		textBbk.setText("trunk");
		add(g, c, textBbk, 1, 3, 2, 1);
		// submit按钮
		submit = new JButton("生成");
		c.insets = new Insets(7, 0, 4, 0);
		add(g, c, submit, 1, 5, 1, 1);

		result = new JTextArea(10, 20);
		result.setLineWrap(true);
		add(g, c, result, 1, 6, 3, 4);
	}

	public void add(GridBagLayout g, GridBagConstraints c, JComponent jc,
			int x, int y, int gw, int gh) {
		c.gridx = x;
		c.gridy = y;
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = gw;
		c.gridheight = gh;
		g.setConstraints(jc, c);
		add(jc);
	}

	public static void start() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new QdJFrame("清单生成器");
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FreePatchUtil_Ex ex = new FreePatchUtil_Ex();
		try {
			String s = textUserName.getText();
			String t = textUserPassword.getText();
			String b = textBbk.getText();
			String re =ex.makeQd(s, t, b);
			result.setText(re + "\n" +"清单生成成功！");
		} catch (Exception e1) {
			result.setText("生成失败！");
			e1.printStackTrace();
		}
	}
}
