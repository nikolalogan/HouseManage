package com.yuxuanting.housemanage.controller;

import com.yuxuanting.housemanage.service.RentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-02 14:42
 */
@RestController
public class RentUserController {
    @Autowired
    RentUserService rentUserService;

    @GetMapping("/test")
    public void test(){
        rentUserService.test();
    }

}
