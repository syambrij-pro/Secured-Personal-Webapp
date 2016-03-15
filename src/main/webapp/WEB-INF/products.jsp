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
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Product Description</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Product Introduction Date</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Product Support Discontinuation Date</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Product Internal Name</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">External Product Number</th>
					<th style="border: 1px solid #3D78FA; border-collapse: collapse;">Trial Days</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.productName}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.description}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.introductionDate}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.supportDiscontinuationDate}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.internalName}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.externalProductNumber}</td>
						<td style="border: 1px solid #3D78FA; border-collapse: collapse;">${product.trialDays}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	<br />
</body>
</html>