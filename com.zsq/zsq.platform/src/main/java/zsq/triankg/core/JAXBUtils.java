package zsq.triankg.core;

import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * JAXB 工具类, 快速调用
 * 
 * @author peculiar.1@163.com
 * @version $ID: XmlObject.java, V1.0.0 2016年4月23日 下午1:46:09 $
 */
public class JAXBUtils {

	public static void marshal(Object modal,OutputStream os) throws ZsqException{
		try {
			JAXBContext context = JAXBContext.newInstance(modal.getClass());
			Marshaller mar = context.createMarshaller();
			//mar 配置策略
			mar.marshal(modal, os);
		} catch (JAXBException e) {
			throw new ZsqException(e);
		}	
	}
}
