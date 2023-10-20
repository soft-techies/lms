package com.core;

import java.sql.*;
import java.io.*;
import java.util.*;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.userlogin.model.request.DatabaseTablesRequest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Service
public class SearchOnHome
{
	
	@PersistenceContext
	EntityManager entityManager;	
	
	private String sqlSelect;

	private String uriName;
	private String dsnName;
	private String driverName;
	private String tableName; 
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	private int numberOfColumns;
	private int numberOfRow;
	private String [][] records;
	private String [] columnNames;
	private String columnName;

	private String report;
	private int countColumn;
	
	BufferedWriter bw;	
	ResultSetMetaData rsmd;
		
	public SearchOnHome(){}

	public String getSqlSelect(){ return sqlSelect; }

	public void setSqlSelect(String sqlSelect){ this.sqlSelect = sqlSelect; }

	public void showSqlSelect(){	System.out.println(sqlSelect); }
	
	public String getReport(){ return report; }
	
	public String getTitle(String str)
	{
		String title;
		char ch;
		char ch1;
		int ln;
		
		StringBuilder sb = new StringBuilder(str);
		for(int i=0;i<sb.length();i++)
		{
			ch = sb.charAt(i);
			if(i!=0 && Character.isUpperCase(ch))
			{
				sb.insert(i," ");
				i++;
			}
		}
		
		if(sb.charAt(0)>=97 && sb.charAt(0)<=122)
		{
			ch1 = (char) (sb.charAt(0)-32);
			String ch2 = ""+ch1;
			sb.setCharAt(0,ch1);
		}
	
		System.out.println(sb);	
		return sb.toString();
	}
	
	public void connectDB()
	{
//		dsnName="MusicAlbum";
//		uriName = "jdbc:odbc:"+dsnName;
//		driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
		
		dsnName="learndb1";
		uriName = "jdbc:mysql://127.0.0.1:3306/"+dsnName;
		driverName = "com.mysql.cj.jdbc.Driver";
		
		try
		{
			if(con==null)
			{
				Class.forName(driverName);
				con=DriverManager.getConnection(uriName);
			}
		}catch(SQLException se){
			se.printStackTrace(System.err);
		}catch(ClassNotFoundException cnfe){
				cnfe.printStackTrace(System.err);
		}
	}
	
	

	// --------------------- createSelectQuery() ----------------------------
	
	public void createSelectQuery(String tableName)
	{
		sqlSelect = "Select * from "+tableName;
	}
		
	public void createSelectQuery(String tableName, String whereField,String whereValue)
	{
		sqlSelect = "Select * from "+tableName+" where "+whereField+" = '"+whereValue+"'";
	}
	
	public void createSelectQuery(String tableName, String whereField,String whereValue,boolean isLike)
	{
		sqlSelect = "Select * from "+tableName+" where "+whereField+" Like '%"+whereValue+"%'";
	}	
		
	public void createSelectQuery(String tableName, String [] fieldsList)
	{
		String cols=getCols(fieldsList);		
		sqlSelect = "Select "+cols+" from "+tableName;
	}
	
	public void createSelectQuery(String tableName, String [] whereFields,String [] whereValues,int condition)
	{
		String whereClause=getWhereClause(whereFields,whereValues,condition);
		sqlSelect = "Select * from "+tableName+" "+whereClause;
		System.out.println(sqlSelect);
	}		
	
	public void createSelectQuery(String tableName, String [] fieldsList, String [] whereFields,String [] whereValues,int condition)
	{
		String cols=getCols(fieldsList);
		String whereClause=getWhereClause(whereFields,whereValues,condition);
		sqlSelect = "Select "+cols+" from "+tableName+whereClause;
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
			Statement stmtField =con.createStatement();
			ResultSet rsField=stmtField.executeQuery(sqlSelectField);
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
			stmtField.close();			
		}catch(SQLException se){
			se.printStackTrace(System.err);
		}		
		return recordsField;
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
	
