package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() throws Exception {
		Department department = 
				Department.builder()
				.departmentName("Mechanical Enginnering")
				.departmentCode("ME-011")
				.departmentAddress("Delhi")
				.build();
		
		entityManager.persist(department);	//This data will pass before the test case is called
	}
	
	@Test
	public void whenFindById_thenReturnDepartment() {
		Department department = departmentRepository.findById(1L).get();
		assertEquals(department.getDepartmentName(), "Mechanical Enginnering");
	}
	
	/* @Test
	void test() {
		fail("Not yet implemented");
	} */

}
