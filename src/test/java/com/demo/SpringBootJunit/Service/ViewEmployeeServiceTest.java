package com.demo.SpringBootJunit.Service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class ViewEmployeeServiceTest {

	@Autowired
	ViewEmployeeServiceImpl employeeService;

	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	public void TestGetEmployeeById() throws EmployeeNotFoundException {

		int employeeId = 1;
		Mockito.when(employeeRepository.findById(Mockito.anyInt()))
				.thenReturn(Optional.ofNullable(new Employee(1, "pranith", "hcl")));

		Employee employeeResult = employeeService.getEmployeeById(employeeId);

		Mockito.verify(employeeRepository, Mockito.times(1)).findById(Mockito.anyInt());
		assertEquals(employeeId, employeeResult.getEmployeeId());
	}
	
	@Test(expected = EmployeeNotFoundException.class)
	public void TestEmployeeNotFoundException() throws EmployeeNotFoundException {

		/*Employee mockemployee = new Employee();
		mockemployee.setEmployeeId(1);
		mockemployee.setEmployeeName("Pranith");
		mockemployee.setCompanyName("HCL");*/
		//Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.of(mockemployee));

		 employeeService.getEmployeeById(1);

	}
	
	@Test
	public void TestgetAllEmployees() {
		
		Mockito.when(employeeRepository.findAll())
		.thenReturn(Stream
						.of(new Employee(1,"Pranith","HCL"),
								new Employee(2,"Pavan","HCL"))
						.collect(Collectors.toList()));
		assertEquals(2, employeeService.getAllEmployees().size());
	}
	

}
