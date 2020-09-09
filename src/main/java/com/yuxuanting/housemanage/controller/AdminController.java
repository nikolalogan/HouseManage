package com.yuxuanting.housemanage.controller;

import com.yuxuanting.housemanage.dao.AdminRepository;
import com.yuxuanting.housemanage.entity.Admin;
import com.yuxuanting.housemanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/login")
    Boolean Login(@RequestParam("name") String name,@RequestParam("passwd") String passwd) {
        return adminService.login(name,passwd);
    }
}
