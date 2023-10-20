package com.lms.userlogin.service;

import java.util.List;
import java.util.Optional;

import com.lms.userlogin.model.Content;


public interface UserContentService {
	
	List<Content> getContentDetailsByUserId(Long user_id);

}
