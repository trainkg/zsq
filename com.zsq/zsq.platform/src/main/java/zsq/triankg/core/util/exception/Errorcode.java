package zsq.triankg.core.util.exception;

/**
 * ERROR CODE 
 * <p>
 * <p>
 * @版本:       CloudView V1.8
 * <p>
 * @作者:       zhuyy
 * <p>
 * @日期:       2014-4-15
 * <p>
 * @负责人:     zhuyy
 * <p>
 * @负责小组:   commons
 * <p>
 * <p>
 */
public interface Errorcode
{
    public static final String NOT_FOUND = "404";
    
    public static final String BUSSINESS_ERROR = "bussiness_error";
    
    public String getErrorCode();
}
