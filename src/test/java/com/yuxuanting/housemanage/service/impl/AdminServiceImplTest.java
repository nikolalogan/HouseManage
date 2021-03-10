package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.yuxuanting.housemanage.util.shiro.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {


    @Test
    void logintest(){
        System.out.printf(SecureUtil.md5("123456"));
        JwtUtil jwtUtil = new JwtUtil();
        Claims decode = jwtUtil.decode("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYxNTE5NTQyMSwianRpIjoiYTIzMTFlMTgtYWNiOC00ZTNjLWFhYWQtMTZjZWQ3NmYyNWE5IiwidXNlcm5hbWUiOiJhZG1pbiJ9.gBuTLA68tYFxMUu1iLIx8BNPuyPQ6Di5ASecs7gcJq0");
        System.out.println(decode);
        System.out.println(decode.getExpiration());
        Date date = new Date(1615195421);

        System.out.println(DateUtil.format(date, DatePattern.CHINESE_DATE_TIME_PATTERN));
    }

    public static void main(String[] args) {
        System.out.printf(SecureUtil.md5("123456"));
    }



}