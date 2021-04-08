package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.nikolalogan.common.core.controller.exception.APIException;
import com.nikolalogan.common.core.dto.page.PageInfo;
import com.nikolalogan.common.core.dto.page.PageResult;
import com.nikolalogan.common.core.service.impl.IBaseServiceImpl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.yuxuanting.housemanage.dao.RentUserDao;
import com.yuxuanting.housemanage.dto.rentuser.AddRentUserDto;
import com.yuxuanting.housemanage.dto.rentuser.SelectRentUserDto;
import com.yuxuanting.housemanage.entity.QRentUser;
import com.yuxuanting.housemanage.entity.RentUser;
import com.yuxuanting.housemanage.service.RentUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-02 14:34
 */
@Service
@Slf4j
public class RentUserServiceImpl extends IBaseServiceImpl<RentUserDao, AddRentUserDto, RentUser> implements RentUserService {
    @Autowired
    RentUserDao rentUserRepository;

    @Override
    public void addOrUpdateRentUser(AddRentUserDto rentUserDto) {
        RentUser rentUser = new RentUser();
        if (ObjectUtils.isNotEmpty(rentUserDto.getIdNo())) {
            RentUser byIdNo = rentUserRepository.findByIdNo(rentUserDto.getIdNo());
            if (ObjectUtils.isNotEmpty(byIdNo)) {
                throw new APIException("当前用户已存在");
            }
        }
        this.dtoToEntity(rentUserDto, rentUser);
        rentUserRepository.saveOrUpdate(rentUser);
    }

    @Override
    public RentUser selectRentUser(Long rentUserId) {
        return rentUserRepository.getOne(rentUserId);
    }

    @Override
    public void deleteRentUser(Long rentUserId) {
        RentUser rentUser = rentUserRepository.getOne(rentUserId);
        rentUserRepository.delete(rentUser);
    }

    @Override
    public PageResult getAllRentUser(SelectRentUserDto rentUserDto, PageInfo pageInfo) {
        QRentUser qRentUser = QRentUser.rentUser;
        BooleanBuilder builder = new BooleanBuilder();
        if (ObjectUtil.isNotNull(rentUserDto.getIdNo())) {
            builder.and(qRentUser.idNo.eq(rentUserDto.getIdNo()));
        }
        if (ObjectUtil.isNotNull(rentUserDto.getAddress())) {
            builder.and(qRentUser.address.like("%"+rentUserDto.getAddress()+"%"));
        }
        if (ObjectUtil.isNotNull(rentUserDto.getTrueName())) {
            builder.and(qRentUser.trueName.eq(rentUserDto.getTrueName()));
        }
        if (ObjectUtil.isNotNull(rentUserDto.getAgeEnd())){
            DateTime offset = DateUtil.offset(new Date(), DateField.YEAR, -rentUserDto.getAgeEnd());
            builder.and(qRentUser.birthday.after(offset));
        }
        if (ObjectUtil.isNotNull(rentUserDto.getAgeStart())){
            DateTime offset = DateUtil.offset(new Date(), DateField.YEAR, -rentUserDto.getAgeStart());
            builder.and(qRentUser.birthday.before(offset));
        }
        if (ObjectUtil.isNotNull(rentUserDto.getGender())) {
            builder.and(qRentUser.gender.eq(rentUserDto.getGender()));
        }
        if (ObjectUtil.isNotNull(rentUserDto.getPhoneNo())) {
            builder.and(qRentUser.phoneNo.eq(rentUserDto.getPhoneNo()));
        }
        if (ObjectUtil.isNotNull(rentUserDto.getWechatNo())) {
            builder.and(qRentUser.wechatNo.eq(rentUserDto.getWechatNo()));
        }

        Predicate value = builder.getValue();
        if (ObjectUtil.isEmpty(value)) {
            value = new BooleanBuilder();
        }

        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "createTime"));
        PageRequest pageRequest = PageRequest.of(pageInfo.getPage() - 1, pageInfo.getLimit(), sort);
        Page<RentUser> bizLogs = rentUserRepository.findAll(value, pageRequest);
        PageResult pageResult = PageResult.builder().build();
        pageResult.setRows(bizLogs.getContent());
        pageResult.setTotal(bizLogs.getTotalElements());
        return pageResult;
    }

    @Override
    protected void dtoToEntity(AddRentUserDto dto, RentUser entity) {
        if (ObjectUtil.isNotNull(dto.getId())) {
            entity.setId(Long.valueOf(dto.getId()));
        }
        if (ObjectUtil.isNotNull(dto.getTrueName())) {
            entity.setTrueName(dto.getTrueName());
        }
        if (ObjectUtil.isNotNull(dto.getPhoneNo())) {
            entity.setPhoneNo(dto.getPhoneNo());
        }
        if (ObjectUtil.isNotNull(dto.getAddress())) {
            entity.setAddress(dto.getAddress());
        }
        if (ObjectUtil.isNotNull(dto.getBirthday())) {
            entity.setBirthday(dto.getBirthday());
        }
        if (ObjectUtil.isNotNull(dto.getGender())) {
            entity.setGender(dto.getGender());
        }
        if (ObjectUtil.isNotNull(dto.getWechatNo())) {
            entity.setWechatNo(dto.getWechatNo());
        }
        if (ObjectUtil.isNotNull(dto.getIdNo())) {
            entity.setIdNo(dto.getIdNo());
        }
    }
}
