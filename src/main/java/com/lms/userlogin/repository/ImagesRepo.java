package com.lms.userlogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.userlogin.model.Images;

@Repository
public interface ImagesRepo extends JpaRepository<Images, Long>{

	Optional<Images> findByName(String name);

	Optional<Images> findByEmail(String email);
}
