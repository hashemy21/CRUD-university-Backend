package com.university.uniBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.uniBackend.dtos.Department;
import com.university.uniBackend.repository.DepartmentRepository;

@Service
public class DepartmentService {


	@Autowired
    private final DepartmentRepository departmentRepository;
	
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}


	public Object getDepartment(Integer deptId) {
		return departmentRepository.findById(deptId);
	}


	public void addDepartment(Department department) {
		departmentRepository.save(department);	
	}

}
