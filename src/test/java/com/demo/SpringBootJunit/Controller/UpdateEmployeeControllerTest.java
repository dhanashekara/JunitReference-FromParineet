package com.demo.SpringBootJunit.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.SpringBootJunit.Entity.Employee;
import com.demo.SpringBootJunit.Service.AddEmployeeServiceImpl;
import com.demo.SpringBootJunit.Service.UpdateEmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UpdateEmployeeControllerTest {

	private MockMvc mockMvc;

	@MockBean
	UpdateEmployeeServiceImpl employeeService;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setup() {
		//MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testUpdateEmployee() throws Exception {
		Employee mockemployee = new Employee();

		mockemployee.setEmployeeId(1);
		mockemployee.setEmployeeName("Pranith");
		mockemployee.setCompanyName("HCL");

		String jsonRequest = objectMapper.writeValueAsString(mockemployee);
		Mockito.when(employeeService.updateEmployee(mockemployee)).thenReturn(mockemployee);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/employee/update").contentType(MediaType.APPLICATION_JSON)
				.content(jsonRequest)).andExpect(status().isOk()).andReturn();
		
	}

}
