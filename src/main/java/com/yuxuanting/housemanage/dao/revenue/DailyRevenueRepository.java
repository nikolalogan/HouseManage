package com.yuxuanting.housemanage.dao.revenue;

import com.nikolalogan.core.reponsitory.dao.BaseDao;
import com.yuxuanting.housemanage.entity.revenue.DailyRevenue;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 18:14
 */
public interface DailyRevenueRepository extends BaseDao<DailyRevenue,Long>, JpaSpecificationExecutor<DailyRevenue> {
}
