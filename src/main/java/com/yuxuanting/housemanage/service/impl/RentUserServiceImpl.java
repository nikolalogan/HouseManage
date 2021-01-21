package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.yuxuanting.housemanage.dao.RentUserRepository;
import com.yuxuanting.housemanage.entity.RentUser;
import com.yuxuanting.housemanage.service.RentUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
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
        RentUser rentUserEn =  new RentUser();
        if (ObjectUtils.isNotEmpty(rentUser.getId())){
            rentUserEn = rentUserRepository.getOne(rentUser.getId());
        }
        BeanUtil.copyProperties(rentUser, rentUserEn);
        rentUserRepository.saveOrUpdate(rentUserEn);
        return true;
    }

    @Override
    public RentUser selectRentUser(Long rentUserId) {
        rentUserRepository.getOne(rentUserId).getAddress();
        return rentUserRepository.getOne(rentUserId);
    }

    @Override
    public boolean deleteRentUser(Long rentUserId) {
        RentUser rentUser = rentUserRepository.getOne(rentUserId);
        rentUserRepository.delete(rentUser);
        return false;
    }

    @Override
    public List<RentUser> getAllRentUser() {
        return rentUserRepository.findAll() ;
    }
}
