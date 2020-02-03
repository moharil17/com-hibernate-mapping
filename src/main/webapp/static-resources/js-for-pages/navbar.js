$("navbar-nav").ready(function() {

			$.ajax({
				url : "getNavigationMenuItems",
				type: "GET",
				statusCode : {
					200 : function(xhr) {
						
						var array = [
							   {link: "homePage", name: "Home"},
							   {link: "enquiery", name: "Enquiry"}
							];
						$.each(array, function(key, value) {
							var n = $("nav ul").append('<li class="nav-item"><a class="nav-link" href="'+ value.link + '">'+ value.name+ '</a></li>');
						});
					},
				
					400 : function(xhr) {
						alert("Temporary error in appication. Have a tea break and come again! We will fix it for you. :P");
					}
				}
			});
});