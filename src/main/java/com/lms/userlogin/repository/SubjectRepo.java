package com.lms.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.userlogin.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {

}
