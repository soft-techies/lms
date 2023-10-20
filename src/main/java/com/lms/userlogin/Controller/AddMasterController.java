package com.lms.userlogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userlogin.model.AddMaster;
import com.lms.userlogin.repository.AddMasterRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/add")
public class AddMasterController {
	
	@Autowired
	AddMasterRepo addRepository;
	
	@PostMapping("/savecontent")
	public AddMaster save(@RequestBody AddMaster data) {
		return addRepository.save(data);
	}
	
	@GetMapping("/getMaster")
	public List<AddMaster> getAddMaster() {
		return addRepository.findAll();
	}
	


}
