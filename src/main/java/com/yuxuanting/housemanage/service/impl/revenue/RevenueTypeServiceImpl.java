package com.yuxuanting.housemanage.service.impl.revenue;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.yuxuanting.housemanage.dao.revenue.RevenueTypeRepository;
import com.yuxuanting.housemanage.dto.revenue.RevenueTypeDto;
import com.yuxuanting.housemanage.entity.revenue.RevenueType;
import com.yuxuanting.housemanage.service.revenue.RevenueTypeService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public boolean addOrUpdateRevenueType(RevenueTypeDto revenueTypeDto) {
        RevenueType revenueType =  new RevenueType();
        if (ObjectUtils.isNotEmpty(revenueTypeDto.getId())){
            revenueType = revenueTypeRepository.getOne(Long.valueOf(revenueTypeDto.getId()));
        }

        this.dtoToEntity(revenueTypeDto, revenueType);
        revenueTypeRepository.saveOrUpdate(revenueType);
        return true;
    }

    private void dtoToEntity(RevenueTypeDto revenueTypeDto, RevenueType revenueType) {
        if (ObjectUtils.isNotEmpty(revenueTypeDto.getRevenueType())){
            revenueType.setRevenueType(revenueTypeDto.getRevenueType());
        }
        if (ObjectUtils.isNotEmpty(revenueTypeDto.getRevenueName())){
            revenueType.setRevenueName(revenueTypeDto.getRevenueName());
        }
    }
    private void entityToDto(RevenueTypeDto revenueTypeDto, RevenueType revenueType) {
        if (ObjectUtils.isNotEmpty(revenueType.getRevenueType())){
            revenueTypeDto.setRevenueType(revenueType.getRevenueType());
        }
        if (ObjectUtils.isNotEmpty(revenueType.getRevenueName())){
            revenueTypeDto.setRevenueName(revenueType.getRevenueName());
        }
    }

    @Override
    public RevenueType selectRevenueType(Long revenueTypeId) {
        return revenueTypeRepository.getOne(revenueTypeId);
    }

    @Override
    public boolean deleteRevenueType(Long revenueTypeId) {
        RevenueType RevenueType = revenueTypeRepository.getOne(revenueTypeId);
        revenueTypeRepository.delete(RevenueType);
        return true;
    }

    @Override
    public List<RevenueTypeDto> findAllRevenueType() {

        List<RevenueType> list = revenueTypeRepository.findAll();
        List<RevenueTypeDto> dtoList =new ArrayList<RevenueTypeDto>();
        list.forEach((type)->{
            RevenueTypeDto dto = new RevenueTypeDto();
            this.entityToDto(dto,type);
            dtoList.add(dto);
        });
        return dtoList;
    }
}
