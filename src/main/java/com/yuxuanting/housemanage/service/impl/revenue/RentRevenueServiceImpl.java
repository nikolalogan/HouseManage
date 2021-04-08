package com.yuxuanting.housemanage.service.impl.revenue;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.nikolalogan.common.core.dto.page.PageInfo;
import com.nikolalogan.common.core.dto.page.PageResult;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.yuxuanting.housemanage.dao.revenue.RentRevenueRepository;
import com.yuxuanting.housemanage.dto.revenue.RentRevenueDto;
import com.yuxuanting.housemanage.dto.revenue.SelectRevenueDto;
import com.yuxuanting.housemanage.entity.RentUser;
import com.yuxuanting.housemanage.entity.revenue.QRentRevenue;
import com.yuxuanting.housemanage.entity.revenue.RentRevenue;
import com.yuxuanting.housemanage.service.revenue.RentRevenueService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public void addOrUpdateRentRevenue(RentRevenueDto rentRevenueDto) {
        RentRevenue rentRevenue =  new RentRevenue();
        if (ObjectUtils.isNotEmpty(rentRevenueDto.getId())){
            rentRevenue = rentRevenueRepository.getOne(Long.valueOf(rentRevenueDto.getId()));
        }
        dtoToEntity(rentRevenueDto, rentRevenue);

        rentRevenueRepository.saveOrUpdate(rentRevenue);
    }

    private void dtoToEntity(RentRevenueDto rentRevenueDto, RentRevenue rentRevenue) {
        if (ObjectUtil.isNotEmpty(rentRevenueDto.getRevenueDate())){
            rentRevenue.setRevenueDate(rentRevenueDto.getRevenueDate());
        }
        if (ObjectUtil.isNotEmpty(rentRevenueDto.getRevenueMoney())){
            rentRevenue.setRevenueMoney(rentRevenueDto.getRevenueMoney());
        }
        if (ObjectUtil.isNotEmpty(rentRevenueDto.getAdmin())){
            rentRevenue.setAdmin(rentRevenueDto.getAdmin());
        }
        if (ObjectUtil.isNotEmpty(rentRevenueDto.getContractId())){
            rentRevenue.setContract(rentRevenueDto.getContractId());
        }
        if (ObjectUtil.isNotEmpty(rentRevenueDto.getDescription())){
            rentRevenue.setDescription(rentRevenueDto.getDescription());
        }
        if (ObjectUtil.isNotEmpty(rentRevenueDto.getRecordDate())){
            rentRevenue.setRecordDate(rentRevenueDto.getRecordDate());
        }
    }

    @Override
    public RentRevenueDto selectRentRevenue(Long rentRevenueId) {
        RentRevenue rentRevenue =rentRevenueRepository.getOne(rentRevenueId);

        RentRevenueDto rentRevenueDto =new RentRevenueDto();
        if (ObjectUtil.isNotEmpty(rentRevenue.getRevenueDate())){
            rentRevenueDto.setRevenueDate(rentRevenue.getRevenueDate());
        }
        if (ObjectUtil.isNotEmpty(rentRevenue.getRevenueMoney())){
            rentRevenueDto.setRevenueMoney(rentRevenue.getRevenueMoney());
        }
        if (ObjectUtil.isNotEmpty(rentRevenue.getAdmin())){
            rentRevenueDto.setAdmin(rentRevenue.getAdmin());
        }
        if (ObjectUtil.isNotEmpty(rentRevenue.getContract())){
            rentRevenueDto.setContractId(rentRevenue.getContract());
        }
        if (ObjectUtil.isNotEmpty(rentRevenue.getDescription())){
            rentRevenueDto.setDescription(rentRevenue.getDescription());
        }
        if (ObjectUtil.isNotEmpty(rentRevenue.getRecordDate())){
            rentRevenueDto.setRecordDate(rentRevenue.getRecordDate());
        }

        return rentRevenueDto;
    }

    @Override
    public void deleteRevenue(Long rentRevenueId) {
        RentRevenue RentRevenue = rentRevenueRepository.getOne(rentRevenueId);
        rentRevenueRepository.delete(RentRevenue);
    }

    @Override
    public PageResult findAllRentRevenue(SelectRevenueDto selectRevenueDto, PageInfo pageInfo) {
        QRentRevenue qRentRevenue = QRentRevenue.rentRevenue;

        BooleanBuilder builder = new BooleanBuilder();

        if (ObjectUtil.isNotEmpty(selectRevenueDto.getRevenueDateStart())){
            builder.and(qRentRevenue.revenueDate.after(selectRevenueDto.getRevenueDateStart()));
        }
        if (ObjectUtil.isNotEmpty(selectRevenueDto.getRevenueDateEnd())){
            builder.and(qRentRevenue.revenueDate.before(selectRevenueDto.getRevenueDateEnd()));
        }
        if (ObjectUtil.isNotEmpty(selectRevenueDto.getRevenueMoneyHigh())){
            builder.and(qRentRevenue.revenueMoney.loe(selectRevenueDto.getRevenueMoneyHigh()));
        }
        if (ObjectUtil.isNotEmpty(selectRevenueDto.getRevenueMoneyLimit())){
            builder.and(qRentRevenue.revenueMoney.goe(selectRevenueDto.getRevenueMoneyLimit()));
        }
        if (ObjectUtil.isNotEmpty(selectRevenueDto.getAdmin())){
            builder.and(qRentRevenue.admin.eq(selectRevenueDto.getAdmin()));
        }
        if (ObjectUtil.isNotEmpty(selectRevenueDto.getContractId())){
            builder.and(qRentRevenue.contract.eq(selectRevenueDto.getContractId()));
        }
        if (ObjectUtil.isNotEmpty(selectRevenueDto.getDescription())){
            builder.and(qRentRevenue.description.eq(selectRevenueDto.getDescription()));
        }
        if (ObjectUtil.isNotEmpty(selectRevenueDto.getRevenueDateStart())){
            builder.and(qRentRevenue.recordDate.after(selectRevenueDto.getRevenueDateStart()));
        }
        if (ObjectUtil.isNotEmpty(selectRevenueDto.getRecordDateEnd())) {
            builder.and(qRentRevenue.recordDate.before(selectRevenueDto.getRecordDateEnd()));
        }

        Predicate predicate = builder.getValue();
        if (ObjectUtil.isEmpty(predicate)){
            predicate = new BooleanBuilder();
        }

        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "createTime"));
        PageRequest pageRequest = PageRequest.of(pageInfo.getPage() - 1, pageInfo.getLimit(), sort);
        Page<RentRevenue> bizLogs = rentRevenueRepository.findAll(predicate, pageRequest);
        PageResult pageResult = PageResult.builder().build();
        pageResult.setRows(bizLogs.getContent());
        pageResult.setTotal(bizLogs.getTotalElements());
        return pageResult;
    }
}
