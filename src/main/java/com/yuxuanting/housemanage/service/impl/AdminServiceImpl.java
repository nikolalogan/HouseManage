package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.yuxuanting.housemanage.dao.AdminRepository;
import com.yuxuanting.housemanage.entity.Admin;
import com.yuxuanting.housemanage.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 21:57
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Boolean login(String name, String passwd) {
        String password = SecureUtil.md5(passwd);
        Admin admin = adminRepository.findAdminsByLoginNameAndPassword(name,password);
        if (ObjectUtil.isNull(admin)){
            return false;
        }else {
            log.info("{}登录成功",name);
            return true;
        }
    }
}
