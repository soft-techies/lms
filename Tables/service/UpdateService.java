package com.masters.Tables.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class UpdateService {
	
	@PersistenceContext
	EntityManager entityManager;

//	@Transactional
//	public int UpdateQuery(String tableName, String setField, String setValue, String whereField, String whereValue) {
//		String updateQuery = "UPDATE " + tableName + " SET " + setField + " = '" + setValue + "' WHERE " + whereField
//				+ " = '" + whereValue + "'";
//
//		try {
//			int updatedRows = entityManager.createNativeQuery(updateQuery).executeUpdate();
//			System.out.println("Rows updated: " + updatedRows);
//			return updatedRows;
//		} catch (Exception e) {
//			System.err.println("Error updating data: " + e.getMessage());
//			return -1; // or throw an exception if you prefer
//		}
//
//	}
//	
	
	@Transactional
	public int UpdateMultiple(String tableName, String[] setField, String[] setValue, String whereField, String whereValue) {
		String whereClause=getWhereClause(setField,setValue);
		System.out.println(whereClause);
		String updateQuery = "UPDATE " + tableName + " SET " + whereClause + " WHERE " + whereField    ///setField + " = '" + setValue
				+ " = '" + whereValue + "'";
		System.out.println(updateQuery);
		
		try {
			int updatedRows = entityManager.createNativeQuery(updateQuery).executeUpdate();
			System.out.println("Rows updated: " + updatedRows);
			return updatedRows;
		} catch (Exception e) {
			System.err.println("Error updating data: " + e.getMessage());
			return -1; 
		}

	}
	

	
	public String getWhereClause(String[] setFields, String[] setValues) {  //, int condition
		String whereClause = "";
			if (setFields.length >= 1) {
				whereClause +=  setFields[0] + " = '" + setValues[0] + "'";  //" where " +
			}

			for (int i = 1; i < setFields.length; i++) {
				whereClause += ", "  + setFields[i] + " = '" + setValues[i] + "'";  //+ cond + 
			}
		return whereClause;
	}
}
