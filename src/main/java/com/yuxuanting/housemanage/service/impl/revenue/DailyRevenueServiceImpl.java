package com.yuxuanting.housemanage.service.impl.revenue;

import cn.hutool.core.bean.BeanUtil;
import com.yuxuanting.housemanage.dao.revenue.DailyRevenueRepository;
import com.yuxuanting.housemanage.entity.revenue.DailyRevenue;
import com.yuxuanting.housemanage.service.revenue.DailyRevenueService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 22:28
 */
@Service
public class DailyRevenueServiceImpl implements DailyRevenueService {
    @Autowired
    DailyRevenueRepository dailyRevenueRepository;


    @Override
    public boolean addOrUpdateDailyRevenue(DailyRevenue dailyRevenue) {
        DailyRevenue dailyRevenueEn =  new DailyRevenue();
        if (ObjectUtils.isNotEmpty(dailyRevenue.getId())){
            dailyRevenueEn = dailyRevenueRepository.getOne(dailyRevenue.getId());
        }
        BeanUtil.copyProperties(dailyRevenue, dailyRevenueEn);
        dailyRevenueRepository.saveOrUpdate(dailyRevenueEn);
        return true;
    }

    @Override
    public DailyRevenue selectDailyRevenue(Long dailyRevenueId) {
        return dailyRevenueRepository.getOne(dailyRevenueId);
    }

    @Override
    public boolean deleteRevenue(Long dailyRevenueId) {
        DailyRevenue dailyRevenue = dailyRevenueRepository.getOne(dailyRevenueId);
        dailyRevenueRepository.delete(dailyRevenue);
        return true;
    }

    @Override
    public List<DailyRevenue> findAllDailyRevenue() {
        return dailyRevenueRepository.findAll();
    }
}
