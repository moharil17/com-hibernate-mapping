$("navbar-nav").ready(function() {

			$.ajax({
				url : "getNavigationMenuItems",
				type: "GET",
				statusCode : {
					200 : function(xhr) {
						console.log("inside ajax response 200");
						console.log(xhr);
						
						$.each(xhr, function(id, value, key) {
							console.log("i a here");
							var n = $("nav ul").append('<li class="nav-item"><a class="nav-link" href="'+ value.menuName + '">'+ value.menuUrl+ '</a></li>');
							console.log(n);
						});
					},
				
					400 : function(xhr) {
						
						
						alert("Temporary error in appication. Have a tea break and come again! We will fix it for you. :P");
					}
				}
			});
});