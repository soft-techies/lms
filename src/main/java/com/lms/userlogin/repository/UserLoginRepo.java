package com.lms.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.userlogin.model.UserLogin;



@SuppressWarnings({ "unused" })
@Repository
public interface UserLoginRepo extends JpaRepository <UserLogin,Long> {

	UserLogin findByEmail(String email);

	UserLogin findByEmailAndPassword(String email, String password); //AndRole  String Role



	

}
