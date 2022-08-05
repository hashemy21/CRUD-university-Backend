package com.university.uniBackend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.uniBackend.dtos.Department;
import com.university.uniBackend.services.DepartmentService;

@RestController
@RequestMapping(path = "/api/department")
public class DepartmentController {
	
	@Autowired
	private final DepartmentService departmentService;

	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@GetMapping(path = "/{deptId}")
	public Object getDepartment(@PathVariable ("deptId") Integer deptId) {
		return departmentService.getDepartment(deptId);
	}
	
	@PostMapping
	public void addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
		
	}
}
