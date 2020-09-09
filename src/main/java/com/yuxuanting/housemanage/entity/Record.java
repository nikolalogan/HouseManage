package com.yuxuanting.housemanage.entity;

import com.yuxuanting.housemanage.entity.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 11:37
 */
@Getter
@Setter
@Entity
@Table(name = "record")
public class Record extends BaseEntity {
    @Column
    @NotNull(message = "记录类型不能为空")
    private int editType;

    @Column
    @NotNull(message = "详情不能为空")
    private String editContent;

    @Column
    @NotNull(message = "编辑日期不能为空")
    private Date editTime = new Date();

    /**
     * 用户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;


}
