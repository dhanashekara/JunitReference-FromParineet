package com.demo.SpringBootJunit.Service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Exception.EmployeeNotFoundException;
import com.demo.SpringBootJunit.Repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RemoveEmployeeServiceTest {

	@Autowired
	RemoveEmployeeServiceImpl employeeService;

	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	public void testdeleteEmployeeById() throws EmployeeNotFoundException {
		Employee mockemployee = new Employee();
		mockemployee.setEmployeeId(1);
		mockemployee.setEmployeeName("Pranith");
		mockemployee.setCompanyName("HCL");
		Mockito.when(employeeRepository.findById(mockemployee.getEmployeeId())).thenReturn(Optional.of(mockemployee));
		employeeRepository.deleteById(mockemployee.getEmployeeId());
		employeeService.deleteEmployeeById(mockemployee.getEmployeeId());

	}

	@Test(expected = EmployeeNotFoundException.class)
	public void testEmployeeNotFoundException() throws EmployeeNotFoundException {
		/*
		 * Employee mockemployee = new Employee(); mockemployee.setEmployeeId(1);
		 * mockemployee.setEmployeeName("Pranith"); mockemployee.setCompanyName("HCL");
		 * 
		 * Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.of(
		 * mockemployee));
		 */
		employeeService.deleteEmployeeById(2);

	}

}
