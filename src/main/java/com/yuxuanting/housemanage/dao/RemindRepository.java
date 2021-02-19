package com.yuxuanting.housemanage.dao;

import com.nikolalogan.core.reponsitory.dao.BaseDao;
import com.yuxuanting.housemanage.entity.Remind;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 21:50
 */
public interface RemindRepository extends BaseDao<Remind,String>, JpaSpecificationExecutor<Remind> {

}
