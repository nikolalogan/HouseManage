package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.yuxuanting.housemanage.dao.ContractRepository;
import com.yuxuanting.housemanage.entity.Contract;
import com.yuxuanting.housemanage.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 21:56
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public boolean addOrUpdateContract(Contract contract) {
        Contract contractEn = contractRepository.getOne(contract.getId());
        if (ObjectUtil.isNull(contractRepository)) {
            contractEn = new Contract();
        }
        BeanUtil.copyProperties(contract, contractEn);
        contractRepository.saveOrUpdate(contractEn);
        return true;
    }

    @Override
    public Contract selectContract(String contractId) {
        return contractRepository.getOne(contractId);
    }

    @Override
    public boolean deleteContract(String contractId) {
        Contract contract = contractRepository.getOne(contractId);
        contractRepository.delete(contract);
        return true;
    }

    @Override
    public List<Contract> getContracts() {
        return contractRepository.findAll();
    }
}