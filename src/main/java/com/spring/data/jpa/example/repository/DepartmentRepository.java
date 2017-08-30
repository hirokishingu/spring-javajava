package com.spring.data.jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.example.repository.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
