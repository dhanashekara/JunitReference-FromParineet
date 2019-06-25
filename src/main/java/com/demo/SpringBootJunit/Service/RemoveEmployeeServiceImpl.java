package com.demo.SpringBootJunit.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Exception.EmployeeNotFoundException;
import com.demo.SpringBootJunit.Repository.EmployeeRepository;

@Service
public class RemoveEmployeeServiceImpl implements RemoveEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public void deleteEmployeeById(Integer employeeId) throws EmployeeNotFoundException {

		Optional<Employee> deleteEmployee = employeeRepository.findById(employeeId);
	if (!deleteEmployee.isPresent()) {
		throw new EmployeeNotFoundException("No Such Employee Found");
	}
	 employeeRepository.deleteById(employeeId);
}

}
