package com.yuxuanting.housemanage.entity.revenue;

import com.nikolalogan.common.core.reponsitory.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 11:50
 */
@Getter
@Setter
@Entity
@Table(name = "revenue_type")
public class RevenueType extends BaseEntity {

    @Column
    @NotNull(message = "日常流水类型不能为空")
    private int revenueType;

    @Column
    @NotNull(message = "日常流水类型名称不能为空")
    private String revenueName;

}
