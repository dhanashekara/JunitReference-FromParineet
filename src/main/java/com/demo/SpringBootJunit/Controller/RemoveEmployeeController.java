package com.demo.SpringBootJunit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootJunit.Exception.EmployeeNotFoundException;
import com.demo.SpringBootJunit.Service.RemoveEmployeeService;

@RequestMapping("/employee")
@RestController
public class RemoveEmployeeController {

	@Autowired
	RemoveEmployeeService employeeService;

	@DeleteMapping(value = "deleteEmployee/{employeeId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("employeeId") Integer employeeId)
			throws EmployeeNotFoundException {

		employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok().body("employee removed successfully");

	}

}
