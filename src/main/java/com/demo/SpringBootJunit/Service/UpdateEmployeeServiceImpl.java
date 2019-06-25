package com.demo.SpringBootJunit.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Exception.EmployeeNotFoundException;
import com.demo.SpringBootJunit.Repository.EmployeeRepository;

@Service
public class UpdateEmployeeServiceImpl implements UpdateEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {

		Optional<Employee> getEmployeebyId = employeeRepository.findById(employee.getEmployeeId());
		if (!getEmployeebyId.isPresent()) {
			throw new EmployeeNotFoundException("No Such Employee Found");
		}
		return employeeRepository.save(employee);
	}

}
