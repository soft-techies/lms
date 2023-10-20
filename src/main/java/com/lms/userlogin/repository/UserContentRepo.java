package com.lms.userlogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.userlogin.model.Content;
import com.lms.userlogin.model.UserContent;

@Repository
public interface UserContentRepo extends JpaRepository<UserContent,Long> {

	UserContent findByUserId(Long user_id);

}
