package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminRepository;
import com.example.demo.dao.BillRepository;
import com.example.demo.model.Admin;
import com.example.demo.model.Bill;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BillRepository billRepository;
    
	@Override
	public Admin findByEmailAndPassword(String email, String password) {
		 return adminRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public void addBill(Bill bill) {
		bill.setStatus("Pending");
		billRepository.save(bill);
	}
	
	public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public boolean isAdminExists(String email) {
        return adminRepository.existsByEmail(email);
    }

	@Override
	public List<Bill> getAllBills() {
	    return billRepository.findAll();

	}
	 
}
