package com.university.uniBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.uniBackend.dtos.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{

}
