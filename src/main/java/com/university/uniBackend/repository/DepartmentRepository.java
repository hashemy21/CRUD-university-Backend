package com.university.uniBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.uniBackend.dtos.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{

}
