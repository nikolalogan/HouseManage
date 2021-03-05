package com.yuxuanting.housemanage.dao;

import com.nikolalogan.common.core.reponsitory.dao.BaseDao;
import com.yuxuanting.housemanage.entity.House;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 18:13
 */
public interface HouseRepository extends BaseDao<House,Long>, JpaSpecificationExecutor<House> {
 }
