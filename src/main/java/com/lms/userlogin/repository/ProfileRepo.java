package com.lms.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.userlogin.model.Profile;
import com.lms.userlogin.model.UserLogin;

@Repository
public interface ProfileRepo extends JpaRepository<Profile,Long> {

	Profile findByEmail(String email);

	

}
