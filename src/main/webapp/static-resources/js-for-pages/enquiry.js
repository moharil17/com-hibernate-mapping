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
				// stop submit the form, we will post it manually.
				
				event.preventDefault();

				var form = $('#enquiryForm')[0];

				// Create an FormData object
				var data = new FormData(form);
				var secToken = $('#csrf').val();
				
				data.append("_csrf", $('#csrf').val());
				console.log("Form save data :"+data);

				$.ajax({
					type : "POST",
					url : "enquiery",
					data : data,
					processData : false,
					contentType : false,
					cache : false,
					success : function(data) {
						$('.modal').modal('hide');
						alert("SUCCESS : ", data);
						/*$("#enquiryForm").find("input").val("");
						$("#enquiryForm").find("select").find('option:not(:first)').remove();*/
						
					},
					error : function(e) {
						alert(e);
					}
				});
			});

			$('#enquiryModal').on(
					'shown.bs.modal',
					
					function() {
						
						$.ajax({
							url : "getStateListinfo",
							type : "GET",
							success : function(xhr) {
								
								$('#state').find('option:not(:first)').remove();
								$.each(xhr, function(i, value) {
									console.log("i a here");
									var n = "<option value=" + value.state_id
											+ ">" + value.stateName
											+ "</option>";
									$(n).appendTo("#state")
								});
							},

							error : function() {
								alert("Error in fetching stated=s");
							}
						});
						
						//onchange of states fetch cities
						 $(document).on('change', '#state', function(){
							
							 var changed_state_id = $(this).val();
							 
							 console.log(changed_state_id);
							
							 $.ajax({
									type : "GET",
									url : "getCityList/"+changed_state_id+"/",
									data : changed_state_id,
									processData : false,
									contentType : false,
									cache : false,
									
									statusCode: {
										
										200 : function(xhr){
											 $('#city').find('option:not(:first)').remove();
									console.log(xhr)
									
									$.each(xhr,function(i,value){
										var n = "<option value=" + value.city_id+">" + value.cityName+"</option>";
										$(n).appendTo("#city");
									});
									},
									error : function(e) {
										alert(e);
									}
							 }
								});
							 
					});

		});
			$("#enquiryModal").on('hidden.bs.modal',function(){
				
				$("#enquiryForm").find("input").val("");
				$("#enquiryForm").find("select").find('option:not(:first)').remove();
				
				
			});
		});