package com.yuxuanting.housemanage.entity.auth;

import com.nikolalogan.core.reponsitory.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "permission")
public class Permission extends BaseEntity {
    @Column
    private Integer pid;
    @Column
    private String permissionName;
    @Column
    private String desc;
}