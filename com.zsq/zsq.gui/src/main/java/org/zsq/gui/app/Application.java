package org.zsq.gui.app;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.zsq.gui.app.core.ZsqContext;
import org.zsq.gui.app.db.service.DBmetaService;
import org.zsq.gui.app.test.TEST;

/**
 * 
 * @author Administrator
 */
public class Application {
	public static JFrame mainFrame;
	
	public static void main(String[] args) {
		try {
			//lookAndFeel();
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

	private void start() throws Exception {
		ZsqContext.getInstance().initContext();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//mainFrame = new MainFrame();
				mainFrame = new AppFrame();
			}
		});
		System.out.println(DBmetaService.getTables());
//		DBmetaService.changeDB("jxkh");
//		System.out.println(DBmetaService.getTables());
	}

	public static Application buildApplication() throws Exception {
		Application application = new Application();
		return application;
	}
}