package in.reynadess.relational_data_access;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RelationalDataAccess {
	static ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
	static MyJdbcTemplate myJdbcTemplate = context.getBean("myJdbcTemplate", MyJdbcTemplate.class);
	
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		return employees;
	}
}
