<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>

</head>
<body>
 	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<div class="container">
		<form action="loginPage" method="POST">
		
			<fieldset class="form-group">
				<label for="userUserName">First Username</label> <input type="text"
					class="form-control" id="userUserName" name="userUserName">
			</fieldset>
			<fieldset class="form-group">
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" name="userPassword">
			</fieldset>
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			
			<button type="submit" class="btn btn-primary">LOGIN</button>
		</form>
	</div>
</body>
</html>