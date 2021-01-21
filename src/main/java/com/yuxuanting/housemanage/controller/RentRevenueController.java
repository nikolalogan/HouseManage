package com.yuxuanting.housemanage.controller;

import com.yuxuanting.housemanage.entity.revenue.RentRevenue;
import com.yuxuanting.housemanage.service.revenue.RentRevenueService;
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
 * @date: 2020-09-10 00:47
 */
@RestController
public class RentRevenueController {
    @Autowired
    RentRevenueService rentRevenueService;

    @PostMapping("/addOrUpdateRentRevenue")
    Boolean addOrUpdateRentRevenue(@RequestBody @Valid RentRevenue rentRevenue) {
        return rentRevenueService.addOrUpdateRentRevenue(rentRevenue);
    }

    @PostMapping("/selectRentRevenue")
    RentRevenue selectRentRevenue(@RequestParam("rentRevenueId") Long rentRevenueId) {
        return rentRevenueService.selectRentRevenue(rentRevenueId);
    }

    @PostMapping("/deleteRentRevenue")
    boolean deleteRentRevenue(@RequestParam("rentRevenueId") Long rentRevenueId) {
        return rentRevenueService.deleteRevenue(rentRevenueId);
    }

    @PostMapping("/getAllRentRevenue")
    List<RentRevenue> getAllRentRevenue() {
        return rentRevenueService.findAllRentRevenue();
    }
}
