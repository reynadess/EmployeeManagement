package in.reynadess;

import java.sql.Date;
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
//		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
//		RelationalDataAccess dataAccess = context.getBean("relationalDataAccess", RelationalDataAccess.class);
		
//		Employee employee = new Employee();
//		employee.setEmail("meghna@puli.com");
//		employee.setName("Meghna Puli");
//		employee.setRole("EMPLOYEE");
//		employee.setDateOfBirth(Date.valueOf("1998-03-08"));
//		employee.setBaseSalary(2000000);
//		employee.setEmployeeStatus("ACTIVE");
//		
//		dataAccess.addEmployee(employee, "meghna");
		
//		List<Employee> employees = dataAccess.getAllEmployees();
		
//		Get EmployeeId
//		Employee employee = dataAccess.getEmployeeById(3);
//		System.out.println(employee);
		
	}

}
