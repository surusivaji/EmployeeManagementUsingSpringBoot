package org.siva.employeemanagementsystem.repository;

import org.siva.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
