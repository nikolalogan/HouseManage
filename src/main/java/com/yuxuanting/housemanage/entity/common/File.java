package com.yuxuanting.housemanage.entity.common;

import com.nikolalogan.common.core.reponsitory.entity.FileEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2021-03-12 15:51
 */
@Entity
@Table(
        name = "file"
)
public class File extends FileEntity {
}
