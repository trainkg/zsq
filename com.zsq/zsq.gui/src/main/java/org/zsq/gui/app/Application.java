package org.zsq.gui.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.zsq.gui.app.core.ZsqContext;
import org.zsq.gui.app.db.ddl.TableDDLInfo;
import org.zsq.gui.app.db.service.DBmetaService;

import zsq.triankg.core.JAXBUtils;

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
//		System.out.println(DBmetaService.getFullTableDDLInfo(schema, tableName));
		
//		DBmetaService.changeDB("jxkh");
//		System.out.println(DBmetaService.getTables());
		List<String> tables = DBmetaService.getTables();
		for (String table : tables) {
			TableDDLInfo info = DBmetaService.getFullTableDDLInfo("mysql", table);
			
			File dir = new File("D://dlllll");
			dir.mkdirs();
			File tableXml =  new File(dir,table+".xml");
			tableXml.createNewFile();
			FileOutputStream fos = new FileOutputStream(tableXml);
			JAXBUtils.marshal(info, fos);
			fos.close();
		}
		
	}

	public static Application buildApplication() throws Exception {
		Application application = new Application();
		return application;
	}
}
