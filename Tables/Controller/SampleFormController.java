package com.masters.Tables.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masters.Tables.Repository.SampleFormRepo;
import com.masters.Tables.model.SampleForm;

@CrossOrigin("*")
@RestController
@RequestMapping("/sample")
public class SampleFormController {
	
	@Autowired
	SampleFormRepo formrepo;
	
	@GetMapping("/getSampleData")
	public List<SampleForm> getAllData(){
		return formrepo.findAll();	
	}
	
	@PostMapping("/saveSampleData")
	public SampleForm save(@RequestBody SampleForm data) {
		 return formrepo.save(data);
		
	}

}
