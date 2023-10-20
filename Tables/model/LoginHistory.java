package com.masters.Tables.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "loginhistory")
@Getter
@Setter
public class LoginHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
    @Column(name = "lastlogintime")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
	
    @Column(name="role")
	private String role;
	
    @Column(name="status")
	private boolean status;

}
