package com.cloudeye;

import com.cloudeye.generator.prop.GeneratorProperties;
import com.cloudeye.generator.util.GeneratorFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lafangyuan on 2018/5/23.
 */
public class CGTest {

    private Connection connection;


    @Before
    public void init(){
        GeneratorProperties generatorProperties = new GeneratorProperties();
        try {
            Class.forName(generatorProperties.getDriverClassName());
            connection = DriverManager.getConnection(generatorProperties.getUrl(), generatorProperties.getUsername(),
                    generatorProperties.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void createDomain(){
        try {
            GeneratorFactory.getInstance().gen("com.cloudeye.sys.basic", "user");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void createMapperAndServiceCode(){
        try {
            GeneratorFactory.getInstance().gen("com.cloudeye.sys.basic.model.User");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
