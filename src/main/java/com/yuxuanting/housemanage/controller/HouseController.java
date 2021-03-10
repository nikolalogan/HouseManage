package com.yuxuanting.housemanage.controller;

import com.nikolalogan.common.core.controller.response.Resp;
import com.nikolalogan.common.core.dto.page.PageInfo;
import com.nikolalogan.common.core.utils.R;
import com.yuxuanting.housemanage.dto.house.AddHouseDto;
import com.yuxuanting.housemanage.dto.house.SelectHouseDto;
import com.yuxuanting.housemanage.entity.House;
import com.yuxuanting.housemanage.entity.House;
import com.yuxuanting.housemanage.service.HouseService;
import com.yuxuanting.housemanage.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    Resp addOrUpdateHouse(@RequestBody @Valid AddHouseDto house) {
        houseService.addOrUpdateHouse(house);
        return R.success("添加成功");
    }

    @PostMapping("/selectHouse")
    House selectHouse(@RequestParam("houseId") Long houseId) {
        return houseService.selectHouse(houseId);
    }

    @PostMapping("/deleteHouse")
    Resp deleteHouse(@RequestParam("houseId") Long houseId) {
        houseService.deleteHouse(houseId);
        return R.success("删除成功");
    }

    @GetMapping("/getAllHouse")
    Resp getAllHouse(SelectHouseDto selectHouseDto, PageInfo pageInfo) {
        return R.to(houseService.selectHouses(selectHouseDto,pageInfo));
    }
}
