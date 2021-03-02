package com.yuxuanting.housemanage.controller;

import com.nikolalogan.core.controller.response.Resp;
import com.nikolalogan.core.utils.R;
import com.yuxuanting.housemanage.dto.auth.LoginDto;
import com.yuxuanting.housemanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 21:39
 */
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 使用账号密码登录
     * @param loginDto loginDto
     * @return 登录结果
     */
    @PostMapping("/login")
    Resp Login(@Valid @RequestBody LoginDto loginDto, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        Boolean result = adminService.login(loginDto.getLoginName(), loginDto.getPassword(),ip);
        if (result){
            return R.success();
        }else {
            return R.failed("登陆失败");
        }
    }
}
