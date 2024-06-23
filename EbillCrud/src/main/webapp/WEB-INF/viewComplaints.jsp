<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.Complaint" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Complaints</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; flex-direction: column; align-items: center; padding: 20px;">
    <div style="width: 100%; max-width: 600px; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); box-sizing: border-box;">
        <h1 style="text-align: center;">Complaints for <%= session.getAttribute("loggedInUserEmail") %></h1>

        <% List<Complaint> complaints = (List<Complaint>) request.getAttribute("complaints"); %>

        <% if (complaints != null && !complaints.isEmpty()) { %>
            <table border="1" style="width: 100%; border-collapse: collapse; margin-top: 20px;">
                <thead>
                    <tr>
                        <th style="padding: 8px; border: 1px solid #ccc;">Complaint ID</th>
                        <th style="padding: 8px; border: 1px solid #ccc;">Name</th>
                        <th style="padding: 8px; border: 1px solid #ccc;">Description</th>
                        <th style="padding: 8px; border: 1px solid #ccc;">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Complaint complaint : complaints) { %>
                        <tr>
                            <td style="padding: 8px; border: 1px solid #ccc; text-align: center;"><%= complaint.getId() %></td>
                            <td style="padding: 8px; border: 1px solid #ccc; text-align: center;"><%= complaint.getName() %></td>
                            <td style="padding: 8px; border: 1px solid #ccc; text-align: center;"><%= complaint.getDiscription() %></td>
                            <td style="padding: 8px; border: 1px solid #ccc; text-align: center;"><%= complaint.getStatus() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } else { %>
            <p style="text-align: center; margin-top: 20px;">No complaints found.</p>
        <% } %>
        
        <!-- Links side by side with adjusted margins -->
        <div style="display: flex; justify-content: space-between; margin-top: 20px;">
            <a href="${pageContext.request.contextPath}/complaints" style="text-decoration: none; color: #4CAF50; margin-left:40px">View Complaints</a>
             <a href="${pageContext.request.contextPath}/addComplaint" style="text-decoration: none; color: #4CAF50; margin-right:8px">Add Complaints</a>        
            <a href="${pageContext.request.contextPath}/gotoviewbill" style="text-decoration: none; color: #4CAF50; margin-right:100px">Pay Bills</a>
        </div>

        <form action="/logout" method="get" style="margin-top: 20px;">
            <button type="submit" style="width: 100%; padding: 10px; background-color: #f44336; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Logout</button>
        </form>
    </div>
</body>
</html>
