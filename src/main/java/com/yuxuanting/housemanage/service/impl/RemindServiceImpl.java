package com.yuxuanting.housemanage.service.impl;

import com.yuxuanting.housemanage.dao.RemindDao;
import com.yuxuanting.housemanage.entity.Remind;
import com.yuxuanting.housemanage.service.RemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 21:26
 */
@Service
public class RemindServiceImpl implements RemindService {
    @Autowired
    RemindDao remindRepository;

    @Override
    public List<Remind> getRemind() {
        return remindRepository.findAll();
    }
}
