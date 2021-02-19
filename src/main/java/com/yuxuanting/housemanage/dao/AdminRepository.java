package com.yuxuanting.housemanage.dao;

import com.nikolalogan.core.reponsitory.dao.BaseDao;
import com.yuxuanting.housemanage.entity.Admin;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 18:10
 */
public interface AdminRepository extends BaseDao<Admin,String>, JpaSpecificationExecutor<Admin> {

    Admin findAdminsByLoginNameAndPassword(@Param("loginName")String loginName,@Param("password")String password);
}
