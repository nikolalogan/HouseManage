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
        log.info("username:{},password:{}", username, password);
        if (!"tom".equals(username) || !"123".equals(password)) {
            return R.failed("用户名密码错误");
        }
        JwtUtil jwtUtil = new JwtUtil();
        Map<String, Object> chaim = new HashMap<>();
        chaim.put("username", username);
        String jwtToken = jwtUtil.encode(username, 5 * 60 * 1000, chaim);
        return R.success("登陆成功");
    }

    @RequestMapping("/testdemo")
    public ResponseEntity<String> testdemo() {
        return ResponseEntity.ok("我爱蛋炒饭");
    }

}
