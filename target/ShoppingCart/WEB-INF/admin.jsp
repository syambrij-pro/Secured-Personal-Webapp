<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Product.</title>
</head>
<body>	
	<h3>Create Product: </h3>
	<form action="/ShoppingCart/productcreated" method="post" modelAttribute = "productData">
	<table>
		<tr style="line-height: 50px;">		
		</tr>
		<tr>
			<td></td>
			<td>
				<table>
					<tr>
						<td>Product Name</td>
						<td><input type="text" name = "name"></td>
					</tr>
					<tr>
						<td>Product Price</td>
						<td><input type="text" name = "price"></td>
					</tr>
					<tr>
						<td>Product Description</td>
						<td><input type="text" name = "description"></td>
					</tr>
					<tr>
						<td>Product Image</td>
						<td><input type="file" name = "image"></td>
					</tr>
				</table>
			</td>
			<td></td>
		</tr>
	</table>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
	<br/><input type="submit" value="Create Product!">
	</form>
</body>
</html>