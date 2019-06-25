package com.demo.SpringBootJunit.Service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddEmployeeServiceTest {
	
	@Autowired
	AddEmployeeServiceImpl employeeService;

	@MockBean
	EmployeeRepository employeeRepository;
	
	@Test
	public void testAddEmployee() {
		Employee employee = new Employee();

		employee.setEmployeeId(1);
		employee.setEmployeeName("lokesh");
		employee.setCompanyName("HCL");
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeService.addEmployee(employee));
	}
	
	
}
