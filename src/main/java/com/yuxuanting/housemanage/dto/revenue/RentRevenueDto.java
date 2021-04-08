package com.yuxuanting.housemanage.dto.revenue;

import com.nikolalogan.common.core.dto.BaseDto;
import com.yuxuanting.housemanage.entity.Admin;
import com.yuxuanting.housemanage.entity.Contract;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2021-03-15 10:11
 */
@Setter
@Getter
public class RentRevenueDto extends BaseDto {

    @NotNull(message = "流水时间不能为空")
    private Date revenueDate;


    @NotNull(message = "流水金额不能为空")
    private BigDecimal revenueMoney;


    @NotNull(message = "备注")
    private String description;


    @NotNull(message = "记录时间不能为空")
    private Date recordDate;

    /**
     * 管理员
     */
    @NotNull(message = "管理员不能为空")
    private Admin admin;

    @NotNull(message = "合同号不能为空")
    private Contract contractId;
}
