package com.test.tools.utils.enums;


import com.test.tools.utils.exception.ErrorCode;


/**
 * @ClassName: ErrorResultEnums
 * @Description: TODO
 * @author: lwt
 * @Date: 2019/12/2 13:49
 * @Version: 1.0
 **/
public enum ErrorResultEnums implements ErrorCode {
    E0000("0000", "操作成功！"),

    /**
     * 权限相关 0100-0109
     */
    E0100("0100", "权限验证成功！"),
    E0101("0101", "非法请求，不允许访问！"),
    E0102("0102", "权限验证失败！"),

    /**
     * 错误相关 2000-2999
     */
    E2001("2001", "当前学生不存在！"),
    E2002("2002", "当前学生没有参与过考试！"),
    E2003("2003", "时间区间不能为空！"),
    E2004("2004", "科目ID不能为空！"),


    /**
     * 异常状态 9000-9009
     */
    E9000("9000", "服务器出现异常，请联系管理员！");


    private String code;

    private String message;

    ErrorResultEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
