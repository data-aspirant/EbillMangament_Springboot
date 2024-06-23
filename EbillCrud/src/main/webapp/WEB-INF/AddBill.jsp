<!DOCTYPE html>
<html>
<head>
    <title>Add Bill</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;">
    <div style="width: 100%; max-width: 400px; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); box-sizing: border-box;">
        <h1 style="text-align: center;">Add Bill</h1>
        <form action="${pageContext.request.contextPath}/admin/addBill" method="post">
            <label for="customerEmail" style="display: block; margin-bottom: 8px; font-weight: bold;">Customer Email:</label>
            <input type="email" id="customerEmail" name="customerEmail" required style="width: 100%; padding: 8px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;"/><br/>

            <label for="amount" style="display: block; margin-bottom: 8px; font-weight: bold;">Amount:</label>
            <input type="number" id="amount" name="amount" step="0.01" required style="width: 100%; padding: 8px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;"/><br/>

            <button type="submit" style="width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Add Bill</button>
        </form>
        
        <c:if test="${not empty message}">
            <p style="color: green; text-align: center; margin-top: 20px;">${message}</p>
        </c:if>
        <form action="/adminlogout" method="get" style="margin-top: 20px;">
            <button type="submit" style="width: 100%; padding: 10px; background-color: #f44336; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Logout</button>
        </form>
        <form action="${pageContext.request.contextPath}/admin/changeComplaintStatus" method="get" style="margin-top: 20px;">
            <button type="submit" style="width: 100%; padding: 10px; background-color: #008CBA; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Change Complaint Status</button>
        </form>
    </div>
</body>
</html>
