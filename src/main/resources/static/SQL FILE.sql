CREATE DATABASE employee_management;

CREATE TABLE employees (
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
    modified_on TIMESTAMP NOT NULL,
    modified_by INT NOT NULL,
);
