package com.demo.SpringBootJunit.Service;

import com.demo.SpringBootJunit.Exception.EmployeeNotFoundException;

public interface RemoveEmployeeService {

	void deleteEmployeeById(Integer employeeId) throws EmployeeNotFoundException;

}
