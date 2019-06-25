package com.demo.SpringBootJunit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Service.AddEmployeeService;

@RequestMapping("/employee")
@RestController
public class AddEmployeeController {

	@Autowired
	AddEmployeeService employeeService;

	@PostMapping(value="/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.addEmployee(employee));

	}

}
