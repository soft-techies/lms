package com.masters.Tables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masters.Tables.model.Examination;

@Repository
public interface ExaminationRepo extends JpaRepository<Examination,Long> {

}
