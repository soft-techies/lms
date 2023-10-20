package com.masters.Tables.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userform_master")
public class UserForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String form_name;
	
	@Column(name = "display_name")
	private String form_displayname;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "component_name")
	private String component_name;
	
	@Column(name = "code")
	private String code;
	

	@Column(name = "status")
	private String status;

}
