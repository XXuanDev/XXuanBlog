package com.xxuan.exception;

import com.xxuan.enums.AppHttpCodeEnum;

/**
 * @ClassName: SystemException
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-27 13:35
 * @Version: V1.0
 */

public class SystemException extends RuntimeException{
    private int code;
    private String msg;
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public SystemException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }
}