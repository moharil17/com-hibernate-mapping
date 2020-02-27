
var enquiryData;

function searchEnquiry() {

		var url = "searchEnquiry/" + $(".card select").val() + "/" + $("#searchBy").val();
		$.ajax({
			url : url,
			type : "GET",
			success : function(xhr) {
				
				enquiryData = xhr;
				$('#admissionModal').modal('show');
				
				$.each(xhr,function(name, val) {
					$("#admissionForm").find("input[name='"+ name +"']").val(val);
					$("#admissionForm").find("select[name='"+ name +"']").val(val);
				});
			},
			error : function(xhr, textStatus) {
				alert(xhr.responseText);
			}
		});
	}




$(document).ready(
		function() {
			
			$("#admissionSubBtn").click(function(event) {
				
				// stop default submit of form, we will post it manually.
					event.preventDefault();
					
					var formID = this.closest("form").id;
					
					$.ajax({
						type : "POST",
						url : "#",//"createNewEnquiery",
						data : $('form[id='+ formID +']').serialize(),
						
						success : function(textStatus) {
							
							$('.modal').modal('hide');
							alert(textStatus);
						},
						error : function(xhr, textStatus) {
							alert(textStatus+" : "+xhr.responseText);
						}
					});
				});
			
			// On enquiryModal open, fetch States dropdown data
			$('#admissionModal').on('shown.bs.modal',function() {
						
						$.ajax({
							url : "getStateListinfo",
							type : "GET",
							success : function(xhr) {
								
								$.each(xhr, function(i, value) {

									var n = "<option value=" + value.state_id + ">" + value.stateName + "</option>";
									$(n).appendTo("#state")
								});
								
								$("#state").val(enquiryData.state);
								$("#state").change(); //trigger 'change' so on-change, cities will get fetched
							},

							error : function(xhr, textStatus) {
								alert(textStatus+" : "+"States not loaded");
							}
						});
			});
						
						
			//onchange of #states fetch cities dropdown data
			$(document).on('change', '#state', function() {
				
							 $.ajax({
									type : "GET",
									url : "getCityList/"+ $('#state').val(), //Ex. /getCityList/1
									success : function(xhr) {
										//remove previous data of dropdown
										$('#city').val('').find('option:not(:first)').remove();

										$.each(xhr,function(i,value) {
											var n = "<option value=" + value.city_id+">" + value.cityName+"</option>";
											$(n).appendTo("#city");
										});
										$("#city").val(enquiryData.city);
									},
									error : function(xhr, textStatus) {
										alert(textStatus+" : "+xhr.responseText);
									}
								});
				});
			
			// Clear form data on close of modal
			$("#admissionModal").on('hidden.bs.modal',function() {
				
				$("#admissionForm").find("input").val("");
				$("select[name='state'], select[name='city']").find('option:not(:first)').remove();
				$("form select").val("")
			});
		});