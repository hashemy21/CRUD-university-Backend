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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deptId;
	
	private String deptName;
	
	@OneToOne
	private Instructor headOfDepartment;
	
	@OneToMany(mappedBy="departmentBelongsTo")
	private List <Course> coursesBelong = new ArrayList<>();
	
	
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", headOfDepartment=" + headOfDepartment
				+ ", coursesBelong=" + coursesBelong + "]";
	}


	public Department(String deptName, Instructor headOfDepartment, List<Course> coursesBelong) {
		this.deptName = deptName;
		this.headOfDepartment = headOfDepartment;
		this.coursesBelong = coursesBelong;
	}


	public Department(String deptName) {
		this.deptName = deptName;
	}

	public void addBelongingCourses(Course course){
		coursesBelong.add(course);
	    }


	public Department() {
		super();
	}
	
	
}
