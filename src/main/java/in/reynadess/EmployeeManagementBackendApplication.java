package in.reynadess;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.reynadess.relational_data_access.Employee;
import in.reynadess.relational_data_access.RelationalDataAccess;

@SpringBootApplication
public class EmployeeManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementBackendApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		RelationalDataAccess dataAccess = context.getBean("relationalDataAccess", RelationalDataAccess.class);
		List<Employee> employees = dataAccess.getAllEmployees();
		System.out.println(employees);
	}

}
