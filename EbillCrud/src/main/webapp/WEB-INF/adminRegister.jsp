<!DOCTYPE html>
<html>
<head>
    <title>Admin Registration</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f2f2f2; margin: 0; padding: 20px; display: flex; justify-content: center; align-items: center; height: 100vh;">

    <div style="max-width: 400px; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">

        <h1 style="text-align: center; color: #333;">Admin Registration</h1>

        <form action="${pageContext.request.contextPath}/adminRegister" method="post" style="margin-top: 20px;">

            <label for="email" style="display: block; margin-bottom: 10px; font-weight: bold; color: #333;">Email:</label>
            <input type="email" id="email" name="email" style="width: calc(100% - 22px); padding: 8px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; font-size: 16px;" required/><br/>

            <label for="password" style="display: block; margin-bottom: 10px; font-weight: bold; color: #333;">Password:</label>
            <input type="password" id="password" name="password" style="width: calc(100% - 22px); padding: 8px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; font-size: 16px;" required/><br/>

            <button type="submit" style="display: block; margin: 0 auto; padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Register</button>
        
        </form>

        <c:if test="${not empty error}">
            <p style="color:red; text-align:center; margin-top: 10px;">${error}</p>
        </c:if>

        <p style="text-align:center; margin-top: 20x;">
            Already Registered? <a style="color:#4CAF50; text-decoration: none;" href="${pageContext.request.contextPath}/AdminLogin"> Go to Admin login page</a>
            <br>
            Are you a customer? <a href="${pageContext.request.contextPath}/login" style="color:#4CAF50; text-decoration:none;">Login here</a>
        </p>

    </div>

</body>
</html>
