package com.lms.userlogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userlogin.model.GetTablesReport;
import com.lms.userlogin.service.GetAllTablesImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/tables")
public class TablesController {
	
	@Autowired
	GetAllTablesImpl tablesService;
	
	@GetMapping("/getAllTables")
	public List<Object[]> getAllTables(@RequestParam String tablename) {
		return tablesService.getAllTables(tablename);
	}

	@GetMapping("/getAllDataWithCond")
	public List<GetTablesReport> getAllDataWithCond(@RequestParam String tableName,
			@RequestParam(required = false) String whereField, @RequestParam(required = false) String whereValue) {
		List<GetTablesReport> selectQuery = tablesService.createSelectQuery(tableName, whereField, whereValue);
		return selectQuery;
	}

	@GetMapping("/getAllDataWithMulCond")
	public List<Object[]> getAllDataWithMulCond(@RequestParam String tableName,
			@RequestParam(required = false) String[] whereField, @RequestParam(required = false) String[] whereValue,
			@RequestParam(required = false) int cond) {
		List<Object[]> selectQuery = tablesService.createSelectQuery(tableName, whereField, whereValue, cond);
		return selectQuery;
	}
	
	@GetMapping("/getSingleColumnData")
	public List<String> getSingleColumnData(@RequestParam String tableName,
			@RequestParam(required = false) String whereField){
		List<String> selectQuery = tablesService.getSingleColumnData(tableName, whereField);
		return selectQuery;
	}
	
	@GetMapping("/getMultipleColumnsData")
	public List<Object[]> getMultipleColumnsData(@RequestParam String tableName,
			@RequestParam(required = false) String[] whereField){
		List<Object[]> selectQuery = tablesService.getColumnsData(tableName, whereField);
		return selectQuery;
	}

	@GetMapping("/getColumnsDataWithCond")
	public List<Object[]> getColumnsDataWithCond(@RequestParam String tableName,@RequestParam String [] fieldsList,
			@RequestParam(required = false) String[] whereField, @RequestParam(required = false) String[] whereValue,
			@RequestParam(required = false) int cond) {
		List<Object[]> selectQuery = tablesService.createSelectQuery(tableName,fieldsList, whereField, whereValue, cond);
		return selectQuery;
	}
	
	
	
	
	@PostMapping("/insertdata")
	public List<Object[]> insertData(@RequestParam String tableName,
			@RequestParam(required = false) String[] cols, @RequestParam(required = false) String[] values) {
		List<Object[]> selectQuery = tablesService.insertquery(tableName,cols, values);
		return selectQuery;
	} 
	    

}
