package zsq.triankg.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

/**
 * 集中定义返回结果集封装对象 
 * @author peculiar.1@163.com
 * @version $ID: ReturnType.java, V1.0.0 2016年4月22日 下午9:45:14 $
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReturnType {
	
	public static final String ST_S = "success";
	public static final String ST_F = "failed";
	private Object retVal;
	/**
	 * 状态码 范围没有限定,由业务自行规定
	 */
	private int statue;	
}
