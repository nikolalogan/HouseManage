package com.yuxuanting.housemanage.entity;

import com.nikolalogan.core.reponsitory.entity.BaseEntity;
import com.nikolalogan.core.reponsitory.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
    @NotNull(message = "登录名不能为空")
    private String loginName;

    @Column
    @NotNull(message = "密码不能为空")
    private String password;

    @Column
    @NotNull(message = "姓名不能为空")
    private String trueName;

}
