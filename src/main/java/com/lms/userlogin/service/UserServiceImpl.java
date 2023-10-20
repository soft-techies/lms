package com.lms.userlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lms.userlogin.model.Roles;
import com.lms.userlogin.model.UserLogin;
import com.lms.userlogin.model.UserRegister;
import com.lms.userlogin.repository.RolesRepo;
import com.lms.userlogin.repository.UserLoginRepo;
import com.lms.userlogin.repository.UserRegisterRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRegisterRepo userregisterrepo;
	
	@Autowired
	private UserLoginRepo userLoginRepository;
	
	@Autowired
	RolesRepo rolesRepository;
	
	
	@Override
	public UserRegister save(UserRegister user) {
		UserRegister ur = userregisterrepo.save(user);
		UserLogin ul = new UserLogin();
		
		ul.setEmail(user.getEmail());
		ul.setPassword(user.getPassword());
		
		saveLogin(ul);
	     
		return ur;
		
	}
	
	public UserLogin saveLogin(UserLogin user)	
	{		
		UserLogin ulr = userLoginRepository.save(user);		
		return ulr;
	}

	@Override
	public String checkuser(UserLogin request) {
		
		String email = request.getEmail();
        String password = request.getPassword();
        System.out.println(email);
        UserLogin auser=userLoginRepository.findByEmailAndPassword(email, password);  //, role
    	
    	if(auser!=null)
    	{
    		String url = null;
    		String uname=auser.getEmail();
    		String upass=auser.getPassword();
    		 url = auser.getUrl();
    		System.out.println(url);
    		System.out.println(uname);
    		System.out.println(upass);
    		
    		if(email.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass))   // && role.equalsIgnoreCase(urole)
    		{
//    			if(auser.getRole().equalsIgnoreCase("Admin")) {
//    				return "/admin";
//    			}
    			System.out.println(url);
    			return url;
    		}
    		else 
    		{
    			return "Invalid";
    		}    		
    	}
    	else
    	{
    		return "Invalid";
    	}
		
	}
	
//    public UserLogin assignRoleToUser(Long userId, String roleName) {
//        UserLogin user = userLoginRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
//        String existingRoles = user.getRole();
//        if (existingRoles == null) {
//            existingRoles = roleName;
//        } else {
//            existingRoles += "," + roleName;
//        }
//        user.setRole(existingRoles);
//        return userLoginRepository.save(user);
//    }
	
    public UserLogin assignRoleToUser(String email, String roleName) {
        UserLogin user = userLoginRepository.findByEmail(email);
        System.out.print(roleName+"*******************************");
        if(user != null ) {
        	
        	String existingRoles = user.getRole();
            if (existingRoles == null ) {
                existingRoles = roleName;
            } else {
                existingRoles += "," + roleName;
            }
            user.setRole(existingRoles);
            return userLoginRepository.save(user);
        }
        else {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found!");
        }
        
        
    }
	


}
