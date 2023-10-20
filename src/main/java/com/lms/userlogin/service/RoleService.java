package com.lms.userlogin.service;

import com.lms.userlogin.model.Roles;


public interface RoleService {
	
	Iterable<Roles> getRoles();
	
	Roles register(Roles role);
	
	Roles update(Roles role);

}
