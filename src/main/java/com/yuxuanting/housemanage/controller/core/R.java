package com.yuxuanting.housemanage.controller.core;

import lombok.Getter;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 21:13
 */

@Getter
public class R<T> {
    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;


    public R(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public R(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}