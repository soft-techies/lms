package com.lms.userlogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userlogin.model.Content;
import com.lms.userlogin.model.UserContent;
import com.lms.userlogin.repository.UserContentRepo;
import com.lms.userlogin.service.UserContentService;
import com.lms.userlogin.service.UserContentServiceImpl;




@CrossOrigin("*")
@RestController
@RequestMapping("/usercontent")
public class UserContentController {
	
	@Autowired
	private UserContentRepo userContentRepository;
	
    @Autowired
    private UserContentServiceImpl ucs;
    
	
	@PostMapping("/saveUsercontent")
	public UserContent saveUserContent(@RequestBody UserContent data) {
		return userContentRepository.save(data);
	}
	
	@GetMapping("/getAllContentByUser")
	public List<UserContent> getAllUserContent(){
		return userContentRepository.findAll();
	}

	@GetMapping("/getById/{user_id}")
	public ResponseEntity<Object> getById(@PathVariable Long user_id) {
		ResponseEntity<Object> response;
		List<Content> data = ucs.getContentDetailsByUserId(user_id);
	    response = new ResponseEntity<>(data, HttpStatus.OK);
	    return response;
	}

}
