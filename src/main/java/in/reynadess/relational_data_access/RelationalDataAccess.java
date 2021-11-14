package in.reynadess.relational_data_access;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	public Employee addEmployee(Employee employee, String password) {
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
		return employee;
	}
	
	public Employee getEmployeeById(Long id) {
		String query = "SELECT * FROM employee_management.employees WHERE employee_id = ?";
		List<Employee> employee = this.jdbcTemplate.query(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setLong(1, id);
			}
		}, new EmployeeMapper());
		if(employee.size() < 1) {
			return null;
		}
		return employee.get(0);
	}
	
	public boolean deleteEmployeeById(Long id) {
		String query = "DELETE FROM employee_management.employees WHERE employee_id = ?";
		int rowsAffected;
		try {
			rowsAffected = this.jdbcTemplate.update(query, new PreparedStatementSetter() {
	
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setLong(1, id);
				}
				
			});
		}
		catch(DataAccessException ex) {
			ex.printStackTrace();
			return false;
		}
		if(rowsAffected >= 1) {
			return true;
		}
		return false;
	}
	
	public Employee updateEmployeeById(Long id, Employee employee) {
		String query = "UPDATE employee_management.employees SET employee_email = ?, employee_name = ?, employee_role = ?,  date_of_birth = ?, base_salary = ?, employee_status = ?, modified_on = CURRENT_TIMESTAMP(), modified_by = 1 WHERE employee_id = ?;";
		int rowCount = this.jdbcTemplate.update(query, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, employee.getEmail());
				ps.setString(2, employee.getName());
				ps.setString(3, employee.getRole());
				ps.setDate(4, employee.getDateOfBirth());
				ps.setDouble(5, employee.getBaseSalary());
				ps.setString(6, employee.getEmployeeStatus());
				ps.setInt(7, employee.getId());
			}
			
		});
		if(rowCount == 0) {
			return null;
		}
		return getEmployeeById(id);
	}
	
}
