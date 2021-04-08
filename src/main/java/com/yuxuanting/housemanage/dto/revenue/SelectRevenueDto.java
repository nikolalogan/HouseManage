package com.yuxuanting.housemanage.dto.revenue;

import com.nikolalogan.common.core.dto.BaseDto;
import com.yuxuanting.housemanage.entity.Admin;
import com.yuxuanting.housemanage.entity.Contract;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2021-03-15 11:20
 */
@Setter
@Getter
public class SelectRevenueDto extends BaseDto {

    private Date revenueDateStart;

    private Date revenueDateEnd;

    private BigDecimal revenueMoneyLimit;

    private BigDecimal revenueMoneyHigh;

    private String description;

    private Date recordDateStart;

    private Date recordDateEnd;

    /**
     * 管理员
     */
    private Admin admin;

    private Contract contractId;
}
