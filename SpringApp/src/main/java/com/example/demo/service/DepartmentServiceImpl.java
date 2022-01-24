package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department deptdb = departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) &&
				   !"".equalsIgnoreCase(department.getDepartmentName())) {
				deptdb.setDepartmentName(department.getDepartmentName());
		}

		if(Objects.nonNull(department.getDepartmentCode()) &&
				   !"".equalsIgnoreCase(department.getDepartmentCode())) {
						deptdb.setDepartmentCode(department.getDepartmentCode());
		}

		if(Objects.nonNull(department.getDepartmentAddress()) &&
				   !"".equalsIgnoreCase(department.getDepartmentAddress())) {
						deptdb.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		return departmentRepository.save(deptdb);
		
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}
	
}
