package com.yuxuanting.housemanage.controller;

import com.nikolalogan.common.core.controller.response.Resp;
import com.nikolalogan.common.core.utils.R;
import com.yuxuanting.housemanage.dto.revenue.RevenueTypeDto;
import com.yuxuanting.housemanage.entity.revenue.RevenueType;
import com.yuxuanting.housemanage.service.revenue.RevenueTypeService;
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
 * @date: 2020-09-10 00:05
 */
@RestController
public class RevenueTypeController {
    @Autowired
    RevenueTypeService revenueTypeService;

    @PostMapping("/addOrUpdateRevenueType")
    Boolean addOrUpdateRevenueType(@RequestBody @Valid RevenueTypeDto revenueTypeDto) {
        return revenueTypeService.addOrUpdateRevenueType(revenueTypeDto);
    }

    @PostMapping("/selectRevenueType")
    RevenueType selectRevenueType(@RequestParam("revenueTypeId") Long revenueTypeId) {
        return revenueTypeService.selectRevenueType(revenueTypeId);
    }

    @PostMapping("/deleteRevenueType")
    boolean deleteRevenueType(@RequestParam("revenueTypeId") Long revenueTypeId) {
        return revenueTypeService.deleteRevenueType(revenueTypeId);
    }

    @PostMapping("/getAllRevenueType")
    Resp getAllRevenueType() {
        return R.to(revenueTypeService.findAllRevenueType());
    }
}
