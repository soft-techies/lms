package com.masters.Tables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masters.Tables.model.Topic;

@Repository
public interface TopicRepo extends JpaRepository<Topic,Long> {

}