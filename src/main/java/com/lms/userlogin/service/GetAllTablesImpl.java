package com.lms.userlogin.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.userlogin.model.GetTablesReport;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class GetAllTablesImpl implements GetAllTables {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllTables(String tablename) {

		List<Object[]> tablesdata = entityManager.createNativeQuery("Select * from " + tablename).getResultList();
		return tablesdata;

	}

	@SuppressWarnings("unchecked")
	public List<GetTablesReport> createSelectQuery(String tableName, String whereField, String whereValue) {
		List<GetTablesReport> sqlSelect = entityManager
				.createNativeQuery("Select * from " + tableName + " where " + whereField + " = '" + whereValue + "'")
				.getResultList();
		System.out.println(sqlSelect);
		return sqlSelect;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> createSelectQuery(String tableName, String[] whereFields, String[] whereValues,
			int condition) {
		String whereClause = getWhereClause(whereFields, whereValues, condition);
		String query = "Select * from " + tableName + " " + whereClause;
		System.out.println(query);
		List<Object[]> data = entityManager.createNativeQuery("Select * from " + tableName + " " + whereClause)
				.getResultList();
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> createSelectQuery(String tableName, String [] fieldsList, String [] whereFields,String [] whereValues,int condition)
	{
		String cols=getCols(fieldsList);
		String whereClause=getWhereClause(whereFields,whereValues,condition);
		String sqlSelect = "Select "+cols+" from "+tableName+whereClause;
		System.out.println(sqlSelect);
		List<Object[]> data = entityManager.createNativeQuery(sqlSelect)
				.getResultList();
		return data;
		
	}
	@SuppressWarnings("unchecked")
	public List<String> getSingleColumnData(String tableName,String field){
		
//		String cols=getCols(fieldList);
		String sqlSelect = "Select "+field+" from "+tableName;
		System.out.println(sqlSelect);
		List<String> data = entityManager.createNativeQuery(sqlSelect)
				.getResultList();
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getColumnsData(String tableName,String [] fieldList){
		
		String cols=getCols(fieldList);
		String sqlSelect = "Select "+cols+" from "+tableName;
		System.out.println(sqlSelect);
		List<Object[]> data = entityManager.createNativeQuery(sqlSelect)
				.getResultList();
		return data;
	}
	
	public String getCols(String [] fieldsList)
	{
		String cols="*";
		
		if(fieldsList.length >=1)
		{
			cols = fieldsList[0];		
			for(int i=1;i<fieldsList.length;i++){cols += ","+fieldsList[i];}
		}
		
		return cols;		
	}
	
	

	public String getWhereClause(String[] whereFields, String[] whereValues, int condition) {
		String whereClause = "";
		String cond = "AND";

		if (condition == 0) {
			cond = "OR";
		}
		if (condition == 1) {
			cond = "AND";
		}
		if (condition == 2) {
			cond = "OR";
		}
		if (condition == 3) {
			cond = "AND";
		}

		if (condition <= 1) {
			if (whereFields.length >= 1) {
				whereClause += " where " + whereFields[0] + " = '" + whereValues[0] + "'";
			}

			for (int i = 1; i < whereFields.length; i++) {
				whereClause += " " + cond + " " + whereFields[i] + " = '" + whereValues[i] + "'";
			}
		}

		if (condition >= 2) {
			if (whereFields.length >= 1) {
				whereClause += " where " + whereFields[0] + " Like '" + whereValues[0] + "%'";
			}

			for (int i = 1; i < whereFields.length; i++) {
				whereClause += " " + cond + " " + whereFields[i] + " Like '" + whereValues[i] + "%'";
			}
		}

		return whereClause;
	}
	public String[][] getFieldValues(String tableName, String [] fieldsList, String [] whereFields,String [] whereValues,int condition)
	{	
		String cols=getCols(fieldsList);
		String recordsField[][] = null;
		String whereClause=getWhereClause(whereFields,whereValues,condition);
		String sqlSelectField = "Select "+cols+" from "+tableName+whereClause;
		System.out.println("*************"+sqlSelectField);
		try
		{
			ResultSet rsField=(ResultSet) entityManager.createNativeQuery(sqlSelectField);
			recordsField = new String[1][fieldsList.length];
			
			if(rsField.next())
			{					
	    	 	for(int cntColumn=1;cntColumn<=fieldsList.length;cntColumn++)
    	 		{			
					recordsField[0][cntColumn-1] = rsField.getString(cntColumn);
					System.out.println(recordsField[0][cntColumn-1]);
				}
			}
			rsField.close();	
		}catch(SQLException se){
			se.printStackTrace(System.err);
		}		
		return recordsField;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> insertquery(String tableName ,String [] fieldsList, String [] whereValues) {
		String cols=getCols(fieldsList);
		String query = "Insert into "+tableName+" ( "+cols+" ) values(1,2)";//+ values;
		System.out.println(query);
		List<Object[]> data = entityManager.createNativeQuery(query)
				.getResultList();
		return data;
		
	}


}
