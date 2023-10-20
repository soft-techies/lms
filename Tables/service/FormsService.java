package com.masters.Tables.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masters.Tables.model.BatchSubjectRel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class FormsService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public int insertIntoBatchSubjectRel(String tablename, Long batchid, Long subjectid) {
		int data = 0;
		 String query = "INSERT INTO "+tablename+" (batch_id, subject_id)\r\n"
				+ "VALUES ("+batchid+","+ subjectid+");\r\n";
		try {
			System.out.println(query);
			 data = entityManager.createNativeQuery(query).executeUpdate();
		    return data;
			  
	} catch (Exception e) {
		System.err.println("Error inserting data: " + e.getMessage());
		
	}
		 return data;
}
	@Transactional
	public int insertIntoRel(String tablename,Long firstid,Long secid,Long thirdid) {
		int data = 0;
		String query = "INSERT INTO "+tablename+" (batch_id, uni_id,course_id)\r\n"
				+ "VALUES ("+firstid+","+ secid+","+thirdid+");\r\n";
		try {
			System.out.println(query);
			data = entityManager.createNativeQuery(query).executeUpdate();
		    return data;
		}catch (Exception e) {
			System.err.println("Error inserting data: " + e.getMessage());
			
		}
		 return data;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getBatchFromUniversity(String university) {
		List<Object[]> data = null ;
		String query = "Select * from batch_master where university = " + university;
		try {
			data = entityManager.createNativeQuery(query).getResultList();
			}catch (Exception e) {
				System.err.println("Error inserting data: " + e.getMessage());
				
			}
		return data;
		
	}
    	

}
