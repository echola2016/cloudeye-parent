package com.cloudeye.generator.model;


import com.cloudeye.generator.prop.GeneratorProperties;

/**
 * Created by Administrator on 2017/5/11.
 */
public class TemplateModel {

    GeneratorProperties genProp = new GeneratorProperties();

    public synchronized  static String java2DBStyle(String field){
        char[] f = field.toCharArray();
        StringBuilder sb = new StringBuilder();
        int size = field.length();
        for(int i=0;i<size;i++){
            if(Character.isUpperCase(field.charAt(i))&&i>0){
                sb.append("_").append(Character.toLowerCase(field.charAt(i)));
            }else{
                sb.append(Character.toLowerCase(field.charAt(i)));
            }
        }
        return  sb.toString();
    }
    public synchronized  static  String db2JavaStyle(String field){
        StringBuilder sb = new StringBuilder();
        field = field.toLowerCase();
        int size = field.length();
        for(int i=0;i<size;i++){
            char c = field.charAt(i);
            if(String.valueOf(c).equals("_")){
                sb.append(Character.toUpperCase(field.charAt(++i)));
            }else{
                sb.append(c);
            }
        }

        return  sb.toString();
    }

    public GeneratorProperties getGenProp() {
        return genProp;
    }

    public void setGenProp(GeneratorProperties genProp) {
        this.genProp = genProp;
    }
}
