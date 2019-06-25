package com.demo.SpringBootJunit.Controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

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
import com.demo.SpringBootJunit.Service.ViewEmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewEmployeeControllerTest {

	private MockMvc mockMvc;

	@MockBean
	ViewEmployeeServiceImpl employeeService;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setup() {
		// MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testGetAllEmployees() throws Exception {

		List<Employee> mockemployee = Arrays.asList(new Employee(1, "pranith", "hcl"),
				new Employee(2, "Pavan", "Google"));

		Mockito.when(employeeService.getAllEmployees()).thenReturn(mockemployee);

		mockMvc.perform(MockMvcRequestBuilders.get("/employee/getAllEmployees")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(2))).andDo(print());
	}

	@Test
	public void getEmployeeByIdTest() throws Exception {
		Employee mockemployee = new Employee(1, "pranith", "hcl");

		Mockito.when(employeeService.getEmployeeById(Mockito.anyInt())).thenReturn(mockemployee);
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/getEmployee/{employeeId}", 1)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.employeeId", is(1))).andExpect(jsonPath("$.employeeName", is("pranith")))
				.andExpect(jsonPath("$.companyName", is("hcl"))).andDo(print());
	}

}
