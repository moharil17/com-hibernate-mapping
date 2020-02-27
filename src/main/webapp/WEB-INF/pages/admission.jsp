<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Demo</title>
	<%@include file="includes/header.jsp"%>
	<%@include file="includes/navbar.jsp"%>
	<script src="${pageContext.request.contextPath}/static-resources/js-for-pages/admission.js"></script>

</head>
<body>
<!-- 	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%> -->
	<div class="container">
		<h4>Admission</h4>
		
		<!-- Cards -->
		<div class="row">
			<div class="col-sm-4">
				<div class="card" style="height: 200px;">
					<div class="card-header font-weight-bold">Search Enquiry</div>
					<div class="card-body">
						<select class="form-control">
							<option value="" selected disabled>Please Select</option>
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
		
		
		<div class="modal fade" tabindex="-1" id="admissionModal">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">

							<div class="modal-header">
								<h6 class="modal-title">View/Update Enquiry</h6>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<form action="admission" method="post" id="admissionForm">
									<div class="form-row">
										<div class="form-group col-md-5">
											<label for="firstName">First Name</label> <input type="text"
												class="form-control-sm" name="firstName">
										</div>
										<div class="form-group col-md-5">
											<label for="lastName">Last Name</label> <input type="text"
												class="form-control-sm" name="lastName">
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-3">
											<label for="gender">Gender</label> <select
												class="form-control-sm" name="gender">
												<option value="" selected disabled>Please Select</option>
												<option value="F">Female</option>
												<option value="M">Male</option>
											</select>
										</div>
										<div class="form-group col-md-5">
											<label for="mobileNo">Mobile No.</label> <input type="text"
												class="form-control-sm" name="mobileNo">
										</div>
										<div class="form-group col-md-4">
											<label for="emailId">Email ID</label> <input type="email"
												class="form-control-sm" name="emailId">
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-5">
											<label for="prevYrMarks">Prev. Year Score</label> <input
												type="number" class="form-control-sm"
												name="prevYrMarks" placeholder="">
										</div>
										<div class="form-group col-md-3"></div>
										<div class="form-group col-md-4">
											<label for="">Enquiry for Class</label> <select id="updateAdmssnToClass"
												name="admssnToClass" class="form-control-sm">
												<option value="" selected disabled>Please Select</option>
												<option value = "1">1st</option>
												<option value = "2">2nd</option>
											</select>
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-3">
											<label for="state">State</label> <select id="state"
												class="form-control-sm" name="state">
												<option value="" selected disabled>Please Select</option>
												
											</select>
										</div>
										<div class="form-group col-md-5">
											<label for="city">City</label> <select id="city"
												class="form-control-sm" name="city">
												<option value="" selected disabled>Please Select</option>
												
											</select>
										</div>
										<div class="form-group col-md-4">
											<label for="zip">Zip</label> <input type="text"
												class="form-control-sm" name="zip">
										</div>
									</div>
									<!-- update enq row -->
									<div class="form-row">
										<div class="form-group col-md-4">
											<label for="enquiry_id" class="col-md-5">Enquiry ID</label> <input type="text"
												class="form-control-sm col-md-4" id="enquiry_id" name="enquiry_id" readonly>
										</div>
										<div class="form-group col-md-4">
											<label for=""userName"">Enquiry taker</label> <input type="text" disabled
												class="form-control-sm col-md-6" id="createdByName" name="userName">
										</div>
										<input type="number" class="form-control-sm" id="created_by" name="created_by" hidden />
										<div class="form-group col-md-4">
											<label for="enquiryDate">Enquired On</label> <input type="text" readonly
												class="form-control-sm col-md-8" id="enquiryDate" name="enquiryDate">
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" id="admissionSubBtn" class="btn btn-success">Save</button>
									</div>
								</form>
							</div>
					</div>
				</div>
			</div>
		
		
	</div>
</body>
</html>