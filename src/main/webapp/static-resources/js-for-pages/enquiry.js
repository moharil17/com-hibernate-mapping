/*$(document).ready(function(){
  $("button").click(function(){
    $.ajax({url: "wrongfile.txt", error: function(xhr){
      alert("An error occured: " + xhr.status + " " + xhr.statusText);
    }});
  });
});*/

$(document).ready(function(){
		$("#enquirySubBtn").click(function(event)
				{
			//stop submit the form, we will post it manually.
				
				 event.preventDefault();
				 var form = $('#enquiryForm')[0];
				 
				// Create an FormData object 
			        var data = new FormData(form);
			        var secToken = $('#csrf').val();
			        data.append("_csrf", $('#csrf').val());
			        console.log(data);
			        
			        $.ajax({
			            type: "POST",
			            url: "enquiery",
			            data: data,
			            processData: false,
			            contentType: false,
			            cache: false,
			            success: function (data) {

			                alert("SUCCESS : ", data);
			            },
			            error: function (e) {
			                alert(e);
			            }
			        });
				});
});