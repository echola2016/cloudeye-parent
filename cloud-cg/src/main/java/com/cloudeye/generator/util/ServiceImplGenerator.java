package com.cloudeye.generator.util;


import com.cloudeye.generator.model.JavaModel;

/**
 * Created by Administrator on 2017/5/11.
 */
public class ServiceImplGenerator extends Generator {

    public ServiceImplGenerator(String fullClassPath) {
        super(new JavaModel(),fullClassPath);
    }
    @Override
    public void init() {
        this.tempSource= "ServiceImpl.vm";
    }
}
