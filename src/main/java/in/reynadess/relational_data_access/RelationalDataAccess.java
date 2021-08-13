package in.reynadess.relational_data_access;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RelationalDataAccess {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbctemplate;

	public RelationalDataAccess() {
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public NamedParameterJdbcTemplate getNamedParameterJdbctemplate() {
		return namedParameterJdbctemplate;
	}


	public void setNamedParameterJdbctemplate(NamedParameterJdbcTemplate namedParameterJdbctemplate) {
		this.namedParameterJdbctemplate = namedParameterJdbctemplate;
	}


	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String query = "SELECT * FROM employee_management.employees";	
		employees = jdbcTemplate.query(query, new EmployeeMapper());
				
		return employees;
	}
	
	public int addEmployee(Employee employee, String password) {
		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("email", employee.getEmail());
		in.addValue("password", password);
		in.addValue("name", employee.getName());
		in.addValue("role", employee.getRole());
		in.addValue("dob", employee.getDateOfBirth());
		in.addValue("baseSalary", employee.getBaseSalary());
		in.addValue("createdBy", 1);
		
		
		String insertEmpoloyee = "INSERT INTO employee_management.employees(employee_email, employee_password, employee_name, employee_role, date_of_birth, base_salary, created_by) VALUES (:email, :password, :name, :role, :dob, :baseSalary, :createdBy);";
		
		int rowCount = namedParameterJdbctemplate.update(insertEmpoloyee, in);
		return rowCount;
	}
	
	public Employee getEmployeeById(int employeeId) {
		String query = "SELECT * FROM employee_management.employees WHERE employee_id = ?";
		List<Employee> employee = this.jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, employeeId);
			}
		}, new EmployeeMapper());
		
		return employee.get(0);
	}
}
