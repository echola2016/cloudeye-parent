package com.cloudeye;


import com.ytkj.cg.generator.prop.GeneratorProperties;
import com.ytkj.cg.generator.util.GeneratorFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AomsApplication.class)
public class GeneratorUtilTest {

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
			GeneratorFactory.getInstance().gen("com.cloudeye.resume.basic", "resume_list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void createMapperAndServiceCode(){
		try {
			GeneratorFactory.getInstance().gen("com.cloudeye.resume.basic.model.ResumeList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
