package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.BillRepository;
import com.example.demo.model.Bill;

public class BillServiceImpl implements BillService {
	
	  @Autowired
	    private BillRepository billRepository;


	@Override
	public List<Bill> getAllBills() {
		 return billRepository.findAll();
	}

	@Override
    public List<Bill> getBillsByIds(List<Long> ids) {
        return billRepository.findAllById(ids);
    }

	@Override
	public Bill saveBill(Bill bill) {
		 return billRepository.save(bill);
	}

	@Override
	public void deleteBill(Long id) {
		  billRepository.deleteById(id);
	}

}
