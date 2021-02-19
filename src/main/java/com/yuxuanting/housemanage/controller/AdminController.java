package com.yuxuanting.housemanage.controller;

import com.nikolalogan.core.controller.response.Resp;
import com.yuxuanting.housemanage.dao.AdminRepository;
import com.yuxuanting.housemanage.entity.Admin;
import com.yuxuanting.housemanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 21:39
 */
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/login")
    Resp Login(@RequestParam("name") String name, @RequestParam("passwd") String passwd) {
        Boolean result = adminService.login(name,passwd);
        if (result){
            return Resp.success();
        }else {
            return Resp.failed("登陆失败");
        }
    }
}
