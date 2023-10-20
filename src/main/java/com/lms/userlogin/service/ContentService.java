package com.lms.userlogin.service;

import java.util.Optional;

import com.lms.userlogin.model.Content;

public interface ContentService {
	
	 Optional<Content> getContentDetails(Long userId);

}
