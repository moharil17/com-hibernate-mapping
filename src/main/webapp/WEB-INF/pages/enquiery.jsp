<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<title>Enquiry</title>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

</head>
<body>
 	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<div class="container">

		<h3>Enquiry Page</h3>

		<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#enquiryModal">New Enquiry</button>
		<div class="row">

			<div class="modal fade" tabindex="-1" id="enquiryModal">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">

							<div class="modal-header">
								<h4 class="modal-title">New Enquiry</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<form>
									<div class="form-row">
										<div class="form-group col-md-5">
											<label for="firstName">First Name</label> <input type="text"
												class="form-control-sm" id="firstName" path="firstName"
												placeholder="">
										</div>
										<div class="form-group col-md-5">
											<label for="lastName">Last Name</label> <input type="text"
												class="form-control-sm" id="lastName" path="lastName">
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-3">
											<label for="gender">Gender</label> <select id="gender"
												class="form-control-sm" path="gender">
												<option>Male</option>
												<option>Female</option>
											</select>
										</div>
										<div class="form-group col-md-5">
											<label for="mobileNo">Mobile No.</label> <input type="text"
												class="form-control-sm" id="mobileNo" path="mobileNo"
												placeholder="">
										</div>
										<div class="form-group col-md-4">
											<label for="emailId">Email ID</label> <input type="email"
												class="form-control-sm" id="emailId" path="emailId">
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-5">
											<label for="prevYrMarks">Prev. Year Score</label> <input
												type="text" class="form-control-sm" id="prevYrMarks"
												path="prevYrMarks" placeholder="">
										</div>
										<div class="form-group col-md-3"></div>
										<div class="form-group col-md-4">
											<label for="">Enquiry for Class</label> <select
												id="admssnToClass" path="admssnToClass" class="form-control-sm">
												<option selected>1st</option>
												<option>2nd</option>
											</select>
										</div>
									</div>
									<!-- <div class="form-group">
					<label for="inputAddress2">Address 2</label>
					<input type="text" class="form-control-sm" id="inputAddress2">
				</div> -->
									<div class="form-row">
									<div class="form-group col-md-3">
											<label for="state">State</label> <select id="state"
												class="form-control-sm" path="state">
												<option selected>Maharashtra</option>
												<option>...</option>
											</select>
										</div>
										<div class="form-group col-md-5">
											<label for="city">City</label> <input type="text"
												class="form-control-sm" id="city" path="city">
										</div>
										<div class="form-group col-md-4">
											<label for="zip">Zip</label> <input type="text"
												class="form-control-sm" id="zip" path="zip">
										</div>
									</div>
									<div class="form-group">
										<div class="form-check">
											<input class="form-check-input" type="checkbox"
												id="gridCheck"> <label class="form-check-label"
												for="gridCheck"> Check me out </label>
										</div>
									</div>
									<div class="modal-footer">
									<button type="submit" class="btn btn-success">Save</button>
									</div>
								</form>
							</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</body>
</html>