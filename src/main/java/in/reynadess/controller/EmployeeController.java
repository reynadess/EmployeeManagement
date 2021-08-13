package in.reynadess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.reynadess.relational_data_access.Employee;
import in.reynadess.relational_data_access.RelationalDataAccess;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private RelationalDataAccess relationalDataAccess;
	
	
	public EmployeeController() {
		super();
	}


	public EmployeeController(RelationalDataAccess dataAccess) {
		super();
		this.relationalDataAccess = dataAccess;
	}


	public RelationalDataAccess getDataAccess() {
		return relationalDataAccess;
	}


	public void setDataAccess(RelationalDataAccess dataAccess) {
		this.relationalDataAccess = dataAccess;
	}


	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		System.out.println("Entered!");
		return relationalDataAccess.getAllEmployees();
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld!";
	}
}
