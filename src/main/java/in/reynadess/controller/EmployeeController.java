package in.reynadess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.reynadess.relational_data_access.Employee;
import in.reynadess.relational_data_access.RelationalDataAccess;

@CrossOrigin
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
		return relationalDataAccess.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return relationalDataAccess.addEmployee(employee, employee.getName());
	}
}
