DROP DATABASE employee_management;

CREATE DATABASE employee_management;

CREATE TABLE employee_management.employees (
	employee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_email VARCHAR(255) NOT NULL,
    employee_password VARCHAR(255) NOT NULL,
    employee_name VARCHAR(255) NOT NULL,
    employee_role ENUM('ADMIN', 'EMPLOYEE') NOT NULL,
    date_of_birth DATE NOT NULL,
    base_salary DOUBLE NOT NULL,
    employee_status ENUM('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
    created_on TIMESTAMP NOT NULL DEFAULT(CURRENT_TIMESTAMP()),
    created_by INT NOT NULL,
    modified_on TIMESTAMP NOT NULL DEFAULT(now()),
    modified_by INT NOT NULL DEFAULT 0
);

INSERT INTO employee_management.employees(
	employee_email, employee_password, employee_name, employee_role, date_of_birth, base_salary, created_by
) VALUES (
	'reynadess@reynadess.com', 'reynadess', 'Reynadess', 'ADMIN', '1999-09-27', 450000, 1
);
