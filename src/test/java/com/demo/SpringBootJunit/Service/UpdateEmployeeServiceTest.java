package com.demo.SpringBootJunit.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
public class UpdateEmployeeServiceTest {

	@Autowired
	UpdateEmployeeServiceImpl employeeService;

	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	public void testupdateEmployee() throws EmployeeNotFoundException {
		Employee mockemployee = new Employee();

		mockemployee.setEmployeeId(1);
		mockemployee.setEmployeeName("Pranith");
		mockemployee.setCompanyName("HCL");
		Mockito.when(employeeRepository.findById(mockemployee.getEmployeeId())).thenReturn(Optional.of(mockemployee));
		Mockito.when(employeeRepository.save(mockemployee)).thenReturn(mockemployee);
		assertEquals(mockemployee, employeeService.updateEmployee(mockemployee));
	}

	@Test(expected = EmployeeNotFoundException.class)
	public void testEmployeeNotFoundException() throws EmployeeNotFoundException {
		Employee mockemployee = new Employee();

		Mockito.when(employeeRepository.findById(1)).thenReturn(null);
		//Mockito.when(employeeRepository.save(mockemployee)).thenReturn(mockemployee);
		employeeService.updateEmployee(mockemployee);
		
	}

}
