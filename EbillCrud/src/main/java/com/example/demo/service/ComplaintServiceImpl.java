package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ComplaintRepository;
import com.example.demo.model.Complaint;

@Service
public class ComplaintServiceImpl implements ComplaintService {
	@Autowired
    private ComplaintRepository complaintRepository;

	@Override
	public List<Complaint> findByCustomerEmail(String email) {
		List<Complaint> complaints = complaintRepository.findByCustomerEmail(email);
	    System.out.println("complaints retrieved for email " + email + ": " + complaints);
	    return complaints;
	}

	@Override
	public List<Complaint> findByStatus(String status) {
		return complaintRepository.findByStatus(status);
	}
	
	@Override
	public void markComplaintAsResolved(Long complaintId) {
		Complaint complaint = complaintRepository.findById(complaintId).orElse(null);
        if (complaint != null) {
        	complaint.setStatus("Resolved");
            complaintRepository.save(complaint);
        }	
	}
	@Override
	public Complaint saveComplaint(Complaint complaint) {
		 return complaintRepository.save(complaint);
	}
}
