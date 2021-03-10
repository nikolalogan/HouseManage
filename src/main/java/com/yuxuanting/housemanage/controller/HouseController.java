package com.yuxuanting.housemanage.controller;

import com.yuxuanting.housemanage.dto.house.AddHouseDto;
import com.yuxuanting.housemanage.entity.House;
import com.yuxuanting.housemanage.entity.House;
import com.yuxuanting.housemanage.service.HouseService;
import com.yuxuanting.housemanage.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 22:54
 */
@RestController
public class HouseController {
    @Autowired
    HouseService houseService;

    @PostMapping("/addOrUpdateHouse")
    Boolean addOrUpdateHouse(@RequestBody @Valid AddHouseDto house) {
        return houseService.addOrUpdateHouse(house);
    }

    @PostMapping("/selectHouse")
    House selectHouse(@RequestParam("houseId") Long houseId) {
        return houseService.selectHouse(houseId);
    }

    @PostMapping("/deleteHouse")
    boolean deleteHouse(@RequestParam("houseId") Long houseId) {
        return houseService.deleteHouse(houseId);
    }

    @PostMapping("/getAllHouse")
    List<House> getAllHouse() {
        return houseService.selectFreeHouse();
    }
}
