package in.reynadess.relational_data_access;

import java.sql.Date;

public class Employee {
	private int id;
	private String email;
	private String name;
	private String role;
	private Date dateOfBirth;
	private double baseSalary;
	private String employee_status;
	
	public Employee() {
	}

	public Employee(int id, String email, String name, String role, Date dateOfBirth, double baseSalary,
			String employee_status) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.role = role;
		this.dateOfBirth = dateOfBirth;
		this.baseSalary = baseSalary;
		this.employee_status = employee_status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", name=" + name + ", role=" + role + ", dateOfBirth="
				+ dateOfBirth + ", baseSalary=" + baseSalary + ", employee_status=" + employee_status + "]";
	}
	
}
