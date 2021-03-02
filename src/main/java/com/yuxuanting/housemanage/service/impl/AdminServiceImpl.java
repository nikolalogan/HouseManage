package com.yuxuanting.housemanage.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.nikolalogan.core.controller.exception.APIException;
import com.nikolalogan.core.service.impl.IBaseServiceImpl;
import com.yuxuanting.housemanage.dao.AdminRepository;
import com.yuxuanting.housemanage.dto.auth.LoginDto;
import com.yuxuanting.housemanage.entity.Admin;
import com.yuxuanting.housemanage.service.AdminService;
import com.yuxuanting.housemanage.util.shiro.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 21:57
 */
@Service
@Slf4j
public class AdminServiceImpl extends IBaseServiceImpl<AdminRepository, LoginDto,Admin> implements AdminService{

    //
    @Value("${redis.identifyingTokenExpireTime}")
    private long identifyingTokenExpireTime;
    //redis中jwtToken过期时间
    @Value("${redis.refreshJwtTokenExpireTime}")
    private long refreshJwtTokenExpireTime;


    @Autowired
    AdminRepository adminRepository;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Boolean login(String name, String passwd,String ip) {

        //Todo 加密方式
        String password = SecureUtil.md5(passwd);
        Admin admin = this.entityDao.findAdminByLoginName(name);
        if (ObjectUtil.isEmpty(admin)){

            throw new APIException("该账户不存在，请检查用户名");
        }
        if (admin.getLoginNum()>5){
            throw new APIException("账户已被锁定，请联系管理员");
        }
        if (StringUtils.equals(admin.getPassword(),password)){
            admin.setLastLoginTime(new Date());
            admin.setIp(ip);
            admin.setLoginNum(0);
            this.entityDao.saveOrUpdate(admin);
            log.info("{}登录成功",name);
            return true;
        }else {
            int loginNum = admin.getLoginNum();
            admin.setLoginNum(loginNum++);
            log.info("{}登录失败",name);
            return false;
        }
    }

    @Override
    public Admin getAdminByAdminName(String name) {
        return adminRepository.findAdminByLoginName(name);
    }


    @Override
    public Map<String, Object> getRolesAndPermissionsByUserName(String userName) {
        /*Role role = null;
        Permission permission = null;*/
        Set<String> roles = new HashSet<String>();
        Set<String > permissions = new HashSet<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        Admin vo = this.adminRepository.findAdminByLoginName(userName);
        /*for (int i = 0; i < vo.getRoles().size(); i++) {
            role = vo.getRoles().get(i);
            roles.add(role.getRoleName());
            for (int j = 0; j < role.getPermissions().size(); j++) {
                permission = role.getPermissions().get(i);
                permissions.add(permission.getPermissionName());
            }
        }*/
        map.put("allRoles", roles);
        map.put("allPermissions", permissions);
        return map;
    }

    @Override
    public Map<String, Object> createRandomToken(String textStr) {
        //生成一个token
        String sToken = UUID.randomUUID().toString();
        //生成验证码对应的token  以token为key  验证码为value存在redis中
        redisTemplate.opsForValue().set(CommonConstant.NO_REPEAT_PRE + sToken, textStr, identifyingTokenExpireTime, TimeUnit.MINUTES);
        Map<String, Object> map = new HashMap<>();
        map.put("cToken", sToken);
        return map;
    }

    @Override
    public boolean checkRandomToken(String sToken, String textStr) {
        Object value = redisTemplate.opsForValue().get(CommonConstant.NO_REPEAT_PRE  + sToken);
        if(value != null && textStr.equals(value)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addTokenToRedis(String userName, String jwtTokenStr) {
        String key = CommonConstant.JWT_TOKEN + userName;
        redisTemplate.opsForValue().set(key, jwtTokenStr, refreshJwtTokenExpireTime, TimeUnit.MINUTES);
    }

    @Override
    public boolean removeJWTToken(String userName) {
        String key = CommonConstant.JWT_TOKEN + userName;
        return redisTemplate.delete(key);
    }

    @Override
    public List<Admin> listOnLineUser() {
        Set setNames = redisTemplate.keys(CommonConstant.JWT_TOKEN + "*");
        List list = new ArrayList<>(setNames.size());
        Iterator<String> iter = setNames.iterator();
        while (iter.hasNext()) {
            String temp = iter.next();
            list.add(temp.substring(temp.lastIndexOf("_") + 1));
        }
        return adminRepository.findAdminsByLoginName(list.toArray());
    }
}
