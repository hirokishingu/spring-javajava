package com.spring.data.jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.example.repository.entity.Authentication;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, String>{

}
