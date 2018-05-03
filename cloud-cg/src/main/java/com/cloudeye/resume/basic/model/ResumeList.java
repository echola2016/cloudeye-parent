package com.cloudeye.resume.basic.model;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ResumeList implements Serializable {

 	private String realName;
 	
 	private String telPhone;

 	@Id
 	private String id;
 	
 	private String title;
 	
    
 	public void  setRealName(String realName){
 		this.realName = realName;	
 	};
 	public String getRealName(){
 		return this.realName;
 	}
 	public void  setTelPhone(String telPhone){
 		this.telPhone = telPhone;	
 	};
 	public String getTelPhone(){
 		return this.telPhone;
 	}
 	public void  setId(String id){
 		this.id = id;	
 	};
 	public String getId(){
 		return this.id;
 	}
 	public void  setTitle(String title){
 		this.title = title;	
 	};
 	public String getTitle(){
 		return this.title;
 	}
    
 
 }
