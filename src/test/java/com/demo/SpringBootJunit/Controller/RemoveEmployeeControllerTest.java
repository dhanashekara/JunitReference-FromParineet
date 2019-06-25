package com.demo.SpringBootJunit.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.demo.SpringBootJunit.Service.RemoveEmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RemoveEmployeeControllerTest {

	private MockMvc mockMvc;

	@MockBean
	RemoveEmployeeServiceImpl employeeService;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setup() {
		//MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testRemoveEmployee() throws Exception {
		Employee mockemployee = new Employee();

		mockemployee.setEmployeeId(1);
		mockemployee.setEmployeeName("Pranith");
		mockemployee.setCompanyName("HCL");

		String jsonRequest = objectMapper.writeValueAsString(mockemployee);	
		mockMvc.perform(MockMvcRequestBuilders.delete("/employee/deleteEmployee/{employeeId}",1).contentType(MediaType.APPLICATION_JSON)
				.content(jsonRequest)).andExpect(status().isOk()).andDo(print());
		
	}

}
