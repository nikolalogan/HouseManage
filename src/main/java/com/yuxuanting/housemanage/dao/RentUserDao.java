package com.yuxuanting.housemanage.dao;

import com.nikolalogan.common.core.reponsitory.dao.BaseDao;
import com.yuxuanting.housemanage.entity.RentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-01 23:16
 */
@Repository
public interface RentUserDao extends BaseDao<RentUser,Long>, JpaSpecificationExecutor<RentUser> {

    RentUser findByIdNo(String idNo);
}
