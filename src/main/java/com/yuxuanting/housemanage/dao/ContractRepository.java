package com.yuxuanting.housemanage.dao;

import com.nikolalogan.core.reponsitory.dao.BaseDao;
import com.yuxuanting.housemanage.entity.Contract;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 18:11
 */
public interface ContractRepository extends BaseDao<Contract,Long>, JpaSpecificationExecutor<Contract> {
}
