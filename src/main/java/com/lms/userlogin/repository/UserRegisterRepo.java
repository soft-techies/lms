package com.lms.userlogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.userlogin.model.UserRegister;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister, Long> {

	Optional<UserRegister> findByEmail(String email);

	Optional<UserRegister> findByName(String email);
	
//	@Query("INSERT INTO tablename (col1, col2, col3) VALUES (:value1, :value2, :value3)")
//    Integer insertPlaneta(String value1, String value2, String value3);

}
