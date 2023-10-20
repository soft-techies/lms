package com.lms.userlogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.userlogin.model.GetTablesReport;

@Service
public class Reports {
	
	@Autowired
	GetAllTablesImpl getalltableservice;
	
	public List<Object[]> getReport(String tableName){
		return getalltableservice.getAllTables(tableName);
	}
	
	
	public List<GetTablesReport> getReport(String tableName, String whereField, String whereValue){
		return getalltableservice.createSelectQuery(tableName,whereField,whereValue);
	}
	
	public List<Object[]> getReport(String tableName, String[] whereFields, String[] whereValues,
			int condition){
		return getalltableservice.createSelectQuery(tableName,whereFields,whereValues,condition);
	}
	
	public List<Object[]> getReport(String tableName, String [] fieldsList, String[] whereFields, String[] whereValues,
			int condition){
		return getalltableservice.createSelectQuery(tableName,fieldsList,whereFields,whereValues,condition);
	}
	
	
	public List<Object[]> getSubjectReport(){
		String tableName = "subject_master";
		return getalltableservice.getAllTables(tableName);	
	}
	
	public List<Object[]> getLoginReport(){
		String tableName = "user_login";
		return getalltableservice.getAllTables(tableName);	
	}
	
	public List<Object[]> getRegisterReport(){
		String tableName = "user_register";
		return getalltableservice.getAllTables(tableName);	
	}
	
	public List<Object[]> getOrganisationReport(){
		String tableName = "organisation_master";
		return getalltableservice.getAllTables(tableName);	
	}
	
	public List<Object[]> getSyllabusReport(){
		String tableName = "syllabus_master";
		return getalltableservice.getAllTables(tableName);	
	}
	
	public List<Object[]> getFacultyReport(){
		String tableName = "faculty_master";
		return getalltableservice.getAllTables(tableName);	
	}
	
	public List<Object[]> getUniversityReport(){
		String tableName = "university_master";
		return getalltableservice.getAllTables(tableName);	
	}
	
	public List<Object[]> getExaminationReport(){
		String tablename = "examination_master";
		return getalltableservice.getAllTables(tablename);
	}
	
	
	
	
	
}
