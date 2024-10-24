package org.siva.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.siva.employeemanagementsystem.model.Employee;
import org.siva.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee emp) {
		try {
			Employee save = employeeRepository.save(emp);
			if (save!=null) {
				return save;
			}
			return null;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Employee> displayAllEmployees() {
		try {
			List<Employee> list = employeeRepository.findAll();
			return list;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Employee getEmployee(int id) {
		try {
			Optional<Employee> optional = employeeRepository.findById(id);
			if (optional.isPresent()) {
				return optional.get();
			}
			else {
				return null;
			}
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean deleteEmployee(int id) {
		try {
			Employee employee = getEmployee(id);
			if (employee!=null) {
				employeeRepository.deleteById(id);
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}
	}

}
