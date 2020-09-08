package com.yuxuanting.housemanage.dao;

import com.yuxuanting.housemanage.dao.core.BaseDao;
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
public interface RentUserRepository extends BaseDao<RentUser,String>, JpaSpecificationExecutor<RentUser> {

}