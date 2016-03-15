<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head> 
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
 </head> 
 <body>
 <h2>${message}</h2>
 <%
   String password1 = request.getParameter("new_password");
   String password2 = request.getParameter("confirm_password");
   if (password1 == password2){
	   out.println("Please LogIn with correct username.");
	   //response.sendRedirect("home.jsp");
   }  else {
	   out.println("Both passwords are not matching. Please try again.");
	  // response.sendRedirect("home.jsp");
   }
   %> 
  </body>
 </html>

