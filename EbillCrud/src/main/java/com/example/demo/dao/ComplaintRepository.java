package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
	List<Complaint> findByCustomerEmail(String email);
	List<Complaint> findByStatus(String status);
}
