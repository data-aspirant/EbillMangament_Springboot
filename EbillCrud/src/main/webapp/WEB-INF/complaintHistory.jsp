<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.Complaint" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Complaint History</title>
</head>
<body>
    <h1>Complaint History</h1>

    <% List<Complaint> complaints = (List<Complaint>) request.getAttribute("complaints"); %>
    <% if (complaints != null && !complaints.isEmpty()) { %>
        <table border="1">
            <thead>
                <tr>
                    <th>Complaint ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <% for (Complaint complaint : complaints) { %>
                    <tr>
                        <td><%= complaint.getId() %></td>
                        <td><%= complaint.getName() %></td>
                        <td><%= complaint.getDiscription() %></td>
                        <td><%= complaint.getStatus() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <p>No resolved complaints found.</p>
    <% } %>
</body>
</html>
