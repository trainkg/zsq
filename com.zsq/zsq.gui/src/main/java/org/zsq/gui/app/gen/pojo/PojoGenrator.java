package org.zsq.gui.app.gen.pojo;

import java.io.FileWriter;

import org.zsq.gui.app.db.ddl.TableDDLInfo;
import org.zsq.gui.app.gen.AbstractGenartor;
import org.zsq.gui.app.gen.GenContext;

import zsq.triankg.core.ZsqException;
import freemarker.template.Template;

/**
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: PojoGenrator.java, V1.0.0 2016年4月22日 下午10:12:35 $
 */
public class PojoGenrator extends AbstractGenartor {
	
	
	@Override
	public void genaratorHander(GenContext context, TableDDLInfo config) throws ZsqException {
		try {
			setPathHander(new PojoPath(context,config));
			Template template = getTemplateContext().getTemplate("/pojo/base/pojo.ftl");
			FileWriter wirter = new FileWriter(getGenrateFile());
			template.process(wapperTarget(config), wirter);
			wirter.close();
		} catch (Exception e) {
			throw new ZsqException(e);
		}
	}
	
	private Object wapperTarget(TableDDLInfo config){
		return config;
	}
	

}
