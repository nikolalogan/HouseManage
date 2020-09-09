package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.yuxuanting.housemanage.dao.HouseRepository;
import com.yuxuanting.housemanage.entity.House;
import com.yuxuanting.housemanage.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 22:56
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseRepository houseRepository;

    @Override
    public boolean addOrUpdateHouse(House house) {
        House houseEnt = houseRepository.getOne(house.getId());
        if (ObjectUtil.isNull(houseEnt)) {
            houseEnt = new House();
        }
        BeanUtil.copyProperties(house, houseEnt);
        houseRepository.saveOrUpdate(houseEnt);
        return true;
    }

    @Override
    public boolean deleteHouse(String houseId) {
        House house = houseRepository.getOne(houseId);
        houseRepository.delete(house);
        return true;
    }

    @Override
    public House selectHouse(String houseId) {
        return houseRepository.getOne(houseId);
    }

    @Override
    public List<House> selectFreeHouse() {
        return houseRepository.findAllByStatus(House.WAIT);
    }
}
