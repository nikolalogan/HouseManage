package com.yuxuanting.housemanage.service;

import com.nikolalogan.common.core.dto.page.PageInfo;
import com.nikolalogan.common.core.dto.page.PageResult;
import com.yuxuanting.housemanage.dto.house.AddHouseDto;
import com.yuxuanting.housemanage.dto.house.SelectHouseDto;
import com.yuxuanting.housemanage.entity.House;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 22:56
 */

public interface HouseService {
    void addOrUpdateHouse(AddHouseDto house);

    void deleteHouse(Long houseId);

    House selectHouse(Long houseId);

    PageResult selectHouses(SelectHouseDto selectHouseDto, PageInfo pageInfo);
}
