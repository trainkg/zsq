package zsq.triankg.core.util.exception;

/**
 * 业务运行时错误, 统一封装减少对上层的Try catch 污染, 当业务抛出该异常或子类时 , 需要在DOC中明确描述
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
public class ServiceException extends RuntimeException implements Errorcode
{

    private static final long serialVersionUID = -2779970763677402685L;

    /**
     * EXCEPTION ERROR CODE;
     */
    private String errorCode;

    public ServiceException()
    {
        super();
    }

    public ServiceException(String message, Throwable cause, String code)
    {
        super(message, cause);
        this.errorCode = code;
    }

    public ServiceException(String message, String code)
    {
        super(message);
        this.errorCode = code;
    }

    public ServiceException(Throwable cause, String code)
    {
        super(cause);
        this.errorCode = code;
    }

    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ServiceException(String message)
    {
        super(message);
    }

    public ServiceException(Throwable cause)
    {
        super(cause);
    }

    public String getErrorCode()
    {
        return this.errorCode;
    }

}
