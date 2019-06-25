package com.demo.SpringBootJunit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Exception.EmployeeNotFoundException;
import com.demo.SpringBootJunit.Service.UpdateEmployeeService;

@RequestMapping("/employee")
@RestController
public class UpdateEmployeeController {
	
	@Autowired
	UpdateEmployeeService employeeService;

	@PutMapping(value="/update")

	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
		return ResponseEntity.ok(employeeService.updateEmployee(employee));

	}
}
