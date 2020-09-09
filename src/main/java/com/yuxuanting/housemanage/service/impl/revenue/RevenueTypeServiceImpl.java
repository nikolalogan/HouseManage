package com.yuxuanting.housemanage.service.impl.revenue;

import cn.hutool.core.bean.BeanUtil;
import com.yuxuanting.housemanage.dao.revenue.RevenueTypeRepository;
import com.yuxuanting.housemanage.entity.revenue.RevenueType;
import com.yuxuanting.housemanage.service.revenue.RevenueTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 23:54
 */
@Service
public class RevenueTypeServiceImpl implements RevenueTypeService {
    @Autowired
    RevenueTypeRepository revenueTypeRepository;


    @Override
    public boolean addOrUpdateRevenueType(RevenueType revenueType) {
        RevenueType revenueTypeEn =  new RevenueType();
        if (StringUtils.isNotEmpty(revenueType.getId())){
            revenueTypeEn = revenueTypeRepository.getOne(revenueType.getId());
        }
        BeanUtil.copyProperties(revenueType, revenueTypeEn);
        revenueTypeRepository.saveOrUpdate(revenueTypeEn);
        return true;
    }

    @Override
    public RevenueType selectRevenueType(String revenueTypeId) {
        return revenueTypeRepository.getOne(revenueTypeId);
    }

    @Override
    public boolean deleteRevenueType(String revenueTypeId) {
        RevenueType RevenueType = revenueTypeRepository.getOne(revenueTypeId);
        revenueTypeRepository.delete(RevenueType);
        return true;
    }

    @Override
    public List<RevenueType> findAllRevenueType() {
        return revenueTypeRepository.findAll();
    }
}
