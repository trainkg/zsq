package com.zsq.plat;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;

import lombok.extern.slf4j.Slf4j;

import org.zsq.gui.app.entity.ApplicationConfig;

import zsq.triankg.core.ZsqException;

@Slf4j
public class ApplicationConfigFactory {
	
	public static ApplicationConfig initApplicationConfig(String basePath){
		log.info("init applicationConfig start.");
		URL url = ApplicationConfig.class.getResource(basePath+"/gen-core-config.xml");
		try {
			if(url != null){
				JAXBContext context = JAXBContext.newInstance(ApplicationConfig.class);
				System.out.println(url.getPath());
				ApplicationConfig applicationConfig = (ApplicationConfig) context.createUnmarshaller().unmarshal(new FileInputStream(new File(url.getPath())));
				return applicationConfig; 
			}else{
				return new ApplicationConfig();	
			}
		} catch (Exception e) {
			log.warn("init applicationConfig failed.");
			throw new ZsqException("init ApplicationConfig failed.", e);
		} 
	}
}
