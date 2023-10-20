package com.lms.userlogin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.userlogin.model.Content;
import com.lms.userlogin.repository.ContentRepo;

@Service
public class ContentServiceImpl implements ContentService{

	@Autowired 
	ContentRepo contentRepository;

	@Override
	public Optional<Content> getContentDetails(Long userId) {
		Optional<Content> data = contentRepository.findById(userId);
		return data;

}
}