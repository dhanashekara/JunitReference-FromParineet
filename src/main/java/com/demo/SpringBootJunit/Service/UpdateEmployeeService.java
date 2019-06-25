package com.demo.SpringBootJunit.Service;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Exception.EmployeeNotFoundException;

public interface UpdateEmployeeService {

	Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;

}
