package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	//Searching with Ignoring Case Sensitive
	public Department findByDepartmentName(String departmentName);
	
	//Ignore Case Sensitive when searching through URl
	public Department findByDepartmentNameIgnoreCase(String departmentName);
	
}
