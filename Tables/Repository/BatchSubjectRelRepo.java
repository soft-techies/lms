package com.masters.Tables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masters.Tables.model.BatchSubjectRel;

@Repository
public interface BatchSubjectRelRepo extends JpaRepository<BatchSubjectRel,Long> {

	
}
