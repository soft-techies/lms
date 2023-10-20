package com.masters.Tables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masters.Tables.model.Syllabus;

@Repository
public interface SyllabusRepo extends JpaRepository<Syllabus,Long> {

}