package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Bill;
import com.example.demo.model.Customers;

public interface CustomerService {
	void saveCustomer(Customers customer);
	Customers findByEmailAndPassword(String email, String password);
	List<Bill> findBillsByCustomerEmail(String email);
	Customers findByEmail(String email);
    List<Bill> findPaidBillsByCustomerEmail(String email);
//    boolean markBillAsPaid(Long[] billIds, String cardNumber, String expiryDate, String cvv, String userEmail);
    void markBillAsPaid(Long billId);
    Bill findBillById(Long billId);
    
}
