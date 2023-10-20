package com.lms.userlogin.model.request;

public class DatabaseTablesRequest {
	
	private String tablename;
	private String whereField;
	private String whereValue;
	
	
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getWhereField() {
		return whereField;
	}
	public void setWhereField(String whereField) {
		this.whereField = whereField;
	}
	public String getWhereValue() {
		return whereValue;
	}
	public void setWhereValue(String whereValue) {
		this.whereValue = whereValue;
	}
	
	

}
