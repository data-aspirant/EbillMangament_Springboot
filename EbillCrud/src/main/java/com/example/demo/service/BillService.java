package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Bill;

public interface BillService {
	 List<Bill> getAllBills();
	 List<Bill> getBillsByIds(List<Long> ids);
	    Bill saveBill(Bill bill);
	    void deleteBill(Long id);
}
