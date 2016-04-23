package zsq.triankg.core.template;

import lombok.Getter;
import lombok.Setter;
import zsq.triankg.core.ZsqException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * 模板管理器
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: TemplateContext.java, V1.0.0 2016年4月22日 下午8:45:30 $
 */
@Getter
@Setter
public class TemplateContext {
	private Configuration config;
	private String encoding = "UTF-8";
	private String classConfigBasePath = "/template";
	
	public TemplateContext() {
		loadTemplateConfig();
	}

	private void loadTemplateConfig() {
		config = new Configuration(Configuration.VERSION_2_3_23);
		config.setDefaultEncoding(encoding);
		config.setLogTemplateExceptions(false);
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		config.setClassForTemplateLoading(TemplateContext.class, classConfigBasePath);
	}
	
	public Template getTemplate(String path){
		try {
			return config.getTemplate(path);
		} catch (Exception e) {
			throw new ZsqException(e);
		}
	}
	
}
