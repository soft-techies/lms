package com.lms.userlogin.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userlogin.model.Roles;
import com.lms.userlogin.model.response.ErrorResponse;
import com.lms.userlogin.model.response.Response;
import com.lms.userlogin.model.response.SuccessResponse;
import com.lms.userlogin.service.RoleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleservice;
	
	
	@PostMapping("/createRole")
	public Response register(@RequestBody Roles roles) {		
		Response response;
		try {
			Roles role = roleservice.register(roles);
			response = new SuccessResponse(role,HttpStatus.CREATED.value());
		}
		catch(Exception e){
			String errorMessage;
    		errorMessage = e.getMessage();
    		response = new ErrorResponse(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return response;		
	}
	
	@PostMapping("/updateRoleState")
	public Response update(@RequestBody Roles roles) {
		Response response;
		try {
			Roles role = roleservice.update(roles);
			response = new SuccessResponse(role, HttpStatus.CREATED.value());
		}
		catch(Exception e){
			String errorMessage;
    		errorMessage = e.getMessage();
    		response = new ErrorResponse(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return response;		
	}

	
	@GetMapping("/roles")
	public Response getRoles() {		
		Iterable<Roles> roles = roleservice.getRoles();
		return new SuccessResponse(roles, HttpStatus.OK.value());
	}

}
