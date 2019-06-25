package com.demo.SpringBootJunit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Exception.EmployeeNotFoundException;
import com.demo.SpringBootJunit.Service.ViewEmployeeService;

@RequestMapping("/employee")
@RestController
public class ViewEmployeeController {

	@Autowired
	ViewEmployeeService viewEmployeeService;

	@GetMapping(value = "getEmployee/{employeeId}")

	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Integer employeeId)
			throws EmployeeNotFoundException {
		return ResponseEntity.ok(viewEmployeeService.getEmployeeById(employeeId));

	}

	@GetMapping(value="/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> employee = viewEmployeeService.getAllEmployees();
		return ResponseEntity.ok().body(employee);
	}
}
