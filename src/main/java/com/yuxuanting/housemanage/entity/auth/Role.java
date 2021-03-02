package com.yuxuanting.housemanage.entity.auth;


import com.nikolalogan.core.reponsitory.entity.BaseEntity;
import com.yuxuanting.housemanage.entity.Admin;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "role")
public class Role extends BaseEntity {
	private Integer rid;
	private String roleName;
	private String desc;

//	@OneToMany(fetch = FetchType.LAZY)
//	private List<Permission> permissions;

}