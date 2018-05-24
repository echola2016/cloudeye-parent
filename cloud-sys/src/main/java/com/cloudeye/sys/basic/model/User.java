package com.cloudeye.sys.basic.model;
import java.util.Date;
import java.io.Serializable;

public class User implements Serializable {

 	private String salt;
 	
 	private Integer sex;
 	
 	private Integer organizationId;
 	
 	private String password;
 	
 	private String phone;
 	
 	private Date createTime;
 	
 	private String loginName;
 	
 	private String name;
 	
 	private Integer id;
 	
 	private Integer userType;
 	
 	private Integer age;
 	
 	private Integer status;
 	
    
 	public void  setSalt(String salt){
 		this.salt = salt;	
 	};
 	public String getSalt(){
 		return this.salt;
 	}
 	public void  setSex(Integer sex){
 		this.sex = sex;	
 	};
 	public Integer getSex(){
 		return this.sex;
 	}
 	public void  setOrganizationId(Integer organizationId){
 		this.organizationId = organizationId;	
 	};
 	public Integer getOrganizationId(){
 		return this.organizationId;
 	}
 	public void  setPassword(String password){
 		this.password = password;	
 	};
 	public String getPassword(){
 		return this.password;
 	}
 	public void  setPhone(String phone){
 		this.phone = phone;	
 	};
 	public String getPhone(){
 		return this.phone;
 	}
 	public void  setCreateTime(Date createTime){
 		this.createTime = createTime;	
 	};
 	public Date getCreateTime(){
 		return this.createTime;
 	}
 	public void  setLoginName(String loginName){
 		this.loginName = loginName;	
 	};
 	public String getLoginName(){
 		return this.loginName;
 	}
 	public void  setName(String name){
 		this.name = name;	
 	};
 	public String getName(){
 		return this.name;
 	}
 	public void  setId(Integer id){
 		this.id = id;	
 	};
 	public Integer getId(){
 		return this.id;
 	}
 	public void  setUserType(Integer userType){
 		this.userType = userType;	
 	};
 	public Integer getUserType(){
 		return this.userType;
 	}
 	public void  setAge(Integer age){
 		this.age = age;	
 	};
 	public Integer getAge(){
 		return this.age;
 	}
 	public void  setStatus(Integer status){
 		this.status = status;	
 	};
 	public Integer getStatus(){
 		return this.status;
 	}
    
 
 }
