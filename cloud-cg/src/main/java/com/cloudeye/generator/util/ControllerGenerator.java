package com.cloudeye.generator.util;


import com.cloudeye.generator.model.JavaModel;
import com.cloudeye.generator.prop.GeneratorProperties;

/**
 * Created by Administrator on 2018/1/27.
 */
public class ControllerGenerator extends Generator {

    public ControllerGenerator(JavaModel javaModel, String fullClassPath) {
        super(new JavaModel(), fullClassPath);
    }
    public ControllerGenerator(String fullClassPath) {
        super(new JavaModel(),fullClassPath);
    }

    @Override
    public void init() {
        this.tempSource="Controller.vm";
    }
    @Override
    public void setModel() {
        GeneratorProperties generatorProperties = new GeneratorProperties();
        String packagePath = this.fullClassPath.substring(0,this.fullClassPath.indexOf("."+generatorProperties.getModelPackageName()+"."))
                +"."+generatorProperties.getControllerPackageName();
        JavaModel javaModel = this.javaModel;
        String className =this.fullClassPath.substring(this.fullClassPath.lastIndexOf(".")+1);
        String classNickName = className.substring(0,1).toLowerCase()+className.substring(1);
        javaModel.setClassName(className);
        javaModel.setClassNickName(classNickName);
        javaModel.setPackageName(packagePath);

    }
}
