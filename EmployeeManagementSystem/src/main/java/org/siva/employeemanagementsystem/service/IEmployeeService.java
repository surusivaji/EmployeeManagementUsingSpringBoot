package org.siva.employeemanagementsystem.service;

import java.util.List;

import org.siva.employeemanagementsystem.model.Employee;

public interface IEmployeeService {
	Employee addEmployee(Employee emp);
	List<Employee> displayAllEmployees();
	Employee getEmployee(int id);
	boolean deleteEmployee(int id);
}
