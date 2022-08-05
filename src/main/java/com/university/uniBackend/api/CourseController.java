package com.university.uniBackend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.uniBackend.dtos.Course;
import com.university.uniBackend.services.CourseService;

@RestController
@RequestMapping(path = "/api/course")
public class CourseController {

	@Autowired
	private final CourseService courseService;

	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping(path = "/{courseId}")
	public Object getCourse(@PathVariable("courseId") Integer courseId){
		return courseService.getCourse(courseId);
	}
	
	@PostMapping
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
		
	}
	
}
