package com.yuxuanting.housemanage.entity.revenue;

import com.nikolalogan.common.core.reponsitory.entity.BaseEntity;
import com.yuxuanting.housemanage.entity.Admin;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 11:31
 */
@Getter
@Setter
@MappedSuperclass
public class Revenue extends BaseEntity {
    @Column
    @NotNull(message = "流水时间不能为空")
    private Date revenueDate;

    @Column
    @NotNull(message = "流水金额不能为空")
    private BigDecimal revenueMoney;

    @Column
    @NotNull(message = "备注")
    private String description;

    @Column
    @NotNull(message = "记录时间不能为空")
    private Date recordDate;

    /**
     * 管理员
     */
    @OneToOne(fetch = FetchType.LAZY)
    private Admin admin;

}
