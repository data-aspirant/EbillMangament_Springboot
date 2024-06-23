<!DOCTYPE html>
<html>
<head>
    <title>Add Complaint</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;">
    <div style="width: 100%; max-width: 400px; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); box-sizing: border-box;">
        <h1 style="text-align: center;">Add Complaint</h1>
        <form action="${pageContext.request.contextPath}/submitComplaint" method="post">
            <label for="name" style="display: block; margin-bottom: 8px; font-weight: bold;">Customer name:</label>
            <input type="text" id="name" name="name" required style="width: 100%; padding: 8px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;"/><br/>

            <label for="description" style="display: block; margin-bottom: 8px; font-weight: bold;">Description:</label>
            <input type="text" id="description" name="description" required style="width: 100%; padding: 8px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;"/><br/>

            <button type="submit" style="width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Add Complaint</button>
            
        </form>
        
        <!-- Links side by side -->
        <div style="display: flex; justify-content: space-between; margin-top: 20px; ">
            <a href="${pageContext.request.contextPath}/complaints" style="text-decoration: none; color: #4CAF50; padding-left:40px;">View Complaints</a>
			<br>
            <a href="${pageContext.request.contextPath}/gotoviewbill" style="text-decoration: none; color: #4CAF50;padding-right:40px;">Pay Bills</a>
        </div>

        <c:if test="${not empty message}">
            <p style="color: green; text-align: center; margin-top: 20px;">${message}</p>
        </c:if>
        
        <form action="/logout" method="get" style="margin-top: 20px;">
            <button type="submit" style="width: 100%; padding: 10px; background-color: #f44336; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Logout</button>
        </form>
    </div>
</body>
</html>
