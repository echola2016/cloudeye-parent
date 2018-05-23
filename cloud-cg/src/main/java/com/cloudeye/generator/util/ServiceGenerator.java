package com.cloudeye.generator.util;


import com.cloudeye.generator.model.JavaModel;
import com.cloudeye.generator.prop.GeneratorProperties;

/**
 * Created by Administrator on 2017/5/11.
 */
public class ServiceGenerator extends Generator {


    public ServiceGenerator(String fullClassPath) {
        super(new JavaModel(),fullClassPath);
    }


    @Override
    public void init() {
        this.tempSource = "Service.vm";
    }

    @Override
    public void setModel() {
        GeneratorProperties generatorProperties = new GeneratorProperties();
        String packagePath = this.fullClassPath.substring(0,this.fullClassPath.indexOf("."+generatorProperties.getModelPackageName()+"."))
                +"."+generatorProperties.getServicePackageName();
        JavaModel javaModel = this.javaModel;
        String className =this.fullClassPath.substring(this.fullClassPath.lastIndexOf(".")+1);
        String classNickName = className.substring(0,1).toLowerCase()+className.substring(1);
        javaModel.setClassName(className);
        javaModel.setClassNickName(classNickName);
        javaModel.setPackageName(packagePath);

    }
}
