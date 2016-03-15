<html xmlns:th="http://www.thymeleaf.org"
	xmlns:tiles="http://www.thymeleaf.org">
<head>
<title tiles:fragment="title">Login</title>
<style>
#main{
	background-image: url("background.jpeg");
}
#thirty {
	height: 30%;
	/* background-color: gray; */
}
#seventy {
    width: 50%;
    /* Set the margin-left and margin-right automatically set */
    margin: 0 auto; 
}
</style>
</head>
<body>
	<div id="main" style="height: 100% ;/*  background-color: gray; */">

	<form name="Login form" th:action="@{/login}" method="post">
		<div id="thirty"></div>
		<div id ="seventy" style="width: 50% ; text-align:center">
				<!-- <legend>Please Login</legend> -->
				<%--  <div>${error}</div>                
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>        
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/> 
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>   
                <div class="form-actions">
                    <button type="submit" class="btn">Log in</button>
                </div>
                 --%>
				<table align="center">
					<tr>
						<td><img src="username_icon.png" alt="username " style="width:30px" /></td>								
						<td><input type="text" name="username" style="height: 30px"></td>
					</tr>
					<tr>
						<td><image src="password_icon.png" alt="password "
								style="width:30px" /></td>
						<td><input type="password" name="password"
							style="height: 30px"></td>
					</tr>
					<tr>
						<td> </td>
						<td> </td>
					</tr>
					<tr>
						<td><input type="submit" value="login"/></td>
						<td> </td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			<a href="/ShoppingCart/home" style="color: RED;">New User</a>
		</div>
	</form>
	</div>
</body>
</html>