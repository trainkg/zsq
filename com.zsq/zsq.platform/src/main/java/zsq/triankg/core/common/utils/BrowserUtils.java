package zsq.triankg.core.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author peculiar.1@163.com
 * @version $ID: BrowserUtils.java, V1.0.0 2017年3月18日 上午7:21:30 $
 */
public class BrowserUtils {
	
	public static boolean isIE(HttpServletRequest request){
		String agent = request.getHeader("USER-AGENT");
		boolean isIE = null != agent&& (-1 != agent.indexOf("MSIE") || -1 != agent.indexOf("Trident"));
		return isIE;
	}

	public static boolean isMozilla(HttpServletRequest request) {
		String agent = request.getHeader("USER-AGENT");
		boolean isMozilla = null != agent && -1 != agent.indexOf("Mozilla");
		return isMozilla;
	}
}
