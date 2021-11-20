package in.reynadess.relationalDataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.reynadess.model.Employee;


/**
 * EmployeeMapper extends RowMapper to map ResultSet
 * @see RowMapper
 * @author chait
 *
 */
public class EmployeeMapper implements RowMapper<Employee> {

	@Override
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

}
