package com.yuxuanting.housemanage.dao.revenue;

import com.yuxuanting.housemanage.dao.core.BaseDao;
import com.yuxuanting.housemanage.entity.revenue.RevenueType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 18:14
 */
public interface RevenueTypeRepository extends BaseDao<RevenueType,String>, JpaSpecificationExecutor<RevenueType> {
}
