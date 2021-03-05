package com.yuxuanting.housemanage.entity.auth;

import com.nikolalogan.common.core.reponsitory.entity.BaseEntity;
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
    private String permissionName;
    @Column
    private String description;
}