package com.yuxuanting.housemanage.service.impl.revenue;

import cn.hutool.core.bean.BeanUtil;
import com.yuxuanting.housemanage.dao.revenue.RentRevenueRepository;
import com.yuxuanting.housemanage.entity.revenue.RentRevenue;
import com.yuxuanting.housemanage.service.revenue.RentRevenueService;
import org.apache.commons.lang3.StringUtils;
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
    RentRevenueRepository rentRevenueRepository;


    @Override
    public boolean addOrUpdateRentRevenue(RentRevenue rentRevenue) {
        RentRevenue rentRevenueEn =  new RentRevenue();
        if (StringUtils.isNotEmpty(rentRevenue.getId())){
            rentRevenueEn = rentRevenueRepository.getOne(rentRevenue.getId());
        }
        BeanUtil.copyProperties(rentRevenue, rentRevenueEn);
        rentRevenueRepository.saveOrUpdate(rentRevenueEn);
        return true;
    }

    @Override
    public RentRevenue selectRentRevenue(String rentRevenueId) {
        return rentRevenueRepository.getOne(rentRevenueId);
    }

    @Override
    public boolean deleteRevenue(String rentRevenueId) {
        RentRevenue RentRevenue = rentRevenueRepository.getOne(rentRevenueId);
        rentRevenueRepository.delete(RentRevenue);
        return true;
    }

    @Override
    public List<RentRevenue> findAllRentRevenue() {
        return rentRevenueRepository.findAll();
    }
}
