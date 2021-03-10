package com.yuxuanting.housemanage.entity;

import com.nikolalogan.common.core.reponsitory.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 09:22
 */
@Setter
@Getter
@Entity
@Table(name = "house")
public class House extends BaseEntity {
    @Column
    private String houseTitle;

    @Column
    private String address;

    @Column
    private BigDecimal price;

    //0待租 1租出 2预定
    @Column
    private int status;

    @Column
    private int powerMeter;
}
