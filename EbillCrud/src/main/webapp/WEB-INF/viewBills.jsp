<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.Bill" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>List of Bills</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; flex-direction: column; align-items: center; padding: 20px;">
    <div style="width: 100%; max-width: 800px; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); box-sizing: border-box;">
        <h1 style="text-align: center;">List of Bills for <%= request.getAttribute("email") %></h1>

        <% List<Bill> bills = (List<Bill>) request.getAttribute("bills"); %>

        <% if (bills != null && !bills.isEmpty()) { %>
            <form id="billsForm" action="${pageContext.request.contextPath}/setSelectedBills" method="post">
                <table border="1" style="width: 100%; border-collapse: collapse; margin-top: 20px;">
                    <thead>
                        <tr>
                            <th style="padding: 8px; border: 1px solid #ccc;">Select</th>
                            <th style="padding: 8px; border: 1px solid #ccc;">Bill ID</th>
                            <th style="padding: 8px; border: 1px solid #ccc;">Customer Email</th>
                            <th style="padding: 8px; border: 1px solid #ccc;">Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Bill bill : bills) { %>
                            <% if (!"Paid".equals(bill.getStatus())) { %>
                                <tr>
                                    <td style="padding: 8px; border: 1px solid #ccc; text-align: center;"><input type="checkbox" name="billIds" value="<%= bill.getId() %>" /></td>
                                    <td style="padding: 8px; border: 1px solid #ccc; text-align: center;"><%= bill.getId() %></td>
                                    <td style="padding: 8px; border: 1px solid #ccc; text-align: center;"><%= bill.getCustomerEmail() %></td>
                                    <td style="padding: 8px; border: 1px solid #ccc; text-align: center;"><%= bill.getAmount() %></td>
                                </tr>
                            <% } %>
                        <% } %>
                    </tbody>
                </table>
                <% boolean enablePayNow = bills.stream().anyMatch(bill -> !"Paid".equals(bill.getStatus())); %>
                <button type="submit" style="width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; margin-top: 20px;" <% if (!enablePayNow) { %> disabled style="background-color: #ccc; cursor: not-allowed;" <% } %>>Proceed to Checkout</button>
            </form>
        <% } else { %>
            <p style="text-align: center; margin-top: 20px;">There are no bills.</p>
        <% } %>

        <p style="text-align: center; margin-top: 20px;">
            <a href="${pageContext.request.contextPath}/billHistory" style="margin-right: 10px; color: #4CAF50; text-decoration: none;">View Paid Bills</a>
            <a href="${pageContext.request.contextPath}/addComplaint" style="margin-right: 10px; color: #4CAF50; text-decoration: none;">Add Complaints</a>
            <a href="${pageContext.request.contextPath}/complaints" style="color: #4CAF50; text-decoration: none;">View Complaints</a>
        </p>
        <form action="/logout" method="get" style="margin-top: 20px;">
            <button type="submit" style="width: 100%; padding: 10px; background-color: #f44336; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Logout</button>
        </form>
    </div>
</body>
</html>
