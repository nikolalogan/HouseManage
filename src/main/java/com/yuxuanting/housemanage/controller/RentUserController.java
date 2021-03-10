package com.yuxuanting.housemanage.controller;

import com.nikolalogan.common.core.controller.response.Resp;
import com.nikolalogan.common.core.dto.page.PageInfo;
import com.nikolalogan.common.core.utils.R;
import com.yuxuanting.housemanage.dto.rentuser.AddRentUserDto;
import com.yuxuanting.housemanage.dto.rentuser.SelectRentUserDto;
import com.yuxuanting.housemanage.entity.RentUser;
import com.yuxuanting.housemanage.service.RentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-02 14:42
 */
@RestController
public class RentUserController {
    @Autowired
    RentUserService rentUserService;

    @GetMapping("/addOrUpdateRentUser")
    Resp addOrUpdateRentUser(@RequestBody @Valid AddRentUserDto rentUser) {
        rentUserService.addOrUpdateRentUser(rentUser);
        return R.success("添加成功");
    }

    @GetMapping("/selectRentUser")
    RentUser selectRentUser(@RequestParam("rentUserId") Long rentUserId) {
        return rentUserService.selectRentUser(rentUserId);
    }

    @GetMapping("/deleteRentUser")
    Resp deleteRentUser(@RequestParam("rentUserId") Long rentUserId) {
        rentUserService.deleteRentUser(rentUserId);
        return R.success("删除成功");
    }

    @GetMapping("/getAllRentUser")
    Resp getAllRentUser(SelectRentUserDto rentUser, @Valid PageInfo pageInfo) {
        return R.to(rentUserService.getAllRentUser(rentUser,pageInfo));
    }
}
