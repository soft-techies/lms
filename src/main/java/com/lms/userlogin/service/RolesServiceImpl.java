package com.lms.userlogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.userlogin.model.Roles;
import com.lms.userlogin.repository.RolesRepo;

@Service
public class RolesServiceImpl implements RoleService {
	
	@Autowired
	RolesRepo rolesRepository;
	
	@Override
	public Iterable<Roles> getRoles() {
		Iterable<Roles> roles = rolesRepository.findAll();
		return roles;
	}
	
	@Override
	public Roles register(Roles role) {
		return rolesRepository.save(role);
		
	}

	@Override
	public Roles update(Roles role) {
		List<Roles> roleList = rolesRepository.findRoleByRoleName(role.getRoleName());
		Roles updateRole = new Roles();
		if(roleList.size()>0) {
			updateRole = roleList.get(0);
			updateRole.setIsactive(role.getIsactive());
			rolesRepository.save(updateRole);
		}
		
		return updateRole;
	}
		
}
