package com.lms.userlogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userlogin.model.Organization;
import com.lms.userlogin.repository.OrgRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired
	OrgRepo orgrepository;
	
	@GetMapping("/getorg")
	public List<Organization> getAllOrg(){
		return orgrepository.findAll();
	}
	
	@PostMapping("/saveorg")
	public Organization saveorg(@RequestBody Organization data) {
		return orgrepository.save(data);
	}

}
