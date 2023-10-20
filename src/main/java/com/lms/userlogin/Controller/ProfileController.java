package com.lms.userlogin.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userlogin.model.Profile;
import com.lms.userlogin.repository.ProfileRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	ProfileRepo profileRepository;
	
	@PostMapping("/saveProfile")
	public Profile save(@RequestBody Profile data) {
		return profileRepository.save(data);
		
	}
	
	@GetMapping("/getAllProfile")
	public List<Profile> getAllUserProfile(){
		return profileRepository.findAll();
	}
	
	@GetMapping("/getUserProfile/{user_id}")
	public Optional<Profile> getUserProfile(@PathVariable Long user_id) {
		return profileRepository.findById(user_id);
	}
	

}
