package com.yuxuanting.housemanage.util.shiro;

import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.nikolalogan.core.controller.exception.APIException;
import com.yuxuanting.housemanage.entity.Admin;
import com.yuxuanting.housemanage.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private AdminService adminService;
 
    @Autowired
    RedisTemplate redisTemplate;
 
    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
 
 
    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = JWTUtil.getUsername(principals.toString());
        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
        Map<String, Object> map = null;
        try {
            map = this.adminService.getRolesAndPermissionsByUserName(userName);
            auth.setRoles((Set<String>) map.get("allRoles"));
            auth.setStringPermissions((Set<String>) map.get("allPermissions"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auth;
    }
 
 
    /**
     * 认证
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得userName，用于和数据库进行对比
        String userName = JWTUtil.getUsername(token);
        Admin admin = this.adminService.getAdminByAdminName(userName);
        String redisUserInfo = (String) redisTemplate.opsForValue().get("token_jwt_" + userName);
 
        Map result = JWTUtil.verify(token, userName, admin.getPassword());
        Exception exception = (Exception) result.get("exception");
 
        if (ObjectUtil.isEmpty(admin)) {
            throw new APIException("该帐号不存在！");
        } else if (admin.getLock()) {
            throw new UnknownAccountException("该帐号已被锁定！");
        } else if (exception != null && exception instanceof SignatureVerificationException) {
            throw new AuthenticationException("Token错误(Token incorrect.)！");
        } else if (exception != null && exception instanceof TokenExpiredException) {
            throw new AuthenticationException("Token已过期(Token expired.)！");
            //被T
        } else if(StringUtils.isEmpty(redisUserInfo)){
            throw new AuthenticationException("Token已失效(Token invalid.)！");
        }else {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(token, token, admin.getLoginName());
            return authcInfo;
        }
    }
}