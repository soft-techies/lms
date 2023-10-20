package com.lms.userlogin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {
	

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;
	
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	@Column(name = "is_active")
	private Boolean isactive;
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}


}
