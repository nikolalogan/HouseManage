package com.yuxuanting.housemanage.entity;

import com.yuxuanting.housemanage.entity.core.BaseEntity;
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
    @NotNull(message = "房间标题不能为空")
    private String houseTitle;

    @Column
    @NotNull(message = "房间地址不能为空")
    private String address;

    @Column
    @NotNull(message = "房间默认价格不能为空")
    private BigDecimal price;

    //0待租 1租出 2预定
    @Column
    @NotNull(message = "房间状态不能为空")
    private int status;

    @Column
    @NotNull(message = "电表起始度数不能为空")
    private int powerMeter;
}
