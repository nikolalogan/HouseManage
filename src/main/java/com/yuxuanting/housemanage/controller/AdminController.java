package com.yuxuanting.housemanage.controller;

import com.nikolalogan.common.core.controller.response.Resp;
import com.nikolalogan.common.core.utils.R;
import com.yuxuanting.housemanage.dto.auth.LoginDto;
import com.yuxuanting.housemanage.service.AdminService;
import com.yuxuanting.housemanage.util.shiro.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 21:39
 */
@RestController
@Slf4j
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 使用账号密码登录
     *
     * @param loginDto loginDto
     * @return 登录结果
     */
    @PostMapping("/login")
    public Resp login(@Valid @RequestBody LoginDto loginDto) {
        String username = loginDto.getLoginName();
        String password = loginDto.getPassword();

        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = req.getRemoteAddr();
        log.info("username:{},password:{},ip:{}", username, password,ip);
        return adminService.login(username,password,ip);
    }

    @RequestMapping("/testdemo")
    public ResponseEntity<String> testdemo() {
        return ResponseEntity.ok("我爱蛋炒饭");
    }

}
