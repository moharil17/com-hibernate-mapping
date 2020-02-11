<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<%@include file="includes/header.jsp"%>

</head>
<body>
 	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<div class="container">
	
		<div class="mx-auto mt-5" style="width: 350px;">
		<h4 class="text-center">Perfect School Manager</h4>
		<form action="loginPage" method="POST">
		
			<fieldset class="form-group">
				<input type="text" placeholder="Username"
					class="form-control text-center" id="userUserName" name="userUserName" />
			</fieldset>
			<fieldset class="form-group">
					<input type="password" placeholder="Password"
					class="form-control text-center" id="userPassword" name="userPassword" />
			</fieldset>
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			
			<button type="submit" class="btn btn-primary btn-block">LOGIN</button>
		</form>
		</div>
	</div>
</body>

<script type="text/javascript">
	if(new URL(window.location.href).searchParams.get("msg") != null)
		alert(new URL(window.location.href).searchParams.get("msg"));
</script>
</html>