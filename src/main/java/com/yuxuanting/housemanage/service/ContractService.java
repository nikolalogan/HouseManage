package com.yuxuanting.housemanage.service;

import com.yuxuanting.housemanage.entity.Contract;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-09 21:55
 */
public interface ContractService {
    boolean addOrUpdateContract(Contract contract);
    Contract selectContract(Long contractId);
    boolean deleteContract(Long contractId);
    List<Contract> getContracts();
}
