package com.yuxuanting.housemanage.entity.revenue;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 日常收支流水
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 15:04
 */

@Getter
@Setter
@Entity
@Table(name = "daily_revenue")
public class DailyRevenue extends Revenue {

    /**
     * 日常收支类型
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private RevenueType revenueType;

}
