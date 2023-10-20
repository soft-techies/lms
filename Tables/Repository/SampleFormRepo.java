package com.masters.Tables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masters.Tables.model.SampleForm;

@Repository
public interface SampleFormRepo extends JpaRepository<SampleForm,Long> {

}
