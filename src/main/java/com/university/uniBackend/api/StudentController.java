package com.university.uniBackend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.uniBackend.dtos.Student;
import com.university.uniBackend.services.StudentService;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

	@Autowired 	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping(path = "/{studentId}")
	public Object getDepartment(@PathVariable("studentId") Integer studentId) {
		return studentService.getStudent(studentId);
	}
	
	@PostMapping
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		
	}

}
