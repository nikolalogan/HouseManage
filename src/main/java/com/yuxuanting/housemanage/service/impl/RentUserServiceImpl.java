package com.yuxuanting.housemanage.service.impl;

import com.yuxuanting.housemanage.dao.RentUserRepository;
import com.yuxuanting.housemanage.entity.RentUser;
import com.yuxuanting.housemanage.service.RentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-02 14:34
 */
@Service
public class RentUserServiceImpl implements RentUserService {
    @Autowired
    RentUserRepository rentUserRepository;

    @Override
    public void test() {
        RentUser rentUser = rentUserRepository.getOne("4028fb4d746c9cb601746c9e19a20001");
        rentUser.setIdNo("500231199603251015");
        rentUser.setTrueName("yxt");
        rentUser.setAddress("cq");
        rentUser.setBrityDay(new Date());
        rentUser.setGender("男");
        rentUser.setPhoneNo("18908354841");
        rentUser.setWechatNo("nikolalogan");
        rentUserRepository.saveOrUpdate(rentUser);
    }
}
