<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;">
    <div style="width: 100%; max-width: 400px; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); box-sizing: border-box;">
        <h1 style="text-align: center;">Admin Login</h1>
        <form action="${pageContext.request.contextPath}/AdminLogin" method="post">
            <label for="email" style="display: block; margin-bottom: 8px; font-weight: bold;">Email:</label>
            <input type="email" id="email" name="email" required style="width: 100%; padding: 8px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;"/><br/>

            <label for="password" style="display: block; margin-bottom: 8px; font-weight: bold;">Password:</label>
            <input type="password" id="password" name="password" required style="width: 100%; padding: 8px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;"/><br/>

            <button type="submit" style="width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Login</button>
        </form>
        <c:if test="${not empty error}">
            <p style="color: red; text-align: center; margin-top: 20px;">${error}</p>
        </c:if>
        <p style="text-align: center; margin-top: 20px;">
            Are you a customer? <a href="${pageContext.request.contextPath}/login" style="color: #4CAF50; text-decoration: none;">Customer Login here</a>
        	<br>
            Not yet registered? <a href="${pageContext.request.contextPath}/adminRegister" style="color: #4CAF50; text-decoration: none;">Register here</a>
        </p>
    </div>
</body>
</html>
