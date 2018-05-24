package com.cloudeye.sys.basic.model;
import java.util.Date;
import java.io.Serializable;

public class Role implements Serializable {

 	private String name;
 	
 	private String description;
 	
 	private Integer id;
 	
 	private Integer seq;
 	
 	private Integer status;
 	
    
 	public void  setName(String name){
 		this.name = name;	
 	};
 	public String getName(){
 		return this.name;
 	}
 	public void  setDescription(String description){
 		this.description = description;	
 	};
 	public String getDescription(){
 		return this.description;
 	}
 	public void  setId(Integer id){
 		this.id = id;	
 	};
 	public Integer getId(){
 		return this.id;
 	}
 	public void  setSeq(Integer seq){
 		this.seq = seq;	
 	};
 	public Integer getSeq(){
 		return this.seq;
 	}
 	public void  setStatus(Integer status){
 		this.status = status;	
 	};
 	public Integer getStatus(){
 		return this.status;
 	}
    
 
 }
