$("#navMenuBar").ready(function() {

			$.ajax({
				url : "getNavigationMenuItems",
				type: "GET",
				statusCode : {
					200 : function(xhr) {
						
						$.each(xhr, function(id, value, key) {

							$("nav ul").append('<li class="nav-item"><a class="nav-link" href="'+ value.menuUrl + '">'+ value.menuName+ '</a></li>');
						});
					},
				
					500 : function(xhr) {
						alert("Temporary error in appication. Have a tea break and come again! We will fix it for you. :P");
					}
				}
			});
});