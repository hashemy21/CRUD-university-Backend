package com.university.uniBackend.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int instId;
	
	private String instName;
	
    @OneToOne(mappedBy = "headOfDepartment")
	private Department headOFDepartemnt;
	
    @OneToMany(mappedBy = "instructor")
	private List <Course> coursesTaught= new ArrayList<>();
	
	@Override
	public String toString() {
		return "Instructor [instId=" + instId + ", instName=" + instName + ", instructor=" + headOFDepartemnt
				+ ", coursesTaught=" + coursesTaught + "]";
	}

	public Instructor(String instName, Department headOFDepartemnt, List<Course> coursesTaught) {
		this.instName = instName;
		this.headOFDepartemnt = headOFDepartemnt;
		this.coursesTaught = coursesTaught;
	}

	public Instructor(String instName) {
		this.instName = instName;
	}
	
	public void coursesTaught(Course course){
		coursesTaught.add(course);
	}

	public Instructor() {
		super();
	}
	
	
	
}
