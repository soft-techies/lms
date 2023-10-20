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
@Table(name = "SampleForm")
@Getter
@Setter
public class SampleForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
	
	@Column(name= "field1")
	private String field1;
	
	@Column(name ="field2")
	private String field2;
	
	@Column(name= "field3")
	private String field3;
	
	@Column(name ="field4")
	private String field4;
	
	@Column(name= "field5")
	private String field5;
	
	@Column(name ="field6")
	private String field6;

}
