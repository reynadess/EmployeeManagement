package in.reynadess.relational_data_access;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class RelationalDataAccess {
	JdbcTemplate jdbcTemplate;

	public RelationalDataAccess() {
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("Jdbc Template invoked");
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String query = "SELECT * FROM employee_management.employees";	
		employees = jdbcTemplate.query(query, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setEmail(rs.getString(2));
				employee.setName(rs.getString(4));
				employee.setRole(rs.getString(5));
				employee.setDateOfBirth(rs.getDate(6));
				employee.setBaseSalary(rs.getDouble(7));
				employee.setEmployeeStatus(rs.getString(8));
				return employee;
			}
			
		});
				
		return employees;
	}
}
