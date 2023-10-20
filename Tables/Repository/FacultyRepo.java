package com.masters.Tables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.masters.Tables.model.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Long> {

}