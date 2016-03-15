<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Created Message.</title>
</head>
<body>
	<br/>
	<h6>You have created a product successfully!</h6>
	<br/>
	Create a new 
	<form action="/ShoppingCart/admin" method="post">
		<input type ="hidden" name="new" />
		<button type="submit" value="create" name="create">Product</button>
	</form>
</body>
</html>