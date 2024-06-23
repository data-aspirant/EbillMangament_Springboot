package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BillRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Bill;
import com.example.demo.model.Customers;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private BillRepository billRepository;
	@Override
	public void saveCustomer(Customers customer) {
		customerRepository.save(customer);
	}
	@Override
	public Customers findByEmailAndPassword(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password);
    }
	@Override
	public List<Bill> findBillsByCustomerEmail(String email) {
	    List<Bill> bills = billRepository.findByCustomerEmail(email);
	    System.out.println("Bills retrieved for email " + email + ": " + bills);
	    return bills;
    }
		@Override
    public Customers findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
		
//	    public void markBillAsPaid(Long billId, String userEmail) {
//			Bill bill = billRepository.findById(billId).orElse(null);
//	        if (bill != null) {
//	            logger.info("Before marking bill {} as Paid, status: {}", billId, bill.getStatus());
//	            bill.setStatus("Paid");
//	            billRepository.save(bill);
//	            logger.info("After marking bill {} as Paid, status: {}", billId, bill.getStatus());
//	        } else {
//	            logger.warn("Bill with ID {} not found.", billId);
//	        }
//		}
		@Override
		public void markBillAsPaid(Long billId) {
		    Bill bill = billRepository.findById(billId).orElse(null);
		    if (bill != null) {
		        // Update status to "Paid"
		        bill.setStatus("Paid");
		        billRepository.save(bill); // Save updated bill
		    }
		}
		@Override
	    public Bill findBillById(Long billId) {
	        // Implement logic to find a Bill by its ID
	        return billRepository.findById(billId).orElse(null);
	    }

//	    @Transactional
//	    public boolean markBillAsPaid(Long[] billIds, String cardNumber, String expiryDate, String cvv, String userEmail) {
//			 logger.info("Processing payment for bills: {}", Arrays.toString(billIds));
//		        logger.info("Card details - Card Number: {}, Expiry Date: {}, CVV: {}", cardNumber, expiryDate, cvv);
//		        logger.info("User email: {}", userEmail);
//
//		        // Validate card details
//		        if (!isValidCardDetails(cardNumber, expiryDate, cvv)) {
//		            logger.warn("Invalid card details provided.");
//		            return false; // Handle invalid card details
//		        }
//
//		        for (Long billId : billIds) {
//		            Bill bill = billRepository.findById(billId).orElse(null);
//		            if (bill != null && !bill.getStatus().equals("Paid")) {
//		                logger.info("Before marking bill {} as Paid, status: {}", billId, bill.getStatus());
//		                bill.setStatus("Paid");
//		                billRepository.save(bill); // Ensure save/update operation within a transaction
//		                logger.info("After marking bill {} as Paid, status: {}", billId, bill.getStatus());
//		            } else {
//		                logger.warn("Bill with ID {} not found or already paid.", billId);
//		            }
//		        }
//		        return true; // Payment process successful
//		    }
//
//		    private boolean isValidCardDetails(String cardNumber, String expiryDate, String cvv) {
//		        return "1234567890123456".equals(cardNumber) &&
//		               "12/25".equals(expiryDate) &&
//		               "123".equals(cvv);
//		    }
		@Override
	    public List<Bill> findPaidBillsByCustomerEmail(String email) {
	        return billRepository.findByCustomerEmailAndStatus(email, "Paid");
	    }
		
		
	
}
