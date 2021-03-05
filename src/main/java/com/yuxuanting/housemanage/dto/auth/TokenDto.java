package com.yuxuanting.housemanage.dto.auth;

import com.nikolalogan.common.core.dto.BaseDto;

import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2021-02-26 14:03
 */
public class TokenDto extends BaseDto {
    /**
     * 到期时间
     */
    private Date expireTime;

    /**
     * 短Token
     */
    private String shortToken;

    /**
     * 用户信息
     */
    private String token;
}
