package com.yuxuanting.housemanage.service.impl;

import cn.hutool.json.JSONUtil;
import com.nikolalogan.common.core.dto.LogDto;
import com.nikolalogan.common.core.service.impl.IBaseServiceImpl;
import com.yuxuanting.housemanage.dao.LogDao;
import com.yuxuanting.housemanage.entity.log.BizLog;
import com.yuxuanting.housemanage.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2021-02-20 15:52
 */
@Slf4j
@Service
public class LogServiceImpl extends IBaseServiceImpl<LogDao,LogDto, BizLog> implements LogService {

    @Autowired
    LogDao logDao;

    @Override
    public void info(String operator, String content, Integer logType) {
        BizLog bizLog = new BizLog(operator, BizLog.DEFAULT,content,logType);
        log.info("记录日志：{}", JSONUtil.toJsonStr(bizLog));
        this.logDao.saveOrUpdate(bizLog);
    }

    @Override
    public void info(String operator, Integer status, String content, Integer logType) {
        BizLog bizLog = new BizLog(operator,status,content,logType);
        log.info("记录日志：{}", JSONUtil.toJsonStr(bizLog));
        this.logDao.saveOrUpdate(bizLog);
    }

    @Override
    public void info(String operator, Integer status, String content, Integer logType, BigDecimal amount, Date businessTime, String memo) {
        BizLog bizLog = new BizLog(operator,status,content,logType,amount,businessTime,memo);
        log.info("记录日志：{}", JSONUtil.toJsonStr(bizLog));
        this.logDao.saveOrUpdate(bizLog);
    }
}
