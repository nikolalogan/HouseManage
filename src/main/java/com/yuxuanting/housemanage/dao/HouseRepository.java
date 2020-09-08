package com.yuxuanting.housemanage.dao;

import com.yuxuanting.housemanage.dao.core.BaseDao;
import com.yuxuanting.housemanage.entity.House;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 18:13
 */
public interface HouseRepository extends BaseDao<House,String>, JpaSpecificationExecutor<House> {
}
