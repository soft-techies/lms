package com.lms.userlogin.service;


import com.lms.userlogin.model.UserLogin;
import com.lms.userlogin.model.UserRegister;

public interface UserService {
	
	UserRegister save(UserRegister user);

//	UserLogin loadUserByUsername(String email);
	
	String checkuser(UserLogin request);

}
