package com.university.uniBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.uniBackend.dtos.Course;
import com.university.uniBackend.repository.CourseRepository;

@Service
public class CourseService {
	

	@Autowired
    private final CourseRepository courseRepository;
	
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Object getCourse(Integer courseId) {
		return courseRepository.findById(courseId);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

}
