package com.yuxuanting.housemanage.controller;

import com.yuxuanting.housemanage.entity.revenue.DailyRevenue;
import com.yuxuanting.housemanage.service.revenue.DailyRevenueService;
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
public class DailyRevenueController {
    @Autowired
    DailyRevenueService dailyRevenueService;

    @PostMapping("/addOrUpdateDailyRevenue")
    Boolean addOrUpdateDailyRevenue(@RequestBody @Valid DailyRevenue dailyRevenue) {
        return dailyRevenueService.addOrUpdateDailyRevenue(dailyRevenue);
    }

    @PostMapping("/selectDailyRevenue")
    DailyRevenue selectDailyRevenue(@RequestParam("dailyRevenueId") String dailyRevenueId) {
        return dailyRevenueService.selectDailyRevenue(dailyRevenueId);
    }

    @PostMapping("/deleteDailyRevenue")
    boolean deleteDailyRevenue(@RequestParam("dailyRevenueId") String dailyRevenueId) {
        return dailyRevenueService.deleteRevenue(dailyRevenueId);
    }

    @PostMapping("/getAllDailyRevenue")
    List<DailyRevenue> getAllDailyRevenue() {
        return dailyRevenueService.findAllDailyRevenue();
    }
}
