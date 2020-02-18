<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<title>Enquiry</title>
	<%@include file="includes/header.jsp"%>
	<%@include file="includes/navbar.jsp"%>
	<script src="${pageContext.request.contextPath}/static-resources/js-for-pages/enquiry.js"></script>
</head>

<body>
<input id="csrf" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<div class="container">

		<h4>Enquiry Page</h4>

<!-- Cards -->
		<div class="row">
			<div class="col-sm-4">
				<div class="card" style="height: 200px;">
					<div class="card-header font-weight-bold">Enquiry</div>
					<div class="card-body">
						<p class="card-text font-italic">When student comes for first time, 
											fill basic information as an enquiry.</p>
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#enquiryModal">New Enquiry</button>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="card" style="height: 200px;">
					<div class="card-header font-weight-bold">Search Enquiry</div>
					<div class="card-body">
						<select class="form-control">
							<option value="enquiryId">Enquiry ID</option>
							<option value="mobileNo">Mobile No.</option>
						</select><p></p>
						<input type="text" class="form-control" id="searchBy" name="searchBy"
									placeholder="Mobile Number / Enquiry ID" />
						<button type="button" class="btn btn-primary" onclick=searchEnquiry()>Search</button>
						</div>
					</div>
				</div>
			</div>
		</div>

<!-- Modal and form - start -->
		<div class="row">

			<div class="modal fade" tabindex="-1" id="enquiryModal">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">

							<div class="modal-header">
								<h4 class="modal-title">New Enquiry</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<form action="enquiery" method="post" id="enquiryForm">
									<div class="form-row">
										<div class="form-group col-md-5">
											<label for="firstName">First Name</label> <input type="text"
												class="form-control-sm" id="firstName" name="firstName">
										</div>
										<div class="form-group col-md-5">
											<label for="lastName">Last Name</label> <input type="text"
												class="form-control-sm" id="lastName" name="lastName">
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-3">
											<label for="gender">Gender</label> <select id="gender"
												class="form-control-sm" name="gender">
												<option>Male</option>
												<option>Female</option>
											</select>
										</div>
										<div class="form-group col-md-5">
											<label for="mobileNo">Mobile No.</label> <input type="text"
												class="form-control-sm" id="mobileNo" name="mobileNo">
										</div>
										<div class="form-group col-md-4">
											<label for="emailId">Email ID</label> <input type="email"
												class="form-control-sm" id="emailId" name="emailId">
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-5">
											<label for="prevYrMarks">Prev. Year Score</label> <input
												type="number" class="form-control-sm" id="prevYrMarks"
												name="prevYrMarks" placeholder="">
										</div>
										<div class="form-group col-md-3"></div>
										<div class="form-group col-md-4">
											<label for="">Enquiry for Class</label> <select
												id="admssnToClass" name="admssnToClass" class="form-control-sm">
												<!-- <option value="" selected disabled>Please Select</option> -->
												<option value = "1">1st</option>
												<option value="2">2nd</option>
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
												class="form-control-sm" name="state">
												<option value="" selected disabled>Please Select</option>
												
											</select>
										</div>
										<div class="form-group col-md-5">
											<label for="city">City</label> <select id="city"
												class="form-control-sm" name="state">
												<option value="" selected disabled>Please Select</option>
												
											</select>
										</div>
										<div class="form-group col-md-4">
											<label for="zip">Zip</label> <input type="text"
												class="form-control-sm" id="zip" name="zip">
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
										<button type="submit" class="btn btn-success" id="enquirySubBtn">Save</button>
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