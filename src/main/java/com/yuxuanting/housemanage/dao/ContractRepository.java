package com.yuxuanting.housemanage.dao;

import com.yuxuanting.housemanage.dao.core.BaseDao;
import com.yuxuanting.housemanage.entity.Contract;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 18:11
 */
public interface ContractRepository extends BaseDao<Contract,String>, JpaSpecificationExecutor<Contract> {
}
