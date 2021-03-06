package com.yuxuanting.housemanage.service.revenue;

import com.yuxuanting.housemanage.entity.revenue.RentRevenue;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 22:36
 */
public interface RentRevenueService {
    boolean addOrUpdateRentRevenue(RentRevenue RentRevenue);
    RentRevenue selectRentRevenue(Long RentRevenueId);
    boolean deleteRevenue(Long RentRevenueId);
    List<RentRevenue> findAllRentRevenue();
}
