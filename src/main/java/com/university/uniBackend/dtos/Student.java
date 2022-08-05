package com.university.uniBackend.dtos;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String stduentName;
	
	
    @ManyToMany
    @JoinTable(name="COURSES_ENROLLED_BY_STUDENTS",
 		   joinColumns=@JoinColumn(name="STUDENT_ID"),
 		   inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private List <Course> coursesEnrolled= new ArrayList<>();
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", stduentName=" + stduentName + ", coursesEnrolled="
				+ coursesEnrolled + "]";
	}


	public Student(String stduentName, List<Course> coursesEnrolled) {
		this.stduentName = stduentName;
		this.coursesEnrolled = coursesEnrolled;
	}


	public Student(String stduentName) {
		this.stduentName = stduentName;
	}
	
	public void EnrolledCourses(Course course){
		coursesEnrolled.add(course);
	}
	
	
}
