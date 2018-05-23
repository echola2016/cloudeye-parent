package com.cloudeye.generator.util;



import com.cloudeye.generator.model.JavaModel;
import com.cloudeye.generator.prop.GeneratorProperties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Administrator on 2017/5/22.
 */
public class GeneratorFactory {


    private GeneratorProperties generatorProperties  = new GeneratorProperties();
    static GeneratorFactory factory  = null;
    private Connection connection;
    public static GeneratorFactory getInstance(){
        factory = new GeneratorFactory();
        factory.connection = getConnection();
        return factory;
    };
    public static GeneratorFactory getInstance(Connection connection){
        factory = new GeneratorFactory();
        factory.connection = connection;
        return factory;
    };
    private static  Connection getConnection(){
        GeneratorProperties generatorProperties = new GeneratorProperties();
        try{
            Class.forName(generatorProperties.getDriverClassName());
            Connection connection = DriverManager.getConnection(generatorProperties.getUrl(), generatorProperties.getUsername(),
                    generatorProperties.getPassword());
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void  gen(String packagePath,String table){
        System.out.println("#####代码生成器开始Domain#####");
        String path = System.getProperty("user.dir")+"/src/main/java/";
        String name = new JavaModel().db2JavaStyle(table);
        String className =  name.substring(0,1).toUpperCase()+name.substring(1);
        String fullClassPath = packagePath+"."+generatorProperties.getModelPackageName()+"."+className;
        DomainGenerator domainGenerator = new DomainGenerator(fullClassPath,table);
        domainGenerator.setConnection(this.connection);
        String domain = domainGenerator.gen();
        path = path+fullClassPath.replace(".", "/")+".java";
        output(domain,path);
        System.out.println("#####代码生成器结束生成Domain#####");
    }
    public void gen(String fullPathClass){
    	 String basicPath =  System.getProperty("user.dir")+"/src/main/java/"; 
    	 String className =fullPathClass.substring(fullPathClass.lastIndexOf(".")+1);
    	 String p  = fullPathClass.substring(0,fullPathClass.indexOf(generatorProperties.getModelPackageName())-1);
    	 basicPath = basicPath+p.replace(".", "/");
    	 System.out.println("#####代码生成器开始生成mapper#####");
         String mapper = new MapperGenerator(fullPathClass).gen();
         System.out.println(mapper);
         output(mapper, basicPath + "/"+generatorProperties.getDaoPackageName()+"/" + className + "Mapper.java");
         System.out.println("#####代码生成器结束生成mapper#####");
       /*  System.out.println("#####代码生成器开始生成mapperXml#####");
         String xml  =new MapperXmlGenerator(fullPathClass).gen();
         System.out.println(xml);
         output(xml,System.getProperty("user.dir")+"/src/main/resources/mybatis/"+className+"Mapper.xml");
         System.out.println("#####代码生成器结束生成mapperXml#####");*/
         System.out.println("#####代码生成器开始生成Service#####");
         String service = new ServiceGenerator(fullPathClass).gen();
         output(service, basicPath + "/" + generatorProperties.getServicePackageName() + "/" + className + "Service.java");
         System.out.println("#####代码生成器结束生成Service#####");
         System.out.println(service);
        /* System.out.println("#####代码生成器开始生成ServiceImpl#####");
         String serviceImpl  = new ServiceImplGenerator(fullPathClass).gen();
         System.out.println(serviceImpl);
         output(serviceImpl,basicPath+"/service/impl/"+className+"ServiceImpl.java");*/
         System.out.println("#####代码生成器结束生成ServiceImpl#####");

        System.out.println("#####代码生成器开始生成Controller#####");
        String controller = new ControllerGenerator(fullPathClass).gen();
        output(controller, basicPath + "/" + generatorProperties.getControllerPackageName() + "/" + className + "Controller.java");
        System.out.println("#####代码生成器结束生成Controller#####");
    }
    private  GeneratorFactory() {
    }
    private void output(String resource,String path){

    	  try {
            checkDir(path);
            FileOutputStream out = new FileOutputStream(new File(path));
  			out.write(resource.getBytes());
  			out.close();
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
    }
    private void checkDir(String path){
        String dir = path.substring(0,path.lastIndexOf("/"));
        File file = new File(dir);
        if(!file.isDirectory()){
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
