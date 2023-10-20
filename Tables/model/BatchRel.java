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
@Table(name = "batchrel")
@Getter
@Setter
public class BatchRel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
	
	private Long batch_id;
	
	private Long uni_id;
	
	private Long course_id;
	
	private String tablename;

}
