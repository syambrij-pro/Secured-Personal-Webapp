<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Shopping Destination</title>
<script>
	function password() {
		var password = document.getElementsByName("new_password");
		if (password.length < 6) {
			alert("password length should be greater than 5.");
		}
	}
</script>
</head>
<body>
	<h1>Welcome here at Home Page!.</h1>
	<br>
	<div style="width: 100%;">
		<div style="float: left; width: 30%">
			<%-- <form action="/ShoppingCart/products" method="post">
				<table>
					<tr>
						<td><image src="/username_icon.png" alt="username " style="width:30px" /></td>
						<td><input type="text" name="username" style="height: 30px"></td>
					</tr>
					<tr>
						<td><image src="/password_icon.png" alt="password " style="width:30px" /></td>
						<td><input type="password" name="password" style="height: 30px"></td>
					</tr>
					
				</table>
				   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
				
				<br/> <input type="submit" value="login" style="align: center">
			</form> 
						<a href="/ShoppingCart/login">login</a>	--%>
		</div>
		<div style="float: left; width: 70%">
			<form action="/SecureWebapp/validation" method="post">
				<table>
					<tr>
						<td>First Name</td>
						<td><input type="text" name="firstName" style="height: 30px"></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lastName" style="height: 30px"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email" style="height: 30px"></td>
					</tr>
					<tr>
						<td>Enter password</td>
						<td><input type="text" name="new_password"
							style="height: 30px" onblur="javascript:password();"></td>
					<tr>
						<td>Confirm password</td>
						<td><input type="text" name="confirm_password"
							style="height: 30px"></td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <br /> <input type="submit"
					value="signUp">
			</form>
			<a href="/SecureWebapp/products">Already LoggedIn</a>
		</div>
	</div>
</body>
</html>