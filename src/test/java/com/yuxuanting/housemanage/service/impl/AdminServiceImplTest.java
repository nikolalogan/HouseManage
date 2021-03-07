package com.yuxuanting.housemanage.service.impl;

import cn.hutool.crypto.SecureUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {

    @Test
    void logintest(){
        System.out.printf(SecureUtil.md5("123456"));
    }

    public static void main(String[] args) {
        System.out.printf(SecureUtil.md5("123456"));
    }

}