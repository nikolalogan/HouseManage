package com.yuxuanting.housemanage.dto.house;

import com.nikolalogan.common.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2021-03-10 13:10
 */
@Getter
@Setter
public class AddHouseDto extends BaseDto {
    /**
     * 待租
     */
    public static final int WAIT = 0;
    /**
     * 已租
     */
    public static final int RENT = 1;
    /**
     * 已预订
     */
    public static final int DESTINE = 2;

    @NotNull(message = "房间标题不能为空")
    private String houseTitle;

    @NotNull(message = "房间地址不能为空")
    private String address;

    @NotNull(message = "房间默认价格不能为空")
    private BigDecimal price;

    //0待租 1租出 2预定
    @NotNull(message = "房间状态不能为空")
    private int status;

    @NotNull(message = "电表起始度数不能为空")
    private int powerMeter;
}
