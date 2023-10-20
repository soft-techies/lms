package com.lms.userlogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userlogin.model.GetTablesReport;
import com.lms.userlogin.service.Reports;

@CrossOrigin("*")
@RestController
@RequestMapping("/reports")
public class ReportsController {
	
	@Autowired
	Reports reportservice;
	
	@GetMapping("/fullreport")
	public List<Object[]> getReport(@RequestParam String tablename ){
		return reportservice.getReport(tablename);
		
	}
	
	@GetMapping("/getReportWithWhere")
	public List<GetTablesReport> getReport(@RequestParam String tablename,@RequestParam String whereField,
			@RequestParam String whereValue ){
		return reportservice.getReport(tablename,whereField,whereValue);
		
	}
	
	@GetMapping("/getReportWithAndOrCond")
	public List<Object[]> getReport(@RequestParam String tablename,@RequestParam String[] whereField,
			@RequestParam String[] whereValue,@RequestParam int condition){
		return reportservice.getReport(tablename,whereField,whereValue,condition);
		
	}
	
	@GetMapping("/getReportAnyColumns")
	public List<Object[]> getReport(@RequestParam String tablename,@RequestParam String [] fieldsList,@RequestParam String[] whereField,
			@RequestParam String[] whereValue,@RequestParam int condition){
		return reportservice.getReport(tablename,fieldsList,whereField,whereValue,condition);
		
	}
	
	@GetMapping("/subjectReport")
	public List<Object[]> getSubjectReport(){
		return reportservice.getSubjectReport();
		
	}
	
	@GetMapping("/loginReport")
	public List<Object[]> getLoginReport(){
		return reportservice.getLoginReport();
		
	}
	
	@GetMapping("/registerReport")
	public List<Object[]> getRegisterReport(){
		return reportservice.getRegisterReport();
		
	}
	
	@GetMapping("/organisationReport")
	public List<Object[]> getOrganisationReport(){
		return reportservice.getOrganisationReport();
		
	}
	
	@GetMapping("/syllabusReport")
	public List<Object[]> getSyllabusReport(){
		return reportservice.getSyllabusReport();
		
	}
	
	@GetMapping("/facultyReport")
	public List<Object[]> getFacultyReport(){
		return reportservice.getFacultyReport();
		
	}
	
	@GetMapping("/universityReport")
	public List<Object[]> getUniversityReport(){
		return reportservice.getUniversityReport();
		
	}
	
	@GetMapping("/examinationReport")
	public List<Object[]> getExaminationReport(){
		return reportservice.getExaminationReport();
	}
	

}
