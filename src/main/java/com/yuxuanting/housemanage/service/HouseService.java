package com.yuxuanting.housemanage.service;

import com.yuxuanting.housemanage.entity.House;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 22:56
 */

public interface HouseService {
    boolean addOrUpdateHouse(House house);

    boolean deleteHouse(String houseId);

    House selectHouse(String houseId);

    List<House> selectFreeHouse();
}
