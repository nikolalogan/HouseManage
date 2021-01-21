package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.yuxuanting.housemanage.dao.HouseRepository;
import com.yuxuanting.housemanage.entity.House;
import com.yuxuanting.housemanage.service.HouseService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
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
        House houseEn =  new House();
        if (ObjectUtils.isNotEmpty(house.getId())){
            houseEn = houseRepository.getOne(house.getId());
        }
        BeanUtil.copyProperties(house, houseEn);
        houseRepository.saveOrUpdate(houseEn);
        return true;
    }

    @Override
    public boolean deleteHouse(Long houseId) {
        House house = houseRepository.getOne(houseId);
        houseRepository.delete(house);
        return true;
    }

    @Override
    public House selectHouse(Long houseId) {
        return houseRepository.getOne(houseId);
    }

    @Override
    public List<House> selectFreeHouse() {
        return houseRepository.findAllByStatus(House.WAIT);
    }
}
