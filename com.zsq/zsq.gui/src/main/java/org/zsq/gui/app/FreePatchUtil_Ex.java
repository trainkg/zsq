/*
 * 文件名称:          FreePatchUtil.java
 * 版权所有@ 2014——2015 KISUN，保留所有权利
 * 时间:             2016年3月15日 下午6:01:04
 */

package org.zsq.gui.app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 清单生成器修订版本
 * 
 * <p>
 * <p>
 * 
 * @项目 commonU.api.commonU
 *     <p>
 * @作者: KISUN
 *      <p>
 * @日期: 2016年3月15日
 *      <p>
 * @负责人: KISUN
 *       <p>
 * @负责小组: <p>
 *        <p>
 */
public class FreePatchUtil_Ex {

	/** 实体对象中实际存储数据的MAP结构 */
	static Map<String, String> dataPool = new HashMap<String, String>(128);

	// 补丁文件,由ECLIPSE SVN PLUGIN生成
	public static final String PATCHFILE = "patchFile";
	// 项目文件夹路径
	public static final String PROJECTPATH = "projectPath";
	// web应用文件夹名
	public static final String WEBCONTENT = "webContent";
	// class存放路径
	public static final String CLASSPATH = "classPath";
	// 补丁文件包存放路径
	public static final String DESPATH = "desPath";
	// 项目名称
	public static final String PROJECT_NAME = "project_name";
	// 清单路径名称
	public static final String TXT_NAME = "txt_name";
	// 生成补丁前是否清空既存目录下文件
	public static final String DIRCLEAN = "dirClean";
	// java文件的包名
	public static final String JAVA_PKG = "java_pkg";
	// config文件的包名
	public static final String CONFIG_PKG = "config_pkg";

	static String[] keys = { PATCHFILE, PROJECTPATH, WEBCONTENT, CLASSPATH,
			DESPATH, PROJECT_NAME, TXT_NAME, DIRCLEAN, JAVA_PKG, CONFIG_PKG };

	// 年
	public static String cur_year = String.valueOf(Calendar.getInstance().get(
			Calendar.YEAR));
	// 月
	public static String cur_mouth = String.valueOf(Calendar.getInstance().get(
			Calendar.MONTH));
	// 日
	public static String cur_date = String.valueOf(Calendar.getInstance().get(
			Calendar.DATE));

	public static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
	// 补丁版本(日期)
	public static String version = df.format(new Date());

	public FreePatchUtil_Ex() {
		init();
	}

	/**
	 * 主入口
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		init();
		version = df.format(new Date());
		copyFiles(getPatchFileList());
	}

	/**
	 * 清单生成
	 * 
	 * @param name
	 *            姓名
	 * @param bugContent
	 *            修复BUG的内容简介
	 * @param bbk
	 *            版本库
	 * @return
	 * @throws Exception
	 */
	public String makeQd(String name, String bugContent, String bbk)
			throws Exception {
		version = df.format(new Date());
		if (!name.isEmpty()) {
			version += "-" + name;
		}
		if (!bbk.isEmpty()) {
			version += "-" + bbk;
		}
		if (!bugContent.isEmpty()) {
			version += "-" + bugContent;
		}
		copyFiles(getPatchFileList());
		return version;
	}

