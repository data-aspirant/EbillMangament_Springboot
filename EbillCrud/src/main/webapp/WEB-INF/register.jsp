<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Registration</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }

    .info-box {
        width: 80%;
        max-width: 800px;
        margin: 20px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .title-div {
        text-align: center;
        margin-bottom: 20px;
    }

    .main-heading {
        font-size: 24px;
        font-weight: bold;
        color: #4CAF50;
    }

    form {
        margin-top: 20px;
    }

    .heading {
        font-size: 20px;
        font-weight: bold;
        color: #333;
    }

    .items {
        display: flex;
        justify-content: space-between;
        margin-bottom: 20px;
    }

    .left-items,
    .right-items {
        flex: 1;
    }

    .labels-and-inputs {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
    }

    .labels {
        width: 150px;
        text-align: right;
        padding-right: 20px; /* Adjust as needed */
    }

    .inputs {
        flex: 1;
    }

    input[type="text"],
    input[type="password"],
    input[type="number"],
    select {
        width: calc(100% - 10px);
        padding: 8px;
        margin-bottom: 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }

    input[type="tel"] {
        width: calc(100% - 10px);
        padding: 8px;
        margin-bottom: 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }

    button[type="submit"],
    button[type="reset"] {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }

    button[type="submit"]:hover,
    button[type="reset"]:hover {
        background-color: #45a049;
    }

    #progress-bar {
        display: none;
        text-align: center;
        margin-top: 20px;
    }

    .circular-progress {
        width: 50px;
        height: 50px;
    }

    .bg {
        fill: none;
        stroke: #ddd;
        stroke-width: 6;
        stroke-linecap: round;
    }

    .fg {
        fill: none;
        stroke: #4CAF50;
        stroke-width: 6;
        stroke-linecap: round;
        stroke-dasharray: 0, 1000;
        animation: progress 2s ease-out forwards;
    }

    @keyframes progress {
        0% {
            stroke-dasharray: 0, 1000;
        }

        100% {
            stroke-dasharray: 1000, 0;
        }
    }

    .buttons {
        text-align: center;
        margin-top: 20px;
    }

    a {
        text-decoration: none;
        color: dodgerblue;
    }

    a:hover {
        text-decoration: underline;
    }

    p {
        margin-top: 10px;
    }
</style>

</head>

<body>
	<div class="info-box" id="info-box">
		<div class="title-div">
			<p class="main-heading">Register New Customer</p>
		</div>

		<form id="registration-form" action="${pageContext.request.contextPath}/register" modelAttribute="customer" method="post">
			<!-- Consumer Details div -->
			<div class="consumer-details">
				<h3 class="heading">Consumer Details</h3>
				<br />
				<hr />
				<br />
				<div class="items">
					<div class="left-items">
						<div class="labels-and-inputs">
							<div class="labels">
								<label for="consumer-number">Consumer Number:</label>
							</div>
							<div class="inputs">
								<input type="number" name="consumerNumber" id="consumer-number"
									placeholder=" Consumer Number" min="1000000000000"
									max="9999999999999" readonly>
							</div>
						</div>
					</div>
					<div class="right-items">
						<div class="labels-and-inputs">
							<div class="labels">
								<label for="bill-number">Bill Number:</label>
							</div>
							<div class="inputs">
								<input type="number" name="billNumber" id="billNumber"
									placeholder=" Last 5 digits" max="5" readonly >
							</div>
						</div>
					</div>
				</div>
			</div>
			<br /> <br />

			<!-- Customer Details div -->
			<div class="user-details">
				<h3 class="heading">Customer Details</h3>
				<br />
				<hr />
				<br />

				<div class="items">
					<div class="left-items">
						<div class="labels-and-inputs">
							<div class="labels">
								<label for="title">Title:</label><br /> <br>
								<label for="email">Email Id:</label><br /> <br />
							</div>
							<div class="inputs">
								<select name="title" id="title" required>
									<option value="select" selected disabled>Please Select</option>
									<option value="Mr.">Mr.</option>
									<option value="Mrs.">Mrs.</option>
								</select><br /> <input type="text" name="email" id="email"
									placeholder=" Email address" required><br /> <br />
							</div>
						</div>
					</div>
					<div class="right-items">
						<div class="labels-and-inputs">
							<div class="labels">
								<label for="name">Name:</label> <br><br><br><br><br>
								<label for="mobile-number">Mobile Number:</label><br /> <br />
							</div>
							<div class="inputs">
								<input type="text" name="name" id="name"
									placeholder=" Enter your Name" required><br /> <select
									name="mobileCode" id="mobile-code" required>
									<option value="india">0091-INDIA</option>
									<option value="usa">0001-USA</option>
									<option value="uk">0044-UK</option>
									<option value="japan">0081-JAPAN</option>
								</select><br /> <input type="tel" id="mobile-number"
									name="mobileNumber" placeholder=" Mobile Number" maxlength="10" required><br />
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Login Details div -->
			<div class="login-detalis">
				<h3 class="heading">Login Details</h3>
				<br />
				<hr />
				<br />

				<div class="items">
					<div class="left-items">
						<div class="labels-and-inputs">
							<div class="labels">
								<label for="userid">User Id:</label>
							</div>
							<div class="inputs">
								<input type="text" name="userId" id="userid" placeholder="userID" readonly>
							</div>
						</div>
					</div>
					<div class="right-items">
						<div class="labels-and-inputs">
							<div class="labels">
								<label for="password">Password:</label><br /><br><br>
								 <label	for="re-password">Confirm Password:</label>
							</div>
							<div class="inputs">
								<input type="password" name="password" id="password" required><br />
								<input type="password" name="rePassword" id="re-password"
									required>
							</div>
						</div>
					</div>
				</div>
			</div>
			

			<div class="buttons">
				<button type="reset" id="reset-btn">Reset</button>
				&nbsp;&nbsp;
				<button type="submit" id="register-btn">Register</button><br/><br/><br>
				            Aldready registered? <a href="${pageContext.request.contextPath}/login" style="color: #4CAF50; text-decoration: none;">Customer login here</a>
				
			<p>
<br>
            Are you an admin? <a href="${pageContext.request.contextPath}/adminRegister" style="color: #4CAF50; text-decoration: none;">AdminRegister here</a>    </p>
			</div>
		</form>
	</div>

	
</body>

</html>
