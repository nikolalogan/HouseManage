package com.yuxuanting.housemanage.dao;

import com.nikolalogan.core.reponsitory.dao.BaseDao;
import com.yuxuanting.housemanage.entity.Admin;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 18:10
 */
public interface AdminRepository extends BaseDao<Admin,String>, JpaSpecificationExecutor<Admin> {

    /**
     * 通过用户名查找管理员
     * @param loginName 用户名
     * @return 管理员
     */
    Admin findAdminByLoginName(@Param("loginName")String loginName);

    /**
     * 通过登录名查找在线用户
     * @param names
     * @return
     */
    List<Admin> findAdminsByLoginName(Object[] names);

}
