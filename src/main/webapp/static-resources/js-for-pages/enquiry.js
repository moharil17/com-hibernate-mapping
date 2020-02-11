/*$(document).ready(function(){
  $("button").click(function(){
    $.ajax({url: "wrongfile.txt", error: function(xhr){
      alert("An error occured: " + xhr.status + " " + xhr.statusText);
    }});
  });
});*/

$(document).ready(function() {
		$("#enquirySubBtn").click(function(event)
				{
			
			//stop submit the form, we will post it manually.
				 event.preventDefault();
				 
				 var form = $('#enquiryForm')[0];
				 
				// Create an FormData object 
			        var data = new FormData(form);
			        //adding sec token into data obj
			        data.append("_csrf", $('#csrf').val());
			        console.log(data);
			        
			        $.ajax({
			            type: "POST",
			            url: "enquiery",
			            data: data,
			            processData: false,
			            contentType: false,
			            success: function (data) {
			            	console.log("In success "+data);
			            	$('.modal').modal('hide');
			                alert("SUCCESS : ", data);
			            },
			            error: function (e) {
			            	console.log("In error "+data);
			                alert(e);
			            }
			        });
				});
});