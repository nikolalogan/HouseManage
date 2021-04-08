package com.yuxuanting.housemanage.controller;

import com.nikolalogan.common.core.controller.response.Resp;
import com.nikolalogan.common.core.dto.page.PageInfo;
import com.nikolalogan.common.core.utils.R;
import com.yuxuanting.housemanage.dto.revenue.RentRevenueDto;
import com.yuxuanting.housemanage.dto.revenue.SelectRevenueDto;
import com.yuxuanting.housemanage.entity.revenue.RentRevenue;
import com.yuxuanting.housemanage.service.revenue.RentRevenueService;
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
 * @date: 2020-09-10 00:47
 */
@RestController
public class RentRevenueController {
    @Autowired
    RentRevenueService rentRevenueService;

    @PostMapping("/addOrUpdateRentRevenue")
    Resp addOrUpdateRentRevenue(@RequestBody @Valid RentRevenueDto rentRevenueDto) {
         rentRevenueService.addOrUpdateRentRevenue(rentRevenueDto);
         return R.success();
    }

    @PostMapping("/selectRentRevenue")
    RentRevenueDto selectRentRevenue(@RequestParam("rentRevenueId") Long rentRevenueId) {
        return rentRevenueService.selectRentRevenue(rentRevenueId);
    }

    @PostMapping("/deleteRentRevenue")
    Resp deleteRentRevenue(@RequestParam("rentRevenueId") Long rentRevenueId) {
        rentRevenueService.deleteRevenue(rentRevenueId);
        return R.success();
    }

    @GetMapping("/getAllRentRevenue")
    Resp getAllRentRevenue(SelectRevenueDto selectRevenueDto, @Valid PageInfo pageInfo) {
        return R.to(rentRevenueService.findAllRentRevenue(selectRevenueDto,pageInfo));
    }
}
