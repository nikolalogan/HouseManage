package com.yuxuanting.housemanage.service.revenue;

import com.yuxuanting.housemanage.entity.revenue.DailyRevenue;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 22:11
 */
public interface DailyRevenueService {
    boolean addOrUpdateDailyRevenue(DailyRevenue dailyRevenue);
    DailyRevenue selectDailyRevenue(String dailyRevenueId);
    boolean deleteRevenue(String dailyRevenueId);
    List<DailyRevenue> findAllDailyRevenue();
}
