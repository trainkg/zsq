package zsq.triankg.core;

import lombok.Getter;
import lombok.Setter;

/**
 * 平台基础异常 
 * @author peculiar.1@163.com
 * @version $ID: ZsqException.java, V1.0.0 2016年4月22日 下午9:41:08 $
 */
@Getter
@Setter
public class ZsqException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String code;
	public ZsqException() {
		super();
	}
	public ZsqException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public ZsqException(String msg, Throwable arg1) {
		super(msg, arg1);
	}
	public ZsqException(Throwable arg0) {
		super(arg0);
	}
	
	public ZsqException(String code) {
		super();
		this.code = code;
	}
	public ZsqException(String code,String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		this.code = code;
	}
	public ZsqException(String code,String msg, Throwable arg1) {
		super(msg, arg1);
		this.code = code;
	}
}
