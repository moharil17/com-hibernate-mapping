<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="col-sm-5">
		<form class="form-signin" action="addStudent" method="post">

			<h1 class="h3 mb-3 font-weight-normal">Student Registration from</h1>
			<div class="form-group row">
				<label for="inputFirstName" class="sr-only">FirstName</label>
				<div class="col-sm-10">
					<input type="text" name="fName" id="inputFirstName"
						class="form-control" placeholder="First Name" required autofocus>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputLastName" class="sr-only">LastName</label>
				<div class="col-sm-10">
					<input type="text" name="lName" id="inputLastName"
						class="form-control" placeholder="Last Name" required autofocus>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputMobileNumber" class="sr-only">MobileNumber</label>
				<div class="col-sm-10">
					<input type="text" name="mobile" id="inputMobileNumber"
						class="form-control" placeholder="MobileNumber" required autofocus>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputEmail" class="sr-only">Email</label>
				<div class="col-sm-10">
					<input type="email" name="email" id="inputEmail"
						class="form-control" placeholder="Email" required autofocus>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputDate" class="sr-only">Email</label>
				<div class="col-sm-10">
					<input type="date" name="date" id="inputDate"
						class="form-control" placeholder="DOB" required autofocus>
				</div>
			</div>
			
			
			<div class="control-group">
				<!-- Button -->
				<div class="controls">
					<button class="btn btn-success">Register</button>
				</div>
			</div>



		</form>
		</div>
</body>
</html>