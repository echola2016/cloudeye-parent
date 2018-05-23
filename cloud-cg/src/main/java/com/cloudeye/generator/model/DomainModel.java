package com.cloudeye.generator.model;


import java.util.HashMap;
import java.util.Map;

public class DomainModel extends JavaModel {

	private Map<String,String> propertiesMap = new HashMap<String,String>();
	private Map<String,String> typeMap = new HashMap<String,String>();
	{
		initMap();
	}
	public Map<String, String> getPropertiesMap() {
		return propertiesMap;
	}
	public void setProperties(String prop,String type){
		this.propertiesMap.put(this.db2JavaStyle(prop), typeMap.get(type));
	}
	private void initMap (){
		typeMap.put("VARCHAR", "String");
		typeMap.put("DATETIME", "Date");
		typeMap.put("BIGINT", "Integer");
		typeMap.put("DOUBLE", "Double");
		typeMap.put("TINYINT", "Integer");
		typeMap.put("INT", "Integer");
		typeMap.put("LONGTEXT", "String");
		typeMap.put("TEXT", "String");
		typeMap.put("NVARCHAR2","String");
		typeMap.put("NUMBER", "Integer");
		typeMap.put("DATE", "Date");
		typeMap.put("VARCHAR2", "String");
		typeMap.put("CHAR", "String");
	}
	public void setPropertiesMap(Map<String, String> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}

	public DomainModel() {
	}
	public DomainModel(JavaModel javaModel) {
		this.packageName = javaModel.packageName;
		this.className = javaModel.className;
		this.classNickName = javaModel.classNickName;
		this.basePackage = javaModel.basePackage;
		this.modelClass = javaModel.modelClass;
	}
}
