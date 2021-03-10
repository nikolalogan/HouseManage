package com.yuxuanting.housemanage.dto.house;

import com.nikolalogan.common.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2021-03-10 13:10
 */
@Getter
@Setter
public class SelectHouseDto extends BaseDto {

    private String houseTitle;

    private String address;

    //价格下限
    private BigDecimal priceLow;
    //价格上限
    private BigDecimal priceHigh;

    //0待租 1租出 2预定
    private String status;

    private int powerMeter;
}
