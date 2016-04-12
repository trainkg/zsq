package org.zsq.gui.app;

import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

/**
 * 
 * @author Administrator
 */
public class Application {
	JFrame mainFrame;
	
	public static void main(String[] args) {
		try {
			lookAndFeel();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Application application = Application.buildApplication();
			
			application.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void lookAndFeel() throws Exception
	{
		BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
		org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	}

	private void start() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				mainFrame = new MainFrame();
			}
		});
	}

	public static Application buildApplication() throws Exception {
		Application application = new Application();
		return application;
	}
}
