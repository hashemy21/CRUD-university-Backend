package com.university.uniBackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.uniBackend.dtos.Student;
import com.university.uniBackend.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
    private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Object getStudent(Integer studentId) {
		return studentRepository.findById(studentId);
	}

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

}
