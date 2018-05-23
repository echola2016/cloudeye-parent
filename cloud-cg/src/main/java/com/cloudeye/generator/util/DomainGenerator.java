package com.cloudeye.generator.util;





import com.cloudeye.generator.model.DomainModel;
import com.cloudeye.generator.model.JavaModel;
import com.cloudeye.generator.prop.GeneratorProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DomainGenerator extends Generator {

	private String database;
	private String table;
	private DomainModel model ;
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public DomainGenerator(String fullClassPath) {
		super(new DomainModel(),fullClassPath);

	}
	public DomainGenerator(String fullClassPath,String table) {
		super(new DomainModel(),fullClassPath);
		String name = new JavaModel().db2JavaStyle(table);
		String className =  name.substring(0,1).toUpperCase()+name.substring(1);
		model = (DomainModel) this.javaModel;
		model.setPackageName(this.fullClassPath.substring(0, this.fullClassPath.lastIndexOf(".")));
		model.setClassName(className);
		this.table = table;
		this.javaModel = this.model;
	}
	@Override
	public void init() {
		 this.tempSource = "Domain.vm";
		 if(connection==null){
			 connection = getConnection();
		 }
		this.database =new GeneratorProperties().getDatabase();
		 getColumns(table);
	}
	private List<Map<String,String>> getColumns(String tableName){
		DatabaseMetaData metaData  = null;
		try {
			metaData = connection.getMetaData();
			ResultSet rs = metaData.getColumns(null, database, tableName.toUpperCase(), "%");
			while(rs.next()){
				String columnName = rs.getString("COLUMN_NAME");//列名 
				String dataTypeName = rs.getString("TYPE_NAME");
				String remarks = rs.getString("REMARKS");//列描述
				System.out.println(columnName + "-" + dataTypeName + "-" + remarks); 
				model.setProperties(columnName, dataTypeName);
				model.setClassName(model.db2JavaStyle(tableName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	          
	}
	private List<Map<String,String>> getTables(){
		DatabaseMetaData metaData  = null;
		List<Map<String,String>> tables = new ArrayList<Map<String,String>>();
		try {
			 metaData = connection.getMetaData();
	            // table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".  
	            String[] types = { "TABLE" };  
	            ResultSet rs = metaData.getTables(null, database, "%", types);  
	            while (rs.next()) {  
	            	Map map = new HashMap<String,String>();
	                String tableName = rs.getString("TABLE_NAME");  //表名  
	                String tableType = rs.getString("TABLE_TYPE");  //表类型  
	                String remarks = rs.getString("REMARKS");       //表备注  
	                map.put("tableName", tableName);
	                map.put("tableType", tableType);
	                map.put("remarks", remarks);
	                tables.add(map);
	                System.out.println(tableName + "-" + tableType + "-" + remarks);  
	            }  
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
		
	}

	private Connection getConnection(){
		Connection con = null;
		 try {
			 	Class.forName("com.mysql.jdbc.Driver");
		      	String url = "jdbc:mysql://localhost:3306/"+database;  
		         String user = "root";  
		         String password = "1234qwer";
		         con = DriverManager.getConnection(url, user, password); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
   
         return con;
	}


}
