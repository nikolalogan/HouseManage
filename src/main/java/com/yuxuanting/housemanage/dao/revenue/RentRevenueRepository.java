package com.yuxuanting.housemanage.dao.revenue;

import com.nikolalogan.common.core.reponsitory.dao.BaseDao;
import com.yuxuanting.housemanage.entity.revenue.RentRevenue;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 18:14
 */
public interface RentRevenueRepository extends BaseDao<RentRevenue,Long>, JpaSpecificationExecutor<RentRevenue> {
}
