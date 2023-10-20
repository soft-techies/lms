package com.masters.Tables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masters.Tables.model.University;

@Repository
public interface UniversityRepo extends JpaRepository<University,Long>{

	University findByName(String string);

}
