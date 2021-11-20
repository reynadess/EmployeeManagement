package in.reynadess.relationalDataAccess;

import java.util.List;

import in.reynadess.model.Employee;

interface EmployeeDao {
	/**
	 * Get All employee Details from Persistent Data
	 * @return List of Employee Objects {@link in.reynadess.model.Employee}
	 */
	public List<Employee> getAllEmployees();
	
	/**
	 * Add new Employee to Persistent Data
	 * @param employee Employee Object {@link in.reynadess.model.Employee}
	 * @param password String Employee Password
	 * @return Number of rows affected
	 */
	public int addEmployee(Employee employee, String password);
	
	/**
	 * Get Employee ID
	 * @param id - employeeId
	 * @return Employee Object {@link in.reynades.model.Employee}
	 */
	public Employee getEmployeeById(Long id);
	
	/** 
	 * Update Employee Details
	 * @param id Employee Id
	 * @param employee Employee Object {@link in.reynadess.model.Employee} 
	 * @return Update Employee Object {@link in.reynadess.model.Employee}
	 */
	public Employee updateEmployeeById(Long id, Employee employee);
	
	/**Delete Employee Detail from Persistent Data
	 * @param Employee Id
	 * @return true if deleted
	 */
	public boolean deleteEmployeeById(Long id);
}