package com.university.uniBackend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.university.uniBackend.dtos.Course;
import com.university.uniBackend.dtos.Department;
import com.university.uniBackend.dtos.Instructor;
import com.university.uniBackend.dtos.Student;
import com.university.uniBackend.repository.CourseRepository;
import com.university.uniBackend.repository.DepartmentRepository;
import com.university.uniBackend.repository.InstructorRepository;
import com.university.uniBackend.repository.StudentRepository;
import com.university.uniBackend.services.CourseService;
import com.university.uniBackend.services.DepartmentService;
import com.university.uniBackend.services.InstructorService;
import com.university.uniBackend.services.StudentService;

@SpringBootTest
class UniBackendApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	CourseService courseService;
	@Autowired
	InstructorRepository instructorRepository;
	@Autowired
	InstructorService instructorService;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentService studentService;
	
	
	@Test
	void addAndGetDepartment() {
		
		Department dep = new Department("computer science");
        departmentService.addDepartment(dep);
       // assert(dep.getDeptName().equals("computer science"));
        assertThat(departmentRepository.findById(dep.getDeptId()));
    
	}
	
	@Test
	void addCourse() {
		Course course = new Course("programming 1");
		courseService.addCourse(course);
		assertThat(courseRepository.findById(course.getCourseId()));
	}
	
	@Test
	void addAndGetInstructor() {
		Instructor inst =  new Instructor("dr. tarek");
		instructorService.addInstructor(inst);
		Course course = new Course("programming 1", inst);
		courseService.addCourse(course);
		assert(inst.equals(course.getInstructor()));	
	}
	
	@Test
	void addStudent() {
		Student student = new Student("Ahmed");
		studentService.addStudent(student);
		Course course = new Course("math 2");
		course.addEnrolledStudents(student);
		courseService.addCourse(course);
		assert(course.getStudentEnrolled().contains(student));
	}
	
	

}
