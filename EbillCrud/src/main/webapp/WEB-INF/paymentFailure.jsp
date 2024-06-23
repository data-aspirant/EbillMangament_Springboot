<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Failure</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;">
    <div style="width: 100%; max-width: 400px; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); box-sizing: border-box; text-align: center;">
        <h1 style="color: #f44336;">Payment Failed</h1>
        <p>Your payment could not be processed. Please try again.</p>
        <a href="${pageContext.request.contextPath}/viewBills" style="display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 4px;">Return to Bills</a>
    </div>
</body>
</html>
