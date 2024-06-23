package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Complaint;

public interface ComplaintService {
	List<Complaint> findByCustomerEmail(String email);
    List<Complaint> findByStatus(String status);
    void markComplaintAsResolved(Long complaintId);
    Complaint saveComplaint(Complaint complaint);
    
}
