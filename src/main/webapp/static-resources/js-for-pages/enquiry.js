/*$(document).ready(function(){
  $("button").click(function(){
    $.ajax({url: "wrongfile.txt", error: function(xhr){
      alert("An error occured: " + xhr.status + " " + xhr.statusText);
    }});
  });
});*/

$(document).ready(
		function() {
			
			$("#enquirySubBtn").click(function(event) {
				
			// stop default submit of form, we will post it manually.
				event.preventDefault();

				$.ajax({
					type : "POST",
					url : "createNewEnquiery",
					data : $('form[id=enquiryForm]').serialize(),
					
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
			$('#enquiryModal').on('shown.bs.modal',function() {
						
						$.ajax({
							url : "getStateListinfo",
							type : "GET",
							success : function(xhr) {
								
								$('#state').find('option:not(:first)').remove();
								$.each(xhr, function(i, value) {

									var n = "<option value=" + value.state_id + ">" + value.stateName + "</option>";
									$(n).appendTo("#state")
								});
							},

							error : function(xhr, textStatus) {
								alert(textStatus+" : "+xhr.responseText);
							}
						});
						
						
			//onchange of #states fetch cities dropdown data
			$(document).on('change', '#state', function() {
				
							 $.ajax({
									type : "GET",
									url : "getCityList/"+ $('#state').val(), //Ex. /getCityList/1
									success : function(xhr) {
										//remove previous data of dropdown
										$('#city').find('option:not(:first)').remove();

										$.each(xhr,function(i,value) {
											var n = "<option value=" + value.city_id+">" + value.cityName+"</option>";
											$(n).appendTo("#city");
										});
									},
									error : function(xhr, textStatus) {
										alert(textStatus+" : "+xhr.responseText);
									}
								});
							 
					});

		});
			
			// Clear form data on close of modal
			$("#enquiryModal").on('hidden.bs.modal',function(){
				
				$("#enquiryForm").find("input").val("");
				$("#enquiryForm").find("select").find('option:not(:first)').remove();
			});
		});