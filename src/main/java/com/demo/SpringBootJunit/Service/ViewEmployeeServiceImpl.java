package com.demo.SpringBootJunit.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Exception.EmployeeNotFoundException;
import com.demo.SpringBootJunit.Repository.EmployeeRepository;

@Service
public class ViewEmployeeServiceImpl implements ViewEmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee getEmployeeById(Integer employeeId) throws EmployeeNotFoundException {
		Optional<Employee> optionalProduct = employeeRepository.findById(employeeId);
		if (!optionalProduct.isPresent()) {
			throw new EmployeeNotFoundException("No Such Employee Found");
		}
		return optionalProduct.get();
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
