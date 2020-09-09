package com.yuxuanting.housemanage.service.impl.revenue;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.yuxuanting.housemanage.dao.revenue.RevenueTypeRepository;
import com.yuxuanting.housemanage.entity.revenue.RevenueType;
import com.yuxuanting.housemanage.entity.revenue.RevenueType;
import com.yuxuanting.housemanage.service.revenue.RevenueTypeService;
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
    com.yuxuanting.housemanage.dao.revenue.RevenueTypeRepository RevenueTypeRepository;


    @Override
    public boolean addOrUpdateRevenueType(RevenueType RevenueType) {
        RevenueType RevenueTypeEn = RevenueTypeRepository.getOne(RevenueType.getId());
        if (ObjectUtil.isNull(RevenueType)) {
            RevenueTypeEn = new RevenueType();
        }
        BeanUtil.copyProperties(RevenueType, RevenueTypeEn);
        RevenueTypeRepository.saveOrUpdate(RevenueTypeEn);
        return true;
    }

    @Override
    public RevenueType selectRevenueType(String RevenueTypeId) {
        return RevenueTypeRepository.getOne(RevenueTypeId);
    }

    @Override
    public boolean deleteRevenueType(String RevenueTypeId) {
        RevenueType RevenueType = RevenueTypeRepository.getOne(RevenueTypeId);
        RevenueTypeRepository.delete(RevenueType);
        return true;
    }

    @Override
    public List<RevenueType> findAllRevenueType() {
        return RevenueTypeRepository.findAll();
    }
}
