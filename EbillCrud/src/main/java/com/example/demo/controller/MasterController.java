package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Bill;
import com.example.demo.model.Complaint;
import com.example.demo.model.Customers;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MasterController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ComplaintService complaintService;
    
    private static final Logger logger = LoggerFactory.getLogger(MasterController.class);

    @GetMapping("/register")
    public ModelAndView showRegistrationForm() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("customer", new Customers());
        return mav;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute("customer") Customers customer) {
        customerService.saveCustomer(customer);
        ModelAndView mav = new ModelAndView("acknowledgement");
        mav.addObject("customer", customer);
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        return new ModelAndView("Login");
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Customers customer = customerService.findByEmailAndPassword(email, password);
        if (customer != null) {
            List<Bill> bills = customerService.findBillsByCustomerEmail(email);
            ModelAndView mav = new ModelAndView("viewBills");
            mav.addObject("bills", bills);
            mav.addObject("email", email); // Add email as an attribute

            // Store email in session for further use
            session.setAttribute("loggedInUserEmail", email);
            System.out.println("User logged in with email: " + email); // Log the email being set in session
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("error", "Invalid email or password");
            return mav;
        }
    }    
    @GetMapping("/checkout")
    public ModelAndView showCheckoutPage() {
        return new ModelAndView("checkout");
    }
    @PostMapping("/setSelectedBills")
    public String setSelectedBills(@RequestParam("billIds") Long[] billIds, HttpSession session) {
        session.setAttribute("selectedBillIds", billIds);
        return "redirect:/checkout";
    }

    @PostMapping("/processCheckout")
    public ModelAndView processCheckout(@RequestParam("cardNumber") String cardNumber,
                                         @RequestParam("cvv") String cvv,
                                         HttpSession session) {
        // Validate cardNumber and cvv
        if ("123456".equals(cardNumber) && "123".equals(cvv)) {
            // Retrieve selected bills from session or database
            Long[] billIds = (Long[]) session.getAttribute("selectedBillIds");

            // Update status of selected bills to "Paid"
            if (billIds != null) {
                // Update status of selected bills to "Paid"
                for (Long billId : billIds) {
                    customerService.markBillAsPaid(billId);
                }
                return new ModelAndView("paymentSuccess");
            } else {
                return new ModelAndView("paymentFailure").addObject("message", "No bills selected for payment.");
            }
        } else {
            return new ModelAndView("paymentFailure").addObject("message", "Invalid card details.");
        }
    }



