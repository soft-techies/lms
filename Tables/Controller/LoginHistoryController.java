package com.masters.Tables.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masters.Tables.Repository.LoginHistoryRepo;
import com.masters.Tables.model.LoginHistory;

@CrossOrigin("*")
@RestController
@RequestMapping("/history")
public class LoginHistoryController {
	
	@Autowired
	LoginHistoryRepo historyrepo;
	
	@PostMapping("/save")
	public LoginHistory save(@RequestBody LoginHistory request) {
		return historyrepo.save(request);
	}
	
	@GetMapping("/getdata")
	public List<LoginHistory> getdata(){
		return historyrepo.findAll();
	}

}
