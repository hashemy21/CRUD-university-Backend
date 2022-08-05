package com.university.uniBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.uniBackend.dtos.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer>{

}
