package com.yuxuanting.housemanage.service;

import com.nikolalogan.core.service.IBaseService;
import com.yuxuanting.housemanage.entity.Admin;

import java.util.List;
import java.util.Map;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 21:56
 */
public interface AdminService {
    /**
     * 登录
     * @param name 用户名
     * @param passwd 密码
     * @param ip 登陆ip
     * @return 登录结果
     */
    Boolean login(String name,String passwd,String ip);


    /**
     * 通过用户名获取管理员
     * @param name 姓名
     * @return Admin
     */
    Admin getAdminByAdminName(String name);

    Map<String, Object> getRolesAndPermissionsByUserName(String userName);

    Map<String, Object> createRandomToken(String textStr);

    boolean checkRandomToken(String sToken, String textStr);

    void addTokenToRedis(String userName, String jwtTokenStr);

    boolean removeJWTToken(String userName);

    /**
     * 查找在线用户
     * @return
     */
    List<Admin> listOnLineUser();
}
