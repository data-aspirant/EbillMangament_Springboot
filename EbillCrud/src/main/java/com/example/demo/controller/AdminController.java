package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Admin;
import com.example.demo.model.Bill;
import com.example.demo.model.Complaint;
import com.example.demo.service.AdminService;
import com.example.demo.service.ComplaintService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private ComplaintService complaintService;

    @GetMapping("/adminRegister")
    public ModelAndView showAdminRegistrationForm() {
        return new ModelAndView("adminRegister", "admin", new Admin());
    }

    @PostMapping("/adminRegister")
    public ModelAndView registerAdmin(@ModelAttribute("admin") Admin admin) {
        if (adminService.isAdminExists(admin.getEmail())) {
            ModelAndView mav = new ModelAndView("adminRegister");
            mav.addObject("error", "Admin with this email already exists");
            return mav;
        }
        adminService.saveAdmin(admin);
        ModelAndView mav = new ModelAndView("adminAcknowledgement");
        mav.addObject("admin", admin);
        return mav;
    }

    @GetMapping("/AdminLogin")
    public ModelAndView showAdminLoginForm() {
        return new ModelAndView("AdminLogin");
    }

    @PostMapping("/AdminLogin")
    public ModelAndView loginAdmin(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Admin admin = adminService.findByEmailAndPassword(email, password);
        if (admin != null) {
            session.setAttribute("loggedInAdminEmail", email); // Set session attribute
            ModelAndView mav = new ModelAndView("AddBill");
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("AdminLogin");
            mav.addObject("error", "Invalid email or password");
            return mav;
        }
    }
    @GetMapping("/admin/addBill")
    public ModelAndView showAddBillForm(HttpSession session) {
        String email = (String) session.getAttribute("loggedInAdminEmail");
        if (email == null) {
            return new ModelAndView("AdminLogin").addObject("error", "Please login first.");
        }
        return new ModelAndView("AddBill");
    }

    @PostMapping("/admin/addBill")
    public ModelAndView addBill(@ModelAttribute Bill bill, HttpSession session) {
        String email = (String) session.getAttribute("loggedInAdminEmail");
        if (email == null) {
            // Handle the case where the admin is not logged in or session has expired
            ModelAndView mav = new ModelAndView("AdminLogin");
            mav.addObject("error", "Please login first.");
            return mav;
        }

        adminService.addBill(bill);
        ModelAndView mav = new ModelAndView("AddBill");
        mav.addObject("message", "Bill added successfully");
        return mav;
    }

    @GetMapping("/admin/viewBills")
    public ModelAndView viewBills(HttpSession session) {
        String email = (String) session.getAttribute("loggedInAdminEmail");
        if (email == null) {
            // Handle the case where the admin is not logged in or session has expired
            ModelAndView mav = new ModelAndView("AdminLogin");
            mav.addObject("error", "Please login first.");
            return mav;
        }
        List<Bill> bills = adminService.getAllBills();
        ModelAndView mav = new ModelAndView("viewBills");
        mav.addObject("bills", bills);
        return mav;
    }

    @GetMapping("/adminlogout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate session
        }
        return "redirect:/AdminLogin"; // Redirect to login page
    }

    @GetMapping("/admin/changeComplaintStatus")
    public ModelAndView showChangeComplaintStatus(HttpSession session) {
        String email = (String) session.getAttribute("loggedInAdminEmail");
        if (email == null) {
            return new ModelAndView("AdminLogin").addObject("error", "Please login first.");
        }
        List<Complaint> complaints = complaintService.findByStatus("Pending");
        ModelAndView mav = new ModelAndView("changeComplaintStatus");
        mav.addObject("complaints", complaints);
        return mav;
    }

    @PostMapping("/admin/updateComplaintStatus")
    public ModelAndView updateComplaintStatus(@RequestParam(required = false) Long[] complaintIds, HttpSession session) {
        String email = (String) session.getAttribute("loggedInAdminEmail");
        if (email == null) {
            return new ModelAndView("AdminLogin").addObject("error", "Please login first.");
        }
        if (complaintIds != null && complaintIds.length > 0) {
            for (Long complaintId : complaintIds) {
                complaintService.markComplaintAsResolved(complaintId);
            }
        }
        return new ModelAndView("redirect:/admin/changeComplaintStatus");
    }

    @GetMapping("/admin/complaintHistory")
    public ModelAndView showComplaintHistory(HttpSession session) {
        String email = (String) session.getAttribute("loggedInAdminEmail");
        if (email == null) {
            return new ModelAndView("AdminLogin").addObject("error", "Please login first.");
        }
        List<Complaint> resolvedComplaints = complaintService.findByStatus("Resolved");
        ModelAndView mav = new ModelAndView("complaintHistory");
        mav.addObject("complaints", resolvedComplaints);
        return mav;
    }
}
