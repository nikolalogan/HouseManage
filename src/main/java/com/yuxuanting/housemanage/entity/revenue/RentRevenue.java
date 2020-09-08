package com.yuxuanting.housemanage.entity.revenue;

import com.yuxuanting.housemanage.entity.Contract;
import com.yuxuanting.housemanage.entity.revenue.Revenue;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 租金流水
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 14:51
 */
@Setter
@Getter
@Entity
@Table(name = "rent_revenue")
public class RentRevenue extends Revenue {

    /**
     * 合同
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Contract contract;
}
