package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
	Customers findByEmailAndPassword(String email, String password);
	 Customers findByEmail(String email);
}
