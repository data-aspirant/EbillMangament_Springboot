package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByEmailAndPassword(String email, String password);
	boolean existsByEmail(String email);
}
