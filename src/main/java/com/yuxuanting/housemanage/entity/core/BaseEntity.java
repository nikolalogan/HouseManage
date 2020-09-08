package com.yuxuanting.housemanage.entity.core;

/**
 * @author: yuxuanting
 * @description: 基础类
 * @date: 2020-09-01 21:50
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: yuxuanting
 * @description: 根实体
 * @date: 2020-08-31 16:20
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(
            length = 32
    )
    @GeneratedValue(
            generator = "system-uuid"
    )
    @GenericGenerator(
            name = "system-uuid",
            strategy = "uuid"
    )
    private String id;

    @Version
    private Long version;

    @Column(
            name = "is_delete"
    )
    private Boolean isDelete;
    @Column(
            name = "create_time"
    )
    private Date createTime;
    @Column(
            name = "update_time"
    )
    private Date updateTime;

    public BaseEntity() {
        this.isDelete = Boolean.FALSE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
