package com.university.uniBackend.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.uniBackend.dtos.Instructor;
import com.university.uniBackend.repository.InstructorRepository;

@Service
public class InstructorService {


	@Autowired
    private final InstructorRepository instructorRepository;
	
	public InstructorService(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}
	
	public List<Instructor> getAllInstructors() {
		return instructorRepository.findAll();
	}

	public Object getInstructor(Integer instId) {
		return instructorRepository.findById(instId);
	}

	public void addInstructor(Instructor instructor) {
		instructorRepository.save(instructor);		
	}

}
