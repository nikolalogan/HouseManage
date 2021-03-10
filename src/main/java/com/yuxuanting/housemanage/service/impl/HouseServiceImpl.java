package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.yuxuanting.housemanage.dao.HouseRepository;
import com.yuxuanting.housemanage.dto.house.AddHouseDto;
import com.yuxuanting.housemanage.entity.House;
import com.yuxuanting.housemanage.service.HouseService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public boolean addOrUpdateHouse(AddHouseDto houseDto) {
        House house = new House();
        if (ObjectUtils.isNotEmpty(houseDto.getId())) {
            house = houseRepository.getOne(Long.valueOf(houseDto.getId()));
        }

        this.dtoToEntity(houseDto, house);
        houseRepository.saveOrUpdate(house);
        return true;
    }

    private void dtoToEntity(AddHouseDto houseDto, House house) {
        if (ObjectUtil.isNotNull(houseDto.getId())) {
            house.setId(Long.valueOf(houseDto.getId()));
        }
        if (ObjectUtil.isNotNull(houseDto.getHouseTitle())) {
            house.setHouseTitle(houseDto.getHouseTitle());
        }
        if (ObjectUtil.isNotNull(houseDto.getAddress())) {
            house.setAddress(houseDto.getAddress());
        }
        if (ObjectUtil.isNotNull(houseDto.getPowerMeter())) {
            house.setPowerMeter(houseDto.getPowerMeter());
        }
        if (ObjectUtil.isNotNull(houseDto.getPrice())) {
            house.setPrice(houseDto.getPrice());
        }
        if (ObjectUtil.isNotNull(houseDto.getStatus())) {
            house.setStatus(houseDto.getStatus());
        }
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
//        return houseRepository.findAllByStatus(House.WAIT);
        return null;
    }
}