	public String getWhereClause(String [] whereFields,String [] whereValues,int condition)
	{
		String whereClause="";
		String cond="AND";
		
		if(condition==0){cond = "OR";}		
		if(condition==1){cond = "AND";}
		if(condition==2){cond = "OR";}			
		if(condition==3){cond = "AND";}
		
		if(condition<=1)
		{
			if(whereFields.length >=1){ whereClause +=" where "+whereFields[0]+" = '"+whereValues[0]+"'";}
		
			for(int i=1;i<whereFields.length;i++){whereClause += " "+cond+" "+ whereFields[i]+" = '"+whereValues[i]+"'";}
		}			
		
		if(condition >= 2)
		{
			if(whereFields.length >=1){ whereClause +=" where "+ whereFields[0]+" Like '"+whereValues[0]+"%'";}
		
			for(int i=1;i<whereFields.length;i++){whereClause +=" "+cond+" "+ whereFields[i]+" Like '"+whereValues[i]+"%'";}
		}			
		
		return 	whereClause;	
	}		
	
	public void executeSelectQuery()
	{		
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(sqlSelect);
		}catch(SQLException se){
			se.printStackTrace(System.err);
		}
	}
	
	public void executeSelectQuery(String sqlSelect)
	{		
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(sqlSelect);
		}catch(SQLException se){
			se.printStackTrace(System.err);
		}
	}	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> executeSelectQuery(String sqlSelect,boolean isEntityManagerUsed)
	{		
		List<Object[]> tablesdata = null;
		try
		{
			tablesdata = entityManager.createNativeQuery(sqlSelect).getResultList();			 			
		}catch(Exception se){
			se.printStackTrace(System.err);
			return tablesdata;
		}
		return tablesdata;
	}	
	
	public void fetchRecord()
	{
		try
		{	
	    	ResultSetMetaData rsmd = rs.getMetaData();
    	 	numberOfColumns = rsmd.getColumnCount();
    	 	numberOfRow = 1200; //getRowCount(rs);
		
			columnNames = new String[100];    	 	

			tableName = getTitle(rsmd.getTableName(1));
			System.out.println("---------Table------"+tableName);
	  		
	  		int i=1;countColumn=rsmd.getColumnCount();
			
			while(i<=countColumn)
			{
	      		columnName = rsmd.getColumnName(i); //rsmd.getColumnLabel(i);
	      		columnName = getTitle(columnName);
	      		columnNames[i-1] = columnName;
	      		i++;		  		
			}
			
			records = new String[numberOfRow][numberOfColumns];
			int cntRow=-1;
			while(rs.next())
			{	
				cntRow++;
	    	 	for(int cntColumn=1;cntColumn<=numberOfColumns;cntColumn++)
    	 		{			
					records[cntRow][cntColumn-1] = rs.getString(cntColumn);
				}
			}
			numberOfRow = cntRow;
			rs.close();
			stmt.close();						
		}catch(SQLException se){
			se.printStackTrace(System.err);
		}
	}

	public String [][] getRecords(ArrayList al,int numberOfRow,int numberOfColumns)
	{
		String [][] rec = new String[numberOfRow][numberOfColumns];
		int k=0;
		for(int i=0;i<numberOfRow;i++)
		{
			for(int j=0;j<numberOfColumns;j++)
			{	
				rec[i][j] = (String) al.get(k);k++;
			//	System.out.println("K - > "+k);
				
			}
		}		
		return rec;
	}
	public void showRecords()
	{
		for(int cntRow=0;cntRow<numberOfRow;cntRow++)
		{	
		   	for(int cntColumn=1;cntColumn<=numberOfColumns;cntColumn++)
    	 	{			
				System.out.print("* "+records[cntRow][cntColumn-1]+" * - ");
			}
			System.out.println("\n");
		}
		if(numberOfRow<0)
		{	
			System.out.println("------ No recod found for the id entered !!!");
		}
	}
	
	public void createReport()
	{	String oddline = "#FFFFFF";		
		String evenline = "#F1F5FA";		
		String bgcolor = oddline;		
		try
		{
			bw = new BufferedWriter(new FileWriter("C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\FamilyChart\\Reports\\"+tableName+".html"));
			report = "\t\t<table width='100%' border='1' align='center' cellpadding='1' cellspacing='1'>";
			report += getHeadings();
			for(int cntRow=0;cntRow<=numberOfRow;cntRow++)
			{	
				if((cntRow+1)%2 == 0 )
				{
					bgcolor=evenline;
				}
				else
				{
					bgcolor=oddline;
				}
				report += "\n\t\t\t<tr bgcolor = '"+bgcolor+"'>";
		   		for(int cntColumn=1;cntColumn<=numberOfColumns;cntColumn++)
    	 		{	
    	 			report += "\n\t\t\t\t<td>"+records[cntRow][cntColumn-1]+"</td>";		
				}
				report += "\n\t\t\t</tr>";
			}
			if(numberOfRow<0)
			{	
				report +="\n------ No recod found for the id entered !!!";
			}			
			
			report += "\n\t\t</table>";
			bw.write(report);
			bw.close();						
			
		}catch(Exception e)
		{	e.printStackTrace(System.err);	}	
	}
	
	public String getHeadings()
	{
	  	String reportheading="";
	  	int i=0;
			
		while(i<countColumn)
		{
			reportheading +="\n\t\t\t<th bgcolor='#FFFFCC' scope='col'><span class='style16'>"+columnNames[i]+"</span></th>";
	      	i++;		  		
		}		
		return reportheading;
	}
		
	public void disconnectDB()
	{
		try
		{
			if(con!=null)
			{
				con.close();
			}
		}catch(SQLException se){
			se.printStackTrace(System.err);
		}
	}
			
	public String toString(){
		return "State of  SearchOnHome Object :"
		+" SqlSelect = "+sqlSelect;
	}

	public static void main(String [] args)
	{
//		SearchOnHome searchonhome = new SearchOnHome();
//		
//		String [] wf = {"SongName","MovieName","songStatus"};
//		String [] wv = {"Patli","BARS","Ru"};
//			
//		searchonhome.connectDB();
//		searchonhome.createSelectQuery("AllSongBasicInfo",wf,wv,3);
//		searchonhome.executeSelectQuery();
//		searchonhome.fetchRecord();	
//		searchonhome.createReport();		
//		searchonhome.showRecords();	
//		
//		System.out.println(searchonhome);
		
		
		SearchOnHome searchonhome = new SearchOnHome();
		
		String [] wf = {"email","name","password"};
		String [] wv = {"ink@gmail.com","ink","ink"};
			
		//searchonhome.connectDB();
//		searchonhome.createSelectQuery("user_register",wf,wv,3);
		List<Object[]> tablesdata = searchonhome.executeSelectQuery("Select * from user_register",true);
//		searchonhome.fetchRecord();	
//		searchonhome.createReport();		
//		searchonhome.showRecords();
		
		System.out.println(tablesdata);		
	}
}

/*
 *		SearchOnHome searchonhome = new SearchOnHome();
		
		String [] wf = {"personFatherName"};//"personFirstName","personNickName","personFatherName","personLastName"};
		String [] wv = {"Kailash"};//"Nikita","Mona","Kailash","Khirvat"};
			
		searchonhome.connectDB();
		searchonhome.createSelectQuery("Person",wf,wv,2);//"personFirstName","Irshita"); 
		searchonhome.executeSelectQuery();
		searchonhome.fetchRecord();	
		searchonhome.createReport();		
		searchonhome.showRecords();
		
		System.out.println(searchonhome);
		
		String vanshName = 	"Khirvat Vansh";
		String vanshId   = 	"001";
		String personId  = 	"111";
		
		String fields[] = {"personName","personFatherName","personGender"};
		String whereFields[] = {"personVanshId","personId"};		
		String whereValues[] = {vanshId,personId};
		
		String result[][] = searchonhome.getFieldValues("PersonDetails",fields,whereFields,whereValues,1);
		String personName = result[0][0];	
		System.out.println("Person Name : "+personName);
 *
 */	
