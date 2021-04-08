package com.yuxuanting.housemanage.service.revenue;

import com.nikolalogan.common.core.dto.page.PageInfo;
import com.nikolalogan.common.core.dto.page.PageResult;
import com.yuxuanting.housemanage.dto.revenue.RentRevenueDto;
import com.yuxuanting.housemanage.dto.revenue.SelectRevenueDto;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 22:36
 */
public interface RentRevenueService {
    void addOrUpdateRentRevenue(RentRevenueDto rentRevenueDto);
    RentRevenueDto selectRentRevenue(Long RentRevenueId);
    void deleteRevenue(Long RentRevenueId);
    PageResult findAllRentRevenue(SelectRevenueDto selectRevenueDto, PageInfo pageInfo);
}
