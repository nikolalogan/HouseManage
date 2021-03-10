package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.nikolalogan.common.core.dto.page.PageInfo;
import com.nikolalogan.common.core.dto.page.PageResult;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.yuxuanting.housemanage.dao.HouseRepository;
import com.yuxuanting.housemanage.dto.house.AddHouseDto;
import com.yuxuanting.housemanage.dto.house.SelectHouseDto;
import com.yuxuanting.housemanage.entity.House;
import com.yuxuanting.housemanage.entity.QHouse;
import com.yuxuanting.housemanage.service.HouseService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 22:56
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseRepository houseRepository;

    @Override
    public void addOrUpdateHouse(AddHouseDto houseDto) {
        House house = new House();
        if (ObjectUtils.isNotEmpty(houseDto.getId())) {
            house = houseRepository.getOne(Long.valueOf(houseDto.getId()));
        }

        this.dtoToEntity(houseDto, house);
        houseRepository.saveOrUpdate(house);
    }

    private void dtoToEntity(AddHouseDto houseDto, House house) {
        if (ObjectUtil.isNotNull(houseDto.getId())) {
            house.setId(Long.valueOf(houseDto.getId()));
        }
        if (ObjectUtil.isNotNull(houseDto.getHouseTitle())) {
            house.setHouseTitle(houseDto.getHouseTitle());
        }
        if (ObjectUtil.isNotNull(houseDto.getAddress())) {
            house.setAddress(houseDto.getAddress());
        }
        if (ObjectUtil.isNotNull(houseDto.getPowerMeter())) {
            house.setPowerMeter(houseDto.getPowerMeter());
        }
        if (ObjectUtil.isNotNull(houseDto.getPrice())) {
            house.setPrice(houseDto.getPrice());
        }
        if (ObjectUtil.isNotNull(houseDto.getStatus())) {
            house.setStatus(houseDto.getStatus());
        }
    }

    @Override
    public void deleteHouse(Long houseId) {
        House house = houseRepository.getOne(houseId);
        houseRepository.delete(house);
    }

    @Override
    public House selectHouse(Long houseId) {
        return houseRepository.getOne(houseId);
    }

    @Override
    public PageResult selectHouses(SelectHouseDto selectHouseDto, PageInfo pageInfo) {
        QHouse qHouse = QHouse.house;
        BooleanBuilder builder = new BooleanBuilder();
        if (ObjectUtil.isNotNull(selectHouseDto.getHouseTitle())){
            builder.and(qHouse.houseTitle.like("%"+selectHouseDto.getHouseTitle()+"%"));
        }
        if (ObjectUtil.isNotNull(selectHouseDto.getPriceLow())){
            builder.and(qHouse.price.goe(selectHouseDto.getPriceLow()));
        }
        if (ObjectUtil.isNotNull(selectHouseDto.getPriceHigh())){
            builder.and(qHouse.price.loe(selectHouseDto.getPriceHigh()));
        }
        if (ObjectUtil.isNotNull(selectHouseDto.getAddress())){
            builder.and(qHouse.address.like("%"+selectHouseDto.getAddress()+"%"));
        }
        if (ObjectUtil.isNotNull(selectHouseDto.getStatus())){
            builder.and(qHouse.status.eq(Integer.valueOf(selectHouseDto.getStatus())));
        }
        Predicate value = builder.getValue();
        if (ObjectUtil.isEmpty(value)) {
            value = new BooleanBuilder();
        }
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "createTime"));
        PageRequest pageRequest = PageRequest.of(pageInfo.getPage() - 1, pageInfo.getLimit(), sort);
        Page<House> bizLogs = houseRepository.findAll(value, pageRequest);
        PageResult pageResult = PageResult.builder().build();
        pageResult.setRows(bizLogs.getContent());
        pageResult.setTotal(bizLogs.getTotalElements());
        return pageResult;
    }
}
