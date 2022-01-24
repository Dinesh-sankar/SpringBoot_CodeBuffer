package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder()
								.departmentName("IT")
								.departmentAddress("Delhi")
								.departmentCode("IT-06")
								.departmentId(1L)
								.build();
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
			   .thenReturn(department);
		
	}

	@Test
	@DisplayName("Get Data Based on Valid Department Name")		//Displays in the JUnit TestCase after Runs
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "IT";
		Department found = departmentService.fetchDepartmentByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName()); //If values of both args are equal, then test case is passed 
	}
	
	/* @Test
	void test() {
		fail("Not yet implemented");
	} */

}
