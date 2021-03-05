package com.yuxuanting.housemanage.entity;

import com.nikolalogan.common.core.reponsitory.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 23:31
 */
@Getter
@Setter
@Entity
@Table(name = "remind")
public class Remind extends BaseEntity {

    @Column
    @NotNull(message = "缴费日期不能为空")
    private Date payDay;

    @Column
    @NotNull(message = "缴费金额")
    private BigDecimal amount;

    @OneToOne(fetch=FetchType.LAZY)
    private Contract contract;
}
