package com.lms.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.userlogin.model.Organization;

@Repository
public interface OrgRepo extends JpaRepository<Organization,Long> {

}
