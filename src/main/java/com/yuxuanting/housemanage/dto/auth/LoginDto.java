package com.yuxuanting.housemanage.dto.auth;

import com.nikolalogan.common.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2021-02-20 11:24
 */
@Setter
@Getter
public class LoginDto extends BaseDto {
    @NotNull(message = "登录名不能为空")
    private String loginName;

    @NotNull(message = "密码不能为空")
    private String password;
}
