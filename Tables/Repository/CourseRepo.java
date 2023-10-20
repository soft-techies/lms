package com.masters.Tables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masters.Tables.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {

	Course findByName(String string);

}
