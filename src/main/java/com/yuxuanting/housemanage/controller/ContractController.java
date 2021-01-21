package com.yuxuanting.housemanage.controller;

import com.yuxuanting.housemanage.entity.Contract;
import com.yuxuanting.housemanage.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-10 00:43
 */
public class ContractController {
    @Autowired
    ContractService contractService;

    @PostMapping("/addOrUpdateContract")
    Boolean addOrUpdateContract(@RequestBody @Valid Contract contract) {
        return contractService.addOrUpdateContract(contract);
    }

    @PostMapping("/selectContract")
    Contract selectContract(@RequestParam("contractId") Long contractId) {
        return contractService.selectContract(contractId);
    }

    @PostMapping("/deleteContract")
    boolean deleteContract(@RequestParam("contractId") Long contractId) {
        return contractService.deleteContract(contractId);
    }

    @PostMapping("/getAllContract")
    List<Contract> getAllContract() {
        return contractService.getContracts();
    }
}
