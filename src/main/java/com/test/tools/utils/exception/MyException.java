package com.test.tools.utils.exception;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @ClassName: BusinessException
 * @Description: 异常处理类
 * @author: lwt
 * @Date: 2019/11/27 13:59
 * @Version: 1.0
 **/
public class MyException extends RuntimeException implements Serializable {

    private ErrorCode errorCode;

    public MyException(ErrorCode errorCode, Object... params) {
        super(MessageFormat.format(errorCode.getName(), params));
        this.errorCode = errorCode;
    }


    public MyException(ErrorCode errorCode, Throwable t, Object... params) {
        super(MessageFormat.format(errorCode.getName(), params), t);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

}
