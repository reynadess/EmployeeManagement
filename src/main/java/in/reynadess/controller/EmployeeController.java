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
import in.reynadess.model.Employee;
import in.reynadess.relationalDataAccess.EmployeeDaoImpl;


/**
 * Employee Access Endpoints
 * @author reynadess
 *
 */
@CrossOrigin
@RestController
@RequestMapping("employee-management")
public class EmployeeController {
	
	@Autowired
	private EmployeeDaoImpl employeeDaoImpl;
	
	
	public EmployeeController() {
		super();
	}


	public EmployeeController(EmployeeDaoImpl dataAccess) {
		super();
		this.employeeDaoImpl = dataAccess;
	}


	public EmployeeDaoImpl getDataAccess() {
		return employeeDaoImpl;
	}


	public void setDataAccess(EmployeeDaoImpl dataAccess) {
		this.employeeDaoImpl = dataAccess;
	}

	/**
	 * Get All Employees REST Endpoint
	 * @return List of Employees
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() throws ResourceNotFoundException{
		List<Employee> employees =  employeeDaoImpl.getAllEmployees();
		if(employees == null) {
			throw new ResourceNotFoundException("Employees List is Empty");
		}
		return employees;
	}
	
	/**
	 * Creating Employee REST Endpoint
	 * @param employee {@link in.reynadess.relationalDataAccess.Employee} Web Request JSON 
	 */
	@PostMapping("/employees")
	public void createEmployee(@RequestBody Employee employee) {
		employeeDaoImpl.addEmployee(employee, employee.getName());
	}
	
	/**
	 * Employee Detail by Id REST Endpoint
	 * @param id
	 * @return ResponseEntity 
	 */
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeDaoImpl.getEmployeeById(id);
		if(employee == null) {
			throw new ResourceNotFoundException("Employee id not found:" + id);
		}
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
		System.out.println("Delete Request:" + String.valueOf(id));
		boolean delete = employeeDaoImpl.deleteEmployeeById(id);
		if(!delete) {
			throw new ResourceNotFoundException("Employee id not found:" + id);
		}
		return ResponseEntity.ok("Deleted Employee Id:" + String.valueOf(id));
	}	
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
		Employee employeeDetails = employeeDaoImpl.getEmployeeById(id);
		if(employeeDetails == null) {
			throw new ResourceNotFoundException("Employee id not found:" + id);
		}
		System.out.println("We are here!");
		Employee newEmployeeDetails = employeeDaoImpl.updateEmployeeById(id, employee);
		return ResponseEntity.ok(newEmployeeDetails);
	}
	
}
