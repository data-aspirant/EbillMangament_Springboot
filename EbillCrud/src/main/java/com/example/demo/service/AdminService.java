package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admin;
import com.example.demo.model.Bill;

public interface AdminService {
	Admin findByEmailAndPassword(String email, String password);
	void addBill(Bill bill);
	void saveAdmin(Admin admin);
	boolean isAdminExists(String email);
    List<Bill> getAllBills();

}
