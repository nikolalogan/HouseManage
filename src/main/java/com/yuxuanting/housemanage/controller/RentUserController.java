package com.yuxuanting.housemanage.controller;

import com.yuxuanting.housemanage.entity.RentUser;
import com.yuxuanting.housemanage.service.RentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-02 14:42
 */
@RestController
public class RentUserController {
    @Autowired
    RentUserService rentUserService;

    @PostMapping("/addOrUpdateRentUser")
    Boolean addOrUpdateRentUser(@RequestBody @Valid RentUser rentUser) {
        return rentUserService.addOrUpdateRentUser(rentUser);
    }

    @PostMapping("/selectRentUser")
    RentUser selectRentUser(@RequestParam("rentUserId") String rentUserId) {
    return rentUserService.selectRentUser(rentUserId);
    }

    @PostMapping("/deleteRentUser")
    boolean deleteRentUser(@RequestParam("rentUserId") String rentUserId) {
    return rentUserService.deleteRentUser(rentUserId);
    }

    @PostMapping("/getAllRentUser")
    List<RentUser> getAllRentUser() {
    return rentUserService.getAllRentUser();
    }


}
