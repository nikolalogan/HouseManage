package com.yuxuanting.housemanage.entity;

import com.nikolalogan.core.reponsitory.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 11:14
 */
@Getter
@Setter
@Entity
@Table(name = "contract")
public class Contract extends BaseEntity {
    @Column
    @NotNull(message = "签订时间不能为空")
    private Date signDate;

    @Column
    @NotNull(message = "房租起始日期不能为空")
    private Date startDate;

    @Column
    @NotNull(message = "房租终止日期不能为空")
    private Date expiryDate;

    @Column
    @NotNull(message = "押金不能为空")
    private BigDecimal deposit;

    @Column
    @NotNull(message = "单位租金不能为空")
    private BigDecimal determinePrice;

    @Column
    @NotNull(message = "租金方式不能为空")
    private int rentMethod;

    @Column
    @NotNull(message = "电表起始度数不能为空")
    private int powerMeter;

    /**
     * 用户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private RentUser rentUser;


    /**
     * 房屋
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private House house;

}
