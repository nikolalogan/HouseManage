package com.yuxuanting.housemanage.service;

import com.nikolalogan.common.core.dto.page.PageInfo;
import com.nikolalogan.common.core.dto.page.PageResult;
import com.nikolalogan.common.core.service.IBaseService;
import com.yuxuanting.housemanage.dto.rentuser.AddRentUserDto;
import com.yuxuanting.housemanage.dto.rentuser.SelectRentUserDto;
import com.yuxuanting.housemanage.entity.RentUser;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-02 14:33
 */
public interface RentUserService extends IBaseService<AddRentUserDto,RentUser> {
    boolean addOrUpdateRentUser(AddRentUserDto rentUser);
    RentUser selectRentUser(Long rentUserId);
    boolean deleteRentUser(Long rentUserId);
    PageResult getAllRentUser(SelectRentUserDto rentUserDto, PageInfo pageInfo);
}
