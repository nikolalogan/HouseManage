package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.nikolalogan.common.core.service.impl.IBaseServiceImpl;
import com.yuxuanting.housemanage.dao.RentUserRepository;
import com.yuxuanting.housemanage.dto.addRentUserDto;
import com.yuxuanting.housemanage.entity.RentUser;
import com.yuxuanting.housemanage.service.RentUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-02 14:34
 */
@Service
public class RentUserServiceImpl extends IBaseServiceImpl<RentUserRepository, addRentUserDto,RentUser> implements RentUserService {
    @Autowired
    RentUserRepository rentUserRepository;

    @Override
    public boolean addOrUpdateRentUser(addRentUserDto rentUserDto) {
        RentUser rentUser =  new RentUser();
        this.dtoToEntity(rentUserDto,rentUser);
        if (ObjectUtils.isNotEmpty(rentUser.getId())){
            rentUser = rentUserRepository.getOne(rentUser.getId());
        }
        rentUserRepository.saveOrUpdate(rentUser);
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

    @Override
    protected void dtoToEntity(addRentUserDto dto, RentUser entity) {
        BeanUtil.copyProperties(dto,entity);
    }
}
