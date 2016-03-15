<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
<style type="text/css">
.logoutButton{
   position:fixed;
   right:10px;
   top:10px;
}
</style>
</head>
<body>
	<h3>You have logged in. Here is the Product List!</h3>
	<h2>List of Products</h2>
	<form align="right" name="form1" method="post" action="/ShoppingCart/logout">
	<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
		<label class="logoutButton"> <input name="submit2"
			type="submit" id="submit2" value="log out">
		</label>
	</form>
	<div
		style="float: center; /* width: 100%; */ overflow-y: scroll; margin-top: 15">
		<table style="border: 1px solid #3D78FA ">
			<thead>
				<tr>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Product Name</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Description</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Fist Date Used</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Last Date Used</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Service Provider Name</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Generic Product Name</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">validity in Days</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.productName}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.description}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.firstDay}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.lastUsedDate}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.providerName}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.genericProductName}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.validity}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	<br />
</body>
</html>