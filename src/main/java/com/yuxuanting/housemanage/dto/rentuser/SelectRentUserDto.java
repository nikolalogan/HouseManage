package com.yuxuanting.housemanage.dto.rentuser;

import com.nikolalogan.common.core.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description: 租户
 * @date: 2020-09-01 22:00
 */
@Setter
@Getter
public class SelectRentUserDto extends BaseDto {

    private String trueName;

    @Size(min = 18,max = 18, message = "身份证号位数不对")
    private String idNo;

    @Size(min = 11,max = 11, message = "电话号码位数不对")
    private String phoneNo;

    private String wechatNo;

    private Integer gender;

    /**
     * 年龄段开始
     */
    private Integer ageStart;
    /**
     * 年龄段结束
     */
    private Integer ageEnd;
    private String address;
}
