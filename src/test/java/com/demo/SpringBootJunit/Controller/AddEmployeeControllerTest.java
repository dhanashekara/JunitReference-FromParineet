package com.demo.SpringBootJunit.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddEmployeeControllerTest {

	private MockMvc mockMvc;

	@MockBean
	AddEmployeeServiceImpl employeeService;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setup() {
		//MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testAddEmployee() throws Exception {
		Employee employee = new Employee();

		employee.setEmployeeId(1);
		employee.setEmployeeName("lokesh");
		employee.setCompanyName("HCL");

		String jsonRequest = objectMapper.writeValueAsString(employee);
		Mockito.when(employeeService.addEmployee(employee)).thenReturn(employee);
		mockMvc.perform(MockMvcRequestBuilders.post("/employee/save").contentType(MediaType.APPLICATION_JSON)
				.content(jsonRequest)).andExpect(status().isOk()).andReturn();

	}

}
