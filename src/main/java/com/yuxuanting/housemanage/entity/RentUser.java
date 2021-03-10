package com.yuxuanting.housemanage.entity;

import cn.hutool.core.date.DateUtil;
import com.nikolalogan.common.core.reponsitory.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description: 租户表
 * @date: 2020-09-01 22:00
 */
@Setter
@Getter
@Entity
@Table(name = "rent_user",uniqueConstraints = {@UniqueConstraint(columnNames="idNo")})
public class RentUser extends BaseEntity {

    @Column
    @NotNull(message = "姓名不能为空")
    private String trueName;

    @Column
    @NotNull(message = "身份证号不能为空")
    @Size(min = 18,max = 18, message = "身份证号位数不对")
    private String idNo;

    @Column
    @NotNull(message = "电话号码不能为空")
    @Size(min = 11,max = 11, message = "电话号码位数不对")
    private String phoneNo;

    @Column
    private String wechatNo;

    /**
     * 1男 0女
     */
    @Column
    @NotNull(message = "性别不能为空")
    private Integer gender;

    @Column
    @NotNull(message = "出生日期不能为空")
    private Date birthday;

    @Column
    private String address;

    private Integer getAge(){
        return DateUtil.age(birthday,new Date());
    }
}
