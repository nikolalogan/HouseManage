package com.yuxuanting.housemanage.entity;

import com.nikolalogan.core.reponsitory.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 11:32
 */
@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin extends BaseEntity {
    @Column
    private String loginName;

    @Column
    private String password;

    @Column
    private String trueName;

    /**
     * 上次登录时间
     */
    @Column
    private Date lastLoginTime;

    @Column
    private String ip;

    /**
     * 登录次数
     */
    @Column(length = 2)
    private int loginNum = 0;

    /**
     * 尝试次数
     */
    @Column
    private int tryTime = 0;

    /**
     * 是否锁定
     */
    @Column
    private Boolean lock = false;


//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Role> roles;

}
