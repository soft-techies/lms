package com.lms.userlogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userlogin.model.Subject;
import com.lms.userlogin.repository.SubjectRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	SubjectRepo subjectRepository;
	
	@GetMapping("/getAllSubjects")
	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}
	
	@PostMapping("/saveSubjects")
	public Subject saveSubject(@RequestBody Subject data) {
		return subjectRepository.save(data);
			
		}
	

}
