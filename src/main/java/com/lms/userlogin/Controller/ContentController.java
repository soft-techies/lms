package com.lms.userlogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userlogin.model.Content;
import com.lms.userlogin.repository.ContentRepo;
import com.lms.userlogin.service.GetAllTablesImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	ContentRepo contentRepository;
	
//	@Autowired
//	GetAllTablesImpl tables;
	
	
	@PostMapping("/savecontent")
	public Content save(@RequestBody Content data) {
		return contentRepository.save(data);
	}
	
	@GetMapping("/getAllContent")
	public List<Content> getAllContent() {
		return contentRepository.findAll();
	}
	
//	@GetMapping("/getAllTables/{tablename}")
//	public List<Object[]> getAllTables(@PathVariable String tablename){
//		return tables.getAllTables(tablename);
//	}

}
