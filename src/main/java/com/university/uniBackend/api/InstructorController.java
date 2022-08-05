package com.university.uniBackend.api;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.uniBackend.dtos.Instructor;
import com.university.uniBackend.services.InstructorService;

@RestController
@RequestMapping(path = "/api/instructor")
public class InstructorController {

	@Autowired
	private final InstructorService instructorService;

	
	public InstructorController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	
	@GetMapping
	public List<Instructor> getAllInstructors() {
		return instructorService.getAllInstructors();
	}
	
	@GetMapping(path = "/{instId}")
	public Object getInstructor(@PathVariable ("instId") Integer instId) {
		return instructorService.getInstructor(instId);
	}
	
	@PostMapping
	public void addInstructor(@RequestBody Instructor instructor) {
		instructorService.addInstructor(instructor);
		
	}
}
