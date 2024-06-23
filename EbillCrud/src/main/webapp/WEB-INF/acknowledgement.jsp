<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acknowledgement</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;">
    <div style="width: 100%; max-width: 600px; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); box-sizing: border-box; text-align: center;">
        <h1 style="color: #4CAF50;">Acknowledgement</h1>
        <div class="info-box" id="info-box" style="padding: 20px; border: 1px solid #ccc; border-radius: 8px; margin-top: 20px;">
            <div class="title-div" style="margin-bottom: 20px;">
                <p class="main-heading" style="font-size: 24px; font-weight: bold;">Registration Successful</p>
            </div>
            <div class="content-div">
                <p>Thank you for registering, <strong>${customer.name}</strong>!</p>
                <p>Your user ID is: <strong>${customer.userId}</strong></p>
                <p>An email has been sent to: <strong>${customer.email}</strong></p>
                <br>
                <a href="${pageContext.request.contextPath}/login" style="text-decoration: none; background-color: #4CAF50; color: white; padding: 10px 20px; border-radius: 4px; display: inline-block; margin-top: 20px;">Go to Customer Login Page</a>
            </div>
        </div>
    </div>
</body>
</html>
