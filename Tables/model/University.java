package com.masters.Tables.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "University_master")
@Getter
@Setter
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
	
	@Column(name= "name")
	private String name;
	
	@Column(name ="code")
	private Long code;

	@Column(name ="description")
	private String description;
	
	
	@Column(name ="status")
	private Boolean status;
	
	
}
