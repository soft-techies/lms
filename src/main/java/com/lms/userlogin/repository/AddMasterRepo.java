package com.lms.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.userlogin.model.AddMaster;

@Repository
public interface AddMasterRepo extends JpaRepository<AddMaster,Long> {
	

}
