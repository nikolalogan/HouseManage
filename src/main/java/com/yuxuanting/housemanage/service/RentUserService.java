package com.yuxuanting.housemanage.service;

import com.yuxuanting.housemanage.entity.RentUser;

import java.util.List;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-02 14:33
 */
public interface RentUserService {
    boolean addOrUpdateRentUser(RentUser rentUser);
    RentUser selectRentUser(String rentUserId);
    boolean deleteRentUser(String rentUserId);
    List<RentUser> getAllRentUser();
}
