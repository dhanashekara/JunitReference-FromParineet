package com.demo.SpringBootJunit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Repository.EmployeeRepository;

@Service
public class AddEmployeeServiceImpl implements AddEmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
}
