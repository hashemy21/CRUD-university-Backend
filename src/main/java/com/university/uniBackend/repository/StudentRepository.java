package com.university.uniBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.uniBackend.dtos.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
