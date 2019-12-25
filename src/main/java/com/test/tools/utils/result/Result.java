package com.test.tools.utils.result;

import com.test.tools.utils.enums.ErrorResultEnums;
import com.test.tools.utils.exception.ErrorCode;
import com.test.tools.utils.exception.MyException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;

/**
 * @ClassName: Result
 * @Description: 返回值对象
 * @author: lwt
 * @Date: 2019/11/27 10:40
 * @Version: 1.0
 **/
@Slf4j
@ApiModel("返回值")
public class Result<T> implements Serializable {

    @ApiModelProperty("程序返回状态码，0000为正常返回")
    private String code;

    @ApiModelProperty("异常状态描述")
    private String message;

    @ApiModelProperty("返回的数据")
    private T data;


    public Result() {
        this.code = ResultCode.OK;
    }

    public Result(T t) {
        this.code = ResultCode.OK;
        this.data = t;
    }

    public Result(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ErrorResultEnums resultEnums) {
        this.code = resultEnums.getCode();
        this.message = resultEnums.getName();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer url = request.getRequestURL();
        log.info(String.format("%tF %tT \t\t外部程序在调用接口%s时出错,错误信息为------->%s", new Date(), new Date(), url.toString(), resultEnums.getName()));
    }

    public Result(ErrorResultEnums errorResultEnums, T t) {
        this.data = t;
        this.message = errorResultEnums.getName();
        this.code = errorResultEnums.getCode();
    }

    public static <T> Result<T> formatErrorCode(ErrorCode errorCode, Object... params) {
        return new Result<T>(errorCode.getCode(), MessageFormat.format(errorCode.getName(), params));
    }

    public static <T> Result<T> formatException(MyException exception) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURI();
        log.error(String.format("%tF %tT \t\t外部程序在调用接口====>%s<====时，程序抛出异常。异常信息为=======>%s", new Date(), new Date(), url, exception.getMessage()));
        return new Result<T>(exception.getErrorCode().getCode(), exception.getMessage());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
