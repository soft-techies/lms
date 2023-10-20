package com.lms.userlogin.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lms.userlogin.model.Profile;
import com.lms.userlogin.model.UserLogin;
import com.lms.userlogin.model.UserRegister;
import com.lms.userlogin.model.request.AssignRoleRequest;
import com.lms.userlogin.model.response.ErrorResponse;
import com.lms.userlogin.model.response.Response;
import com.lms.userlogin.model.response.SuccessResponse;
import com.lms.userlogin.repository.ProfileRepo;
import com.lms.userlogin.repository.UserLoginRepo;
import com.lms.userlogin.repository.UserRegisterRepo;
import com.lms.userlogin.service.UserServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserLoginRepo userLoginRepository;
	
	@Autowired
	private UserRegisterRepo userRegisterRepository;
	
	@Autowired
	private ProfileRepo profilerepo;
	
	@Autowired
	private UserServiceImpl userservice;
		
	@GetMapping("/loginuser")
	public List<UserLogin> getAllLoginUsers(){
		return userLoginRepository.findAll();
		
	}

	@PostMapping("/saveuser")
		public UserLogin createLoginUser(@RequestBody UserLogin userlogin) {
			return userLoginRepository.save(userlogin);
//		return userservice.saveLogin(userlogin);
		
	}
	
	@GetMapping("/register")
	public List<UserRegister> getAllRegisterUsers(){
		return userRegisterRepository.findAll();
		
	}

    @PostMapping("/saveregister")
    public Response registerUser(@RequestBody UserRegister user) {
    	Response response;
    	Optional<UserRegister> userEntry = userRegisterRepository.findByEmail(user.getEmail());
    	Optional<UserRegister> userName = userRegisterRepository.findByName(user.getUser_name());
    	if(userEntry.isPresent()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists!");
    	}
    	if(userName.isPresent()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "UserName already exists!");
    	}
     	try {
    	
    		UserRegister ur = userservice.save(user);
    		response = new SuccessResponse(ur,HttpStatus.CREATED.value());
    	}
    	catch(Exception e) {
    		String errorMessage;
    		errorMessage = e.getMessage();
    		response = new ErrorResponse(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR.value());
    	}
    	
        return response;
    
	}
    
    @PostMapping("/login")
	public String login_user(@RequestBody UserLogin request)
	{    	
    	return userservice.checkuser(request);
	
	}
    
    @GetMapping("/profile")
    public ResponseEntity<Profile> getProfile(@RequestParam(required = true) String email) {
        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        } else {
        	Profile user = profilerepo.findByEmail(email);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        }
    }
    
    @PostMapping("/assignRole")
    public Response assignRoletoUser(@RequestBody AssignRoleRequest request) {
    	Response response;
        Long userId = request.getUserId();
        String roleName = request.getRoleName();
        String email = request.getEmail();
    	try {
//    		System.out.print("hello from assign");
    		UserLogin user = userservice.assignRoleToUser(email, roleName);
    		response = new SuccessResponse(user,HttpStatus.CREATED.value());	
    	}
    	catch(Exception e) {
    		String errorMessage;
    		errorMessage = e.getMessage();
    		response = new ErrorResponse(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR.value());
    	}
    	return response;
    }
	
    

}
