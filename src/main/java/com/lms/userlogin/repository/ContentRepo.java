package com.lms.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.userlogin.model.Content;

@Repository
public interface ContentRepo extends JpaRepository<Content, Long>  {

	Content findById(Content content_id);



}
