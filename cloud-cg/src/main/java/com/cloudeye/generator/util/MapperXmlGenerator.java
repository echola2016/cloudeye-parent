package com.cloudeye.generator.util;


import com.cloudeye.generator.model.JavaModel;

/**
 * Created by Administrator on 2017/5/11.
 */
public class MapperXmlGenerator extends Generator {


    public MapperXmlGenerator(String fullClassPath) {
        super(new JavaModel(),fullClassPath);
    }

    @Override
    public void init() {
        this.tempSource = "Mapper.xml.vm";
    }

    public static void main(String[] args) {
        String result = new MapperXmlGenerator("com.lingdian.sys.domain.Menu").gen();
        System.out.println(result);
    }
}
