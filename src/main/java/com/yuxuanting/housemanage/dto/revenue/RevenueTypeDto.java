package com.yuxuanting.housemanage.dto.revenue;

import com.nikolalogan.common.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2021-03-12 16:44
 */
@Setter
@Getter
public class RevenueTypeDto extends BaseDto {
    @NotNull(message = "日常流水类型不能为空")
    private int revenueType;

    @NotNull(message = "日常流水类型名称不能为空")
    private String revenueName;
}
