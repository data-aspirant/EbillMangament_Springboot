package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Bill;
import com.example.demo.service.BillService;

public class BillController {
	
	@Autowired
	private BillService billService;
	
	 @GetMapping("/")
	    public ModelAndView showHome() {
	        List<Bill> bills = billService.getAllBills();
	        ModelAndView mav = new ModelAndView("home");
	        mav.addObject("bills", bills);
	        return mav;
	    }

	    @PostMapping("/payment")
	    public ModelAndView proceedToPayment(@RequestParam("selectedBills") List<Long> selectedBillIds) {
	        List<Bill> selectedBills = billService.getBillsByIds(selectedBillIds);
	        ModelAndView mav = new ModelAndView("payment");
	        mav.addObject("selectedBills", selectedBills);
	        return mav;
	    }

	    @PostMapping("/checkout")
	    public ModelAndView proceedToCheckout(@RequestParam("selectedBills") List<Long> selectedBillIds) {
	        ModelAndView mav = new ModelAndView("checkout");
	        mav.addObject("selectedBills", selectedBillIds);
	        return mav;
	    }

	    @PostMapping("/finalizeCheckout")
	    public ModelAndView finalizeCheckout(@RequestParam("cardNumber") String cardNumber,
	                                         @RequestParam("cardExpiry") String cardExpiry,
	                                         @RequestParam("cardCVV") String cardCVV,
	                                         @RequestParam("selectedBills") List<Long> selectedBillIds) {
	        ModelAndView mav;
	        // Validate card details
	        if ("1234567890123".equals(cardNumber) && "2024".equals(cardExpiry) && "123".equals(cardCVV)) {
	            mav = new ModelAndView("paymentSuccess");  // Redirect to a success page
	        } else {
	            mav = new ModelAndView("paymentFailure");  // Redirect to a failure page
	        }
	        return mav;
	    }
}
