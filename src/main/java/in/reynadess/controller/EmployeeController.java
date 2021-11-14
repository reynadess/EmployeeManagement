package in.reynadess.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.reynadess.exception.EmployeeErrorResponse;
import in.reynadess.exception.ResourceNotFoundException;
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
		System.out.println("Get All employees");
		return relationalDataAccess.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return relationalDataAccess.addEmployee(employee, employee.getName());
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = relationalDataAccess.getEmployeeById(id);
		if(employee == null) {
			throw new ResourceNotFoundException("Employee id not found:" + id);
		}
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
		Employee employeeDetails = relationalDataAccess.getEmployeeById(id);
		if(employeeDetails == null) {
			throw new ResourceNotFoundException("Employee id not found:" + id);
		}
		System.out.println("We are here!");
		Employee newEmployeeDetails = relationalDataAccess.updateEmployeeById(id, employee);
		return ResponseEntity.ok(newEmployeeDetails);
	}
	
}
