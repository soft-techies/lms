package com.lms.userlogin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class Profile {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;
	
//	@Column(name = "user_id")
//	private Long user_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "company_name")
	private String companyname;
	
	@Column(name = "college")
	private String college;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private Long phone;
	
	@Column(name = "role")
	private String role;
	
	
	@Column(name ="designation")
	private String designation;
	
	@Column(name ="website")
	private String website;
	
	@Column(name ="Facebook")
	private String facebook;
	
	@Column(name ="Twitter")
	private String twitter;
	
	@Column(name ="Instagram")
	private String instagram;
	
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;
	
	

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Long getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(Long user_id) {
//		this.user_id = user_id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//	public String getDesignation() {
//		return designation;
//	}
//
//	public void setDesignation(String designation) {
//		this.designation = designation;
//	}
//	
	
	
	
	
}
