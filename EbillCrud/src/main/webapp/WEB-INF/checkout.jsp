<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;">
    <div style="width: 100%; max-width: 400px; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); box-sizing: border-box; text-align: center;">
        <h1 style="color: #4CAF50;">Checkout</h1>
        <form action="${pageContext.request.contextPath}/processCheckout" method="post">
            <label for="cardNumber" style="display: block; margin-bottom: 8px; font-weight: bold;">Card Number:</label>
            <input type="text" id="cardNumber" name="cardNumber" required style="width: calc(100% - 20px); padding: 8px; margin-bottom: 12px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; font-size: 16px;">

            <label for="cvv" style="display: block; margin-bottom: 8px; font-weight: bold;">CVV:</label>
            <input type="text" id="cvv" name="cvv" required style="width: calc(100% - 20px); padding: 8px; margin-bottom: 12px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; font-size: 16px;">

            <button type="submit" style="width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Proceed to Payment</button>
        </form>
    </div>
</body>
</html>