	public static void init() {
		Properties prop = new Properties();
		try {
			prop.load(new InputStreamReader(Object.class.getResourceAsStream("/setting.properties"), "UTF-8"));
			for (String key : keys) {
				dataPool.put(key, prop.getProperty(key).trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取需要生成清单的文件路径（由ECLIPSE SVN PLUGIN生成）
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<String> getPatchFileList() throws Exception {
		List<String> fileList = new ArrayList<String>();
		FileInputStream f = new FileInputStream(dataPool.get(PATCHFILE));
		BufferedReader dr = new BufferedReader(
				new InputStreamReader(f, "utf-8"));
		String line;
		while ((line = dr.readLine()) != null) {
			if (line.indexOf("Index:") != -1) {
				line = line.replaceAll(" ", "");
				line = line.substring(line.indexOf(":") + 1, line.length());
				fileList.add(line);
			}
		}
		dr.close();
		return fileList;
	}

	/**
	 * 对应清单文件包括层级生成
	 * 
	 * @param list
	 */
	public static void copyFiles(List<String> list) {
		String versionPathStr = dataPool.get(DESPATH) + "/" + version;
		File versionFilePath = new File(versionPathStr);
		if (versionFilePath.exists() && dataPool.get(DIRCLEAN).equals("true")) {
			try {
				org.apache.commons.io.FileUtils.cleanDirectory(versionFilePath);
			} catch (IOException e) {
			}
		}
		List<String> filePathList = new ArrayList<String>();
		String javaPkg = dataPool.get(JAVA_PKG);
		String configPkg = dataPool.get(CONFIG_PKG);
		for (String fullFileName : list) {

			if (fullFileName.indexOf(javaPkg) != -1) {// 对源文件目录下的文件处理
				String filePathObj = fullFileName;

				String fileName = fullFileName.replace(javaPkg, "");
				String fileName2 = "";
				fullFileName = dataPool.get(CLASSPATH) + fileName;
				String path = fullFileName.substring(0,
						fullFileName.lastIndexOf("/"));
				File file = new File(path);
				String[] fileName1 = file.list();// 获取对应路径文件夹下所有的文件名

				for (int i = 0; i < fileName1.length; i++) {
					if (fileName1[i].replace(".class", "").indexOf(
							fileName.substring(fileName.lastIndexOf("/") + 1,
									fileName.lastIndexOf(".")) + "$") != -1
							|| fileName1[i].replace(".class", "").equals(
									fileName.substring(
											fileName.lastIndexOf("/") + 1,
											fileName.lastIndexOf(".")))) {// 匹配成功
						if (fileName.endsWith(".java")) {
							fileName2 = fileName.substring(0,
									fileName.lastIndexOf("/"))
									+ "/" + fileName1[i];
							fullFileName = fullFileName.substring(0,
									fullFileName.lastIndexOf("/"))
									+ "/"
									+ fileName1[i];
							filePathObj = filePathObj.substring(0,
									filePathObj.lastIndexOf("/"))
									+ "/" + fileName1[i];// 路径.txt中目录
						}
						filePathList.add(filePathObj);
						String tempDesPath = fileName2.substring(0,
								fileName2.lastIndexOf("/"));
						String desFilePathStr = versionPathStr + "/"
								+ dataPool.get(PROJECT_NAME)
								+ "/WEB-INF/classes" + tempDesPath;
						String desFileNameStr = versionPathStr + "/"
								+ dataPool.get(PROJECT_NAME)
								+ "/WEB-INF/classes" + fileName2;
						File desFilePath = new File(desFilePathStr);
						if (!desFilePath.exists()) {
							desFilePath.mkdirs();
						}
						copyFile(fullFileName, desFileNameStr);
						System.out.println(fullFileName + "复制完成");
					}
				}

			} else if (fullFileName.indexOf(configPkg) != -1) {
				String filePathObj = fullFileName;
				filePathList.add(filePathObj);

				String fileName = fullFileName.replace(configPkg, "");

				fullFileName = dataPool.get(CLASSPATH) + fileName;

				String tempDesPath = fileName.substring(0,
						fileName.lastIndexOf("/"));
				String desFilePathStr = versionPathStr + "/"
						+ dataPool.get(PROJECT_NAME) + "/WEB-INF/classes"
						+ tempDesPath;
				String desFileNameStr = versionPathStr + "/"
						+ dataPool.get(PROJECT_NAME) + "/WEB-INF/classes"
						+ fileName;
				File desFilePath = new File(desFilePathStr);
				if (!desFilePath.exists()) {
					desFilePath.mkdirs();
				}

				copyFile(fullFileName, desFileNameStr);
				System.out.println(fullFileName + "复制完成");
			} else {// 对普通目录的处理
				filePathList.add(fullFileName);

				String desFileName = fullFileName.replaceAll(
						dataPool.get(WEBCONTENT), "");
				fullFileName = dataPool.get(PROJECTPATH) + "/" + fullFileName;// 将要复制的文件全路径
				String fullDesFileNameStr = versionPathStr + "/"
						+ dataPool.get(PROJECT_NAME) + desFileName;
				String desFilePathStr = fullDesFileNameStr.substring(0,
						fullDesFileNameStr.lastIndexOf("/"));
				File desFilePath = new File(desFilePathStr);
				if (!desFilePath.exists()) {
					desFilePath.mkdirs();
				}
				copyFile(fullFileName, fullDesFileNameStr);
				System.out.println(fullFileName + "复制完成");
			}

		}

		if (!filePathList.isEmpty()) {
			// 生成路径TXT
			writerTxt(versionPathStr + "/" + dataPool.get(TXT_NAME),
					filePathList);
		}
	}

	private static void copyFile(String sourceFileNameStr, String desFileNameStr) {
		File srcFile = new File(sourceFileNameStr);
		File desFile = new File(desFileNameStr);
		try {
			copyFile(srcFile, desFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyFile(File sourceFile, File targetFile)
			throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		} finally {
			// 关闭流
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}

	// 写文件
	public static void writerTxt(String txtPath, List<String> contentList) {
		BufferedWriter fw = null;
		try {
			File file = new File(txtPath);
			fw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, true), "UTF-8")); // 指定编码格式，以免读取时中文字符异常
			for (String content : contentList) {
				fw.append(content);
				fw.newLine();
			}
			fw.flush(); // 全部写入缓存中的内容
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
