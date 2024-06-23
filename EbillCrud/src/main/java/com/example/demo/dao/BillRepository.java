package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByCustomerEmail(String email);
    List<Bill> findByCustomerEmailAndStatus(String email, String status);
}
