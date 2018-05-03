package com.cloudeye.base.service;

import com.cloudeye.base.mapper.CloudEyeBaseMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lafangyuan on 2018/5/3.
 */
public class CloudEyeBaseService<M extends CloudEyeBaseMapper,T extends Serializable> {

    @Autowired
    private M m;


    public T queryById(Object id){
        return (T) this.m.selectByPrimaryKey(id);
    }

    public Page<T> pageQuery(T t, int pageNum, int pageSize, String orderBy){
        Page<T> page = PageHelper.startPage(pageNum,pageSize,orderBy);
        this.m.select(t);
        return page;
    }

    public T update(T t){
        this.m.updateByPrimaryKeySelective(t);
        return t;
    }
    public void deleteByList(List<T> list)
    {
        for (T t:list
                ) {
            this.m.deleteByPrimaryKey(t);
        }

    }
    public void deleteById(String id){
        for(String s:id.split(",")){
            this.m.deleteByPrimaryKey(s);
        }
    }
    public void deleteByIdInt(String id){
        for(String s:id.split(",")){
            this.m.deleteByPrimaryKey(Integer.parseInt(s));
        }
    }
    //    public void deleteById(Object id){
//        this.m.deleteByPrimaryKey(id);
//    }
    public List<T> queryAll(T t){
        return this.m.select(t);
    }
    public List<T> queryAll(T t,String orderBy){
        Example example = new Example(t.getClass());
        example.setOrderByClause(orderBy);
        Example.Criteria c = example.createCriteria();
        List<Field> fields = new ArrayList();
        List<Field> sortFileds = new ArrayList<>();
        for(Class clazz = t.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        }
        for(Field f:fields){
            try {
                f.setAccessible(true);
                if(f.get(t)==null||"".equals(String.valueOf(f.get(t)))){
                    continue;
                }
                c.andEqualTo(f.getName(),f.get(t));
            } catch (IllegalAccessException e) {
                continue;
            }
        }
        return this.m.selectByExample(example);
    }

    public T save(T t){
        this.m.insertSelective(t);
        return t;
    }
    public Page<T> pageQueryLike(T t,int pageNum,int pageSize,String orderBy){
        Page<T> page = null;
        if(StringUtils.hasLength(orderBy)){
            page = PageHelper.startPage(pageNum,pageSize,orderBy);
        }else{
            page = PageHelper.startPage(pageNum,pageSize);
        }
        Example example = new Example(t.getClass(),false);
        example.setOrderByClause(orderBy);
        Example.Criteria criteria = example.createCriteria();
        Field[] fields = t.getClass().getDeclaredFields();
        for(Field f:fields){
            try {
                f.setAccessible(true);
                if(f.get(t)==null||"".equals(String.valueOf(f.get(t)))){
                    continue;
                }
                if(f.getType()==String.class) {
                    criteria.andLike(f.getName(),"%"+String.valueOf(f.get(t))+"%");
                }else{
                    criteria.andEqualTo(f.getName(),f.get(t));
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        m.selectByExample(example);

        return page;
    }


    public Page<T> pageQueryLikeWithOutFields(T t,List<String> withFields,int pageNum,int pageSize,String orderBy){
        Page<T> page = PageHelper.startPage(pageNum,pageSize,orderBy);
        Example example = new Example(t.getClass());
        Example.Criteria criteria = example.createCriteria();
        Field[] fields = t.getClass().getDeclaredFields();
        Boolean skipThis=false;
        for(Field f:fields){
            try {
                f.setAccessible(true);
                if(f.get(t)==null ||"".equals(String.valueOf(f.get(t)))){
                    continue;
                }
                if(f.getType()==String.class) {
                    skipThis=false;
                    for (int i = 0; i <withFields.size() ; i++) {
                        if(withFields.get(i)=="f.getName()"){
                            skipThis=true;
                            break;
                        }
                    }
                    if(skipThis){
                        continue;
                    }
                    criteria.andLike(f.getName(),"%"+String.valueOf(f.get(t))+"%");
                }else{
                    skipThis=false;
                    for (int i = 0; i <withFields.size() ; i++) {
                        if(withFields.get(i)=="f.getName()"){
                            skipThis=true;
                            break;
                        }
                    }
                    if(skipThis){
                        continue;
                    }
                    criteria.andEqualTo(f.getName(),f.get(t));
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        m.selectByExample(example);

        return page;
    }

}