//    @PostMapping("/payBills")
//    public ModelAndView payBills(@RequestParam(name = "billIds", required = false) Long[] billIds, HttpSession session) {
//        if (billIds == null || billIds.length == 0) {
//            ModelAndView mav = new ModelAndView("viewBills");
//            String email = (String) session.getAttribute("loggedInUserEmail");
//            List<Bill> bills = customerService.findBillsByCustomerEmail(email);
//            mav.addObject("bills", bills);
//            mav.addObject("error", "There are no bills to pay.");
//            logger.warn("No bills selected for payment.");
//            return mav;
//        }
//        logger.info("Bills selected for payment: " + Arrays.toString(billIds));
//
//        // Redirect to checkout page with selected bill IDs
//        ModelAndView mav = new ModelAndView("checkout");
//        mav.addObject("billIds", billIds);
//        return mav;
//    }
//    @PostMapping("/processPayment")
//    public ModelAndView processPayment(@RequestParam(name = "billIds", required = false) Long[] billIds, HttpSession session) {
//        logger.info("Process Payment initiated.");
//
//        if (billIds == null || billIds.length == 0) {
//            logger.warn("No bills selected for payment.");
//            String email = (String) session.getAttribute("loggedInUserEmail");
//            List<Bill> bills = customerService.findBillsByCustomerEmail(email);
//            logger.info("Bills retrieved for email {}: {}", email, bills);
//
//            ModelAndView mav = new ModelAndView("viewBills");
//            mav.addObject("bills", bills);
//            mav.addObject("error", "No bills selected for payment.");
//            return mav;
//        }
//        logger.info("Bill IDs received for payment: {}", Arrays.toString(billIds));
//
//        // Process the selected bills
//        for (Long billId : billIds) {
//            customerService.markBillAsPaid(billId);
//        }
//        logger.info("Bills marked as paid successfully.");
//
//        // Redirect to payment success page or another appropriate page
//        ModelAndView mav = new ModelAndView("redirect:/paymentSuccess");
//        return mav;
//    }
//    @PostMapping("/processPayment")
//    public ModelAndView processPayment(@RequestParam(name = "billIds") Long[] billIds, @RequestParam String cardNumber, @RequestParam String expiryDate, @RequestParam String cvv,HttpSession session) {
//    	 logger.info("Payment process initiated.");
//
//         String userEmail = (String) session.getAttribute("loggedInUserEmail");
//         logger.info("User email retrieved from session: {}", userEmail);
//
//         boolean paymentSuccessful = customerService.markBillAsPaid(billIds, cardNumber, expiryDate, cvv, userEmail);
//
//         if (paymentSuccessful) {
//             logger.info("Payment successful. Redirecting to bill history.");
//             return new ModelAndView("redirect:/billHistory");
//         } else {
//             logger.warn("Payment failed. Redirecting to payment failure page.");
//             ModelAndView mav = new ModelAndView("paymentFailure");
//             mav.addObject("message", "Payment processing failed. Please check your card details.");
//             return mav;
//         }
//    }
    @GetMapping("/complaints")
    public ModelAndView showComplaints(HttpSession session) {
        String email = (String) session.getAttribute("loggedInUserEmail");
        List<Complaint> complaints = complaintService.findByCustomerEmail(email);
        ModelAndView mav = new ModelAndView("viewComplaints");
        mav.addObject("complaints", complaints);
        mav.addObject("email", email); // Optional: add email for display purposes
        return mav;
    }


    @PostMapping("/submitComplaint")
    public ModelAndView submitComplaint(@RequestParam String name, @RequestParam String description, HttpSession session) {
        String email = (String) session.getAttribute("loggedInUserEmail");
        if (email == null) {
            // Log error and show error message to the user
            System.out.println("Error: User email not found in session");
            return new ModelAndView("error").addObject("message", "User email not found in session");
        }
        Complaint complaint = new Complaint();
        complaint.setName(name);
        complaint.setDiscription(description); // Ensure correct method name
        complaint.setStatus("Pending");
        complaint.setCustomerEmail(email);
        complaintService.saveComplaint(complaint);
        return new ModelAndView("redirect:/complaints"); // Redirect to GET endpoint
    }

    @GetMapping("/addComplaint")
    public String showAddComplaintForm(Model model) {
        // Add any necessary model attributes here
        return "AddComplaint"; // This should match the name of your JSP file without the extension
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate session
        }
        return "redirect:/login"; // Redirect to login page
    }
    @GetMapping("/gotoviewbill")
    public ModelAndView goToViewBills(HttpSession session) {
        ModelAndView mav = new ModelAndView("viewBills");

        String email = (String) session.getAttribute("loggedInUserEmail");
        logger.info("Retrieved email from session: {}", email); // Log the email retrieved from session

        if (email != null) {
            List<Bill> bills = customerService.findBillsByCustomerEmail(email);
            mav.addObject("bills", bills);
            mav.addObject("email", email); // Add email as an attribute
        } else {
            logger.error("No logged-in user found in session.");
            mav.addObject("error", "No logged-in user found.");
            mav.addObject("bills", null); // Ensure bills attribute is always set, even if empty
        }

        return mav;
    }
    @GetMapping("/billHistory")
    public ModelAndView showBillHistoryPage(HttpSession session) {
        ModelAndView mav = new ModelAndView("billHistory");

        String email = (String) session.getAttribute("loggedInUserEmail");
        logger.info("Retrieved email from session for bill history: {}", email); // Log the email retrieved from session

        if (email != null) {
            List<Bill> paidBills = customerService.findPaidBillsByCustomerEmail(email);
            logger.debug("Paid bills for {}: {}", email, paidBills);
            mav.addObject("bills", paidBills); // Change attribute name to "bills"
            mav.addObject("email", email); // Add email as an attribute for display purposes
        } else {
            logger.error("No logged-in user found in session.");
            mav.addObject("error", "No logged-in user found.");
            mav.addObject("bills", null); // Ensure bills attribute is always set, even if empty
        }

        return mav;
    }

}
