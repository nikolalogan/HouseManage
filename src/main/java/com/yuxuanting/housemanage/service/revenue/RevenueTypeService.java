package com.yuxuanting.housemanage.service.revenue;

import com.yuxuanting.housemanage.dto.revenue.RevenueTypeDto;
import com.yuxuanting.housemanage.entity.revenue.RevenueType;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 23:54
 */
public interface RevenueTypeService {
    boolean addOrUpdateRevenueType(RevenueTypeDto revenueTypeDto);
    RevenueType selectRevenueType(Long RevenueTypeId);
    boolean deleteRevenueType(Long RevenueTypeId);
    List<RevenueTypeDto> findAllRevenueType();
}
