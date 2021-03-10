package com.yuxuanting.housemanage.service;

import com.yuxuanting.housemanage.dto.house.AddHouseDto;
import com.yuxuanting.housemanage.entity.House;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 22:56
 */

public interface HouseService {
    boolean addOrUpdateHouse(AddHouseDto house);

    boolean deleteHouse(Long houseId);

    House selectHouse(Long houseId);

    List<House> selectFreeHouse();
}
