package com.demo.SpringBootJunit.Service;

import java.util.List;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Exception.EmployeeNotFoundException;

public interface ViewEmployeeService {

	Employee getEmployeeById(Integer employeeId) throws EmployeeNotFoundException;

	List<Employee> getAllEmployees();

}
