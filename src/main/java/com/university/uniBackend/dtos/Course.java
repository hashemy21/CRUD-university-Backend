package com.university.uniBackend.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CourseId;
	private String courseName;
	
	@ManyToOne
    @JoinColumn(name="InstructorId")
	private Instructor instructor;
	
	@ManyToOne
	@JoinColumn(name="deptId")
	private Department departmentBelongsTo;
	
	@ManyToMany(mappedBy = "coursesEnrolled")
	private List <Student> studentEnrolled= new ArrayList<>();
	
	@Override
	public String toString() {
		return "Course [CourseId=" + CourseId + ", courseName=" + courseName + ", instructor=" + instructor
				+ ", studentEnrolled=" + studentEnrolled + "]";
	}

	public Course( String courseName, Instructor instructor, Department departmentBelongsTo,
			List<Student> studentEnrolled) {
		this.courseName = courseName;
		this.instructor = instructor;
		this.departmentBelongsTo = departmentBelongsTo;
		this.studentEnrolled = studentEnrolled;
	}

	public Course(String courseName, Department departmentBelongsTo) {
		this.courseName = courseName;
		this.departmentBelongsTo = departmentBelongsTo;
	}
	
	
	 public void addEnrolledStudents(Student student){
		 studentEnrolled.add(student);
	    }

	 
	 
	public Course(String courseName) {
		this.courseName = courseName;
	}

	public Course(String courseName, Instructor instructor, Department departmentBelongsTo) {
		this.courseName = courseName;
		this.instructor = instructor;
		this.departmentBelongsTo = departmentBelongsTo;
	}

	public Course(String courseName, Instructor instructor) {
		this.courseName = courseName;
		this.instructor = instructor;
	}

	public Course() {
	}
	
}
