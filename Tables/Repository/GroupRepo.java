package com.masters.Tables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masters.Tables.model.Group;

@Repository
public interface GroupRepo extends JpaRepository<Group,Long> {

}