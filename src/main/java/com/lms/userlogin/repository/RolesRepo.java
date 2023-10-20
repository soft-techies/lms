package com.lms.userlogin.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.userlogin.model.Roles;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Long>{

      List<Roles> findRoleByRoleName(String roleName);

	Roles findByRoleName(String roleName);

}
