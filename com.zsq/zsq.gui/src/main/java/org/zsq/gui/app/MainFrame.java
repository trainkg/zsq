package org.zsq.gui.app;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.zsq.gui.app.db.DBPanel;

@Slf4j
@Getter
@Setter
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JToolBar bar;
	JMenuBar menubar;
	JPanel leftPanel;
	
	public MainFrame() {
		initFrame();
	}
	
	/**
	 * @return
	 */
	public MainFrame initFrame(){
		setVisible(true);
		setSize(1000, 600);
		setBackground(Color.white);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(50,50));
		setTitle("自动化工具");
		addMenu();
		addRightFrame();
		return this;
	}

	private void addRightFrame() {
		leftPanel = new DBPanel();
		add(leftPanel, BorderLayout.WEST);
	}

	private void addMenu() {
		menubar = new JMenuBar();
		
		JMenu m1 = new JMenu("测试1");
		menubar.add(m1);
		
		JMenu m2 = new JMenu("测试2");
		menubar.add(m2);
		
		setJMenuBar(menubar);
	}

	private void addToobar() {
		log.info("[info] 初始化导航条");
		bar = new JToolBar("test");
		JButton jbtNew = new JButton("new");
		JButton jbtOpen = new JButton("open");
		JButton jbtPrint = new JButton("print");
		JToolBar jToolBar = new JToolBar("my tool bar");
		  //可以拖动
		  jToolBar.setFloatable(true);
		  //向里面添加按钮
		  jToolBar.add(jbtNew);
		  jToolBar.add(jbtOpen);
		  jToolBar.add(jbtPrint);
		  jbtNew.setToolTipText("New");
		  jbtOpen.setToolTipText("Open");
		  jbtPrint.setToolTipText("Print");
		  add(jToolBar,BorderLayout.NORTH);
	};
}
