package org.zsq.gui.app.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.zsq.gui.app.core.ZsqContext;

import lombok.Getter;
import lombok.Setter;

/**
 * 自动化平台设置全局设定 
 * 
 * 生成对应的全局配置XML文件
 * 
 * @author peculiar.1@163.com
 * @version $ID: ApplicationConfig.java, V1.0.0 2016年10月30日 下午2:19:07 $
 */
@Getter
@Setter
@XmlRootElement(name="table",namespace=ZsqContext.ZSQ_GUI_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class ApplicationConfig {
	private List<ModelConfig> modelConfigList;
}
