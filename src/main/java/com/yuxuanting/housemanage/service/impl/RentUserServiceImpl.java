package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.yuxuanting.housemanage.dao.RentUserRepository;
import com.yuxuanting.housemanage.entity.RentUser;
import com.yuxuanting.housemanage.service.RentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean addOrUpdateRentUser(RentUser rentUser) {
        RentUser rentUserEn = rentUserRepository.getOne(rentUser.getId());
        if (ObjectUtil.isNull(rentUserEn)) {
            rentUserEn = new RentUser();
        }
        BeanUtil.copyProperties(rentUser, rentUserEn);
        rentUserRepository.saveOrUpdate(rentUserEn);
        return true;
    }

    @Override
    public RentUser selectRentUser(String rentUserId) {
        rentUserRepository.getOne(rentUserId).getAddress();
        return rentUserRepository.getOne(rentUserId);
    }

    @Override
    public boolean deleteRentUser(String rentUserId) {
        RentUser rentUser = rentUserRepository.getOne(rentUserId);
        rentUserRepository.delete(rentUser);
        return false;
    }

    @Override
    public List<RentUser> getAllRentUser() {
        return rentUserRepository.findAll() ;
    }
}
