package com.test.tools.utils.exception;

/**
 * 异常处理接口
 */
public interface ErrorCode {
    /**
     * 获取错误代码
     *
     * @return
     */
    String getCode();

    /**
     * 获取异常名称
     *
     * @return
     */
    String getName();

}
