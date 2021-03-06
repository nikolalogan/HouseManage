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
public class AddRentUserDto extends BaseDto {


    @NotNull(message = "姓名不能为空")
    private String trueName;

    
    @NotNull(message = "身份证号不能为空")
    @Size(min = 18,max = 18, message = "身份证号位数不对")
    private String idNo;

    
    @NotNull(message = "电话号码不能为空")
    @Size(min = 11,max = 11, message = "电话号码位数不对")
    private String phoneNo;

    
    private String wechatNo;

    
    @NotNull(message = "性别不能为空")
    private Integer gender;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "出生日期不能为空")
    private Date birthday;

    
    private String address;
}
