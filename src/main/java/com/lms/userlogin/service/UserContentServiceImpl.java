package com.lms.userlogin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.userlogin.model.Content;
import com.lms.userlogin.model.UserContent;
import com.lms.userlogin.repository.ContentRepo;
import com.lms.userlogin.repository.UserContentRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;

@Service
public class UserContentServiceImpl implements UserContentService{
	
	@Autowired 
	ContentRepo contentRepository;
	
	@Autowired
	UserContentRepo userContentRepository;
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Content> getContentDetailsByUserId(Long user_id) {
	    List<Content> contentList = new ArrayList<>();

	    List<Object[]> allcontent = entityManager.createNativeQuery("SELECT\r\n"
	            + "    cm.id AS content_id,\r\n"
	            + "    cm.display_name,\r\n"
	            + "    cm.url,\r\n"
	            + "    cm.content_name,\r\n"
	            + "    cm.uploaded_by,\r\n"
	            + "    cm.is_active\r\n"
	            + " FROM\r\n"
	            + "    content_master AS cm\r\n"
	            + "  JOIN\r\n"
	            + "    user_content AS uc ON cm.id = uc.content_id\r\n"
	            + " WHERE\r\n"
	            + "    uc.userid = :user_id")
	            .setParameter("user_id", user_id)
	            .getResultList();
	          

	    for (Object[] result : allcontent) {
	        Long contentId = Long.valueOf(result[0].toString());
	        String displayName = result[1].toString();
	        String url = result[2].toString();
	        String name = result[3].toString();
	        String uploaded_by = result[4].toString();
	        String is_active = result[5].toString();
	        
	        Content content = new Content();
	        content.setId(contentId);
	        content.setDisplayname(displayName);
	        content.setUrl(url);
	        content.setName(name);
	        content.setUploadedBy(uploaded_by);
	        content.setIsactive(is_active);

	        contentList.add(content);
	    }

	    return contentList;
	}
	


}
