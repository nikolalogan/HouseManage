package com.yuxuanting.housemanage.service.impl.revenue;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.yuxuanting.housemanage.dao.revenue.RentRevenueRepository;
import com.yuxuanting.housemanage.entity.revenue.RentRevenue;
import com.yuxuanting.housemanage.entity.revenue.RentRevenue;
import com.yuxuanting.housemanage.service.revenue.RentRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 22:36
 */
@Service
public class RentRevenueServiceImpl implements RentRevenueService {
    @Autowired
    RentRevenueRepository RentRevenueRepository;


    @Override
    public boolean addOrUpdateRentRevenue(RentRevenue RentRevenue) {
        RentRevenue RentRevenueEn = RentRevenueRepository.getOne(RentRevenue.getId());
        if (ObjectUtil.isNull(RentRevenue)) {
            RentRevenueEn = new RentRevenue();
        }
        BeanUtil.copyProperties(RentRevenue, RentRevenueEn);
        RentRevenueRepository.saveOrUpdate(RentRevenueEn);
        return true;
    }

    @Override
    public RentRevenue selectRentRevenue(String RentRevenueId) {
        return RentRevenueRepository.getOne(RentRevenueId);
    }

    @Override
    public boolean deleteRevenue(String RentRevenueId) {
        RentRevenue RentRevenue = RentRevenueRepository.getOne(RentRevenueId);
        RentRevenueRepository.delete(RentRevenue);
        return true;
    }

    @Override
    public List<RentRevenue> findAllRentRevenue() {
        return RentRevenueRepository.findAll();
    }
}
