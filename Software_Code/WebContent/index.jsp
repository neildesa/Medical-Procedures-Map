<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="JavaDatabaseCode.JavaFunctionsForJsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*"  %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="/Web/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  
<meta charset="ISO-8859-1">
<title>Maps</title>

<script type='text/javascript' src='config.js'></script>


<style>
      #map {
		height: calc(100% - 75px);
		width: 70%;
		float: right;
      }
      
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      
      .checked {
  		color: orange;
		}
		
		h1, h2, h3, h4, h5, h6{
  			line-height: 15px; 
		}
    </style>

</head>
<body>


            <nav class="navbar navbar-expand-lg navbar-light bg-light" style="height: 75px">
                <a class="navbar-brand" href="Web/index.html">Help! I'm a Fish</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="Web/index.html">Home</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="details.jsp">Find a Procedure<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Web/about.html">About us</a>
                        </li>
                    </ul>
                </div>
            </nav>
            
            
            
      		<div id="map">		
			</div> 
            <div class="container-flex content-box"> 
            	<div class="dropdown"  >
						  <button style="width: 30%" class="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Sort By
						  </button>
              <form action="index.jsp" method="POST">
						<input type="hidden" name="procedure"  value="<%= request.getParameter("procedure")  %>">
						<input type="hidden" name="minRange"   value="<%= request.getParameter("minRange")   %>">
						<input type="hidden" name="maxRange"   value="<%= request.getParameter("maxRange")   %>">
						<input type="hidden" name="starRating" value="<%= request.getParameter("starRating") %>">
						<input type="hidden" name="rangeRange" value="<%= request.getParameter("rangeRange") %>">
						<input type="hidden" name="location"   value="<%= request.getParameter("location")   %>">
						<input type="hidden" name="latlong"    value="<%= request.getParameter("latlong")  	 %>">
							
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<input type="submit" id="Cost"     class="dropdown-item" name="sort" value="Cost"    >
							<input type="submit" id="Distance" class="dropdown-item" name="sort" value="Distance">
							<input type="submit" id="Rating"   class="dropdown-item" name="sort" value="Rating"  >
						</div>
						
						<script> document.getElementById("<%= request.getParameter("sort")%>").classList.add("active");</script>
					</form>
						
						</div>
                <div class="row align-items-center">



                	
                    <div class="col overflow-auto" style="height: calc(100vh - 113px); padding: 0px">
                    	<div class="overflow-auto">
	                        <table class="table table-hover table-borderless table-striped">
	                            <thead>
	                              <tr>
	                                <th scope="col" style="width: 80%;">Hospital</th>
	                              </tr>
	                            </thead>
	                            <tbody>
									<% 
	                            		// procedureName would be received from the details.html drop-down object the user selects
	                            		ArrayList<ArrayList<String>> hospitalList = new ArrayList<ArrayList<String>>();
	                            		String procedure = request.getParameter("procedure"); 
	                            		String procedureName = procedure;
	                            		String sort = request.getParameter("sort");
	                            		System.out.println(sort);
	                            		int lowerBound = Integer.parseInt(request.getParameter("minRange"));
	                            		int upperBound = Integer.parseInt(request.getParameter("maxRange"));
	                            		int starRating = Integer.parseInt(request.getParameter("starRating"));
	                            		double maxDistance = Double.parseDouble(request.getParameter("rangeRange"));
	                            		String latlong = request.getParameter("latlong");
	                            		String latlongTrim = latlong.substring(1, latlong.length() - 1);
	                            		Scanner scanner = new Scanner(latlongTrim); 
	                            		scanner.useDelimiter(","); 
	                            		String Latitude = scanner.next();
	                            		String Longitude = scanner.next();
	                            		double currentLong = Double.parseDouble(Longitude);
	                            		double currentLat = Double.parseDouble(Latitude);
	                            		System.out.println("Longitude: " + currentLong);
	                            		System.out.println("Latitude: " + currentLat); 
	                            		
	                            		String name = procedureName.trim();
	                            		
	                            		System.out.println("e:" + procedureName);

	                            		System.out.println("Sort by => " + sort);
                                		
	                   			  		int type = 4;
	                            		
	                            		if (sort.equals("Cost")) {
	                   			  			hospitalList = JavaFunctionsForJsp.findHospitalByProcedure(name, lowerBound, upperBound, starRating, 1);
	                   			  			hospitalList = JavaFunctionsForJsp.addHospitalDistancesToArray(hospitalList, currentLong, currentLat, maxDistance);
	                   			  			type = 4;
	                   			  			// Sort by cost
	                            		
	                            		} else if (sort.equals("Distance")) {
	                   			  			hospitalList = JavaFunctionsForJsp.findHospitalByProcedure(name, lowerBound, upperBound, starRating, 2);
	                   			  			hospitalList = JavaFunctionsForJsp.addHospitalDistancesToArray(hospitalList, currentLong, currentLat, maxDistance);
	                   			  			hospitalList = JavaFunctionsForJsp.sortDistances(hospitalList);
	                   			  			type = 6;
	                   			  			// Sort by distance

	                            		} else if (sort.equals("Rating")) {
	                   			  			hospitalList = JavaFunctionsForJsp.findHospitalByProcedure(name, lowerBound, upperBound, starRating, 3);
	                   			  			hospitalList = JavaFunctionsForJsp.addHospitalDistancesToArray(hospitalList, currentLong, currentLat, maxDistance);
	                   			  			type = 5;
	                   			  			// Sort by rating
	                            		}
	                   			  			
	                   			  			

	                   			  		System.out.println("hospital size: " + hospitalList.size());
	                   			  		
	                   			  		String otherColumn = "";
	                   			  		
	                   			  		
	                   				  	for (int i = 0; i < hospitalList.size(); i++) { 
	                   				  		if (type == 4) {
	                   				  			otherColumn = "$" + hospitalList.get(i).get(type);
	                   				  			
	                   				  		} else if (type == 6) {
	                   				  			otherColumn = hospitalList.get(i).get(type) + " Mi";
	                   				  			
	                   				  		} else if (type == 5) {
	                   				  			otherColumn = hospitalList.get(i).get(type) + " Star(s)";
	                   				  			
	                   				  		} 
	                   				  	%>
	                   				  	<tr id='<%= hospitalList.get(i).get(0) %>'>
	                   				  		<td><% out.println(hospitalList.get(i).get(0)); %> </td><td><% out.println(otherColumn); %></td>
	                   				  	</tr>
	                   				  	<% } %>	
	                            </tbody>
	                          </table>
                          </div>

                          
                          
                   		</div>
                   			
                	</div>
            	</div>
            	
           <% String loc = request.getParameter("location"); %>
           <% String range = request.getParameter("rangeRange"); %>
           <% String procedures = request.getParameter("procedure"); %>
            	
    	    	<script>
    	
    	//Initializing global variables
    	var origin = "<%= loc%>"; 
    	var procedure = "<%= procedure%>"; 
  	 	var range = "<%= range%>";
      	var prevInfoWindow;
      	var markerArray = [];
     	var map;
     	
     	//Initializing a 2D array of hospitals and their address
		var locations = [];
		<% 
	 		for (int i = 0; i < hospitalList.size(); i++){ 
		%>
	   // note: hospitalList.get(i).get(1) = hospitalAddress; hospitalList.get(i).get(0) = hospitalName 
	    	var hospitalName = "<%= hospitalList.get(i).get(0) %>";
	    	var hospitalAddress = "<%= hospitalList.get(i).get(1) %>";
	    	var hospitalLong = "<%= hospitalList.get(i).get(2) %>";
	    	var hospitalLat = "<%= hospitalList.get(i).get(3) %>";
	    	var hospitalCost = "<%= hospitalList.get(i).get(4) %>";
	    	var hospitalRating = "<%= hospitalList.get(i).get(5) %>";
	    	var hospitalDistance = "<%= hospitalList.get(i).get(6) %>";
	     	var row = [hospitalName, hospitalAddress, hospitalLong, hospitalLat, hospitalCost, hospitalRating, hospitalDistance]
	   		locations.push(row)
		<% } %>
	    
	    //Function that initializes the Google Maps API map, geocoder and distance matrix  
		function initMap() {
	 		var position = {lat: 56.46913, lng: -2.97489};
	    	var map = new google.maps.Map(
   	 		document.getElementById('map'), {zoom: 4, center: position});
	    	  
    		var service = new google.maps.DistanceMatrixService();
          	geocoder = new google.maps.Geocoder();
	          
          	codeAddress(geocoder, map, origin, service, true);
	          
			for(var location in locations){
				placeMarker(map, location);
			}

	      }
	      

	    //Function to geocode users location
   		function codeAddress(geocoder, map, address, distanceMatrix, user) {
   			
	  		if(user == true){
	    		geocoder.geocode({'address': address}, function(results, status) {
	   				if (status === 'OK') { 
	   					
    	     			placeMarkerUser(map, results[0].geometry.location);
    	  			}	    		
	   			});
	    	}
		}
	      
        //Function that places a custom marker at the location of the hospitals and initializes the markers infowindow   
		function placeMarker(map, address){
	    	var cost = locations[address][4];
	    	var price = numberWithCommas(cost);
	    	var rating = parseInt(locations[address][5]);
	    	var distance = parseInt(locations[address][6]);
	    	
	    	var Lat = parseFloat(locations[address][3]);
	    	var Long = parseFloat(locations[address][2]);
	    	var LatLong = new google.maps.LatLng(Lat, Long);
	    	
        	
			if(cost < 250000){ 
				var color = "green"; 
				var image = { url: 'https://i.imgur.com/gfWgC2N.png', scaledSize: new google.maps.Size(35,35) } 
			} 
			else if(cost < 300000){ 
				var color = "orange"; 
				var image = { url: 'https://i.imgur.com/pg1QkT2.png', scaledSize: new google.maps.Size(35,35) } 
			} 
			else if(cost > 300000){ 
				var color = "red"; 
				var image = { url: 'https://cdn1.iconfinder.com/data/icons/medicine-pt-7/100/051_-_hospital_map_marker_pin_doctor-512.png', scaledSize: new google.maps.Size(35,35) } 
			}
        	
	    	var marker = new google.maps.Marker({
	      		title: locations[address][0],
	    		map: map,
	         	icon: image,
	           	animation: google.maps.Animation.DROP,
	          	position: LatLong
	    	});
	            
	       	markerArray.push(marker);
	            
            var infowindow = new google.maps.InfoWindow({
            	  content:'<div id="content">'+
                  '<div id="siteNotice">'+
                  '</div>'+
                  '<h5 id="firstHeading" class="firstHeading">' + locations[address][0] + 	
                  '<div style="float:right">' + rating + 
                  "<span class=\"fa fa-star checked\"></span>" + 
                  '</div>' +
                  '<h5 style="color: ' + color + '"><b>Cost:</b> $' + price + '</h5></h5> <hr>'  +
                  '<div id="bodyContent">'+
                  '<p style="font-size: 17px"><b>Distance: </b>' + distance + " Miles" +
                  '<br> <b>Address: </b>' + locations[address][1]  + 
                  '<br> <b>Procedure: </b>' + procedure   + 
                  '</p>' +
                  '</div>'+
                  '</div>'
            	});
            	
            var opener = document.getElementById(locations[address][0]);
            opener.addEventListener('click', function() {
            		for (var i=0; i<markerArray.length; i++){
            			if (markerArray[i].getTitle() == locations[address][0]){
            				google.maps.event.trigger(markerArray[i], 'click')}
            			}
            		}
            ); 
	         	
			google.maps.event.addListener(marker, 'click', function() {
            		
	            if(prevInfoWindow){
	            	prevInfoWindow.close();
	            }
	            
	            prevInfoWindow = infowindow;
	          	
	         	infowindow.open(map,marker)
	         	
	         	highlightClick(locations[address][0])}                        
	       	);
	    }
        
        //Function to add commas to cost
        //Source: https://stackoverflow.com/questions/2901102/how-to-print-a-number-with-commas-as-thousands-separators-in-javascript
		function numberWithCommas(x) {
		    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}
	    
	    //Function that places a marker at the users selected location
	    function placeMarkerUser(map, result){
	    	map.setCenter(result);
            var image = { url: 'https://cdn0.iconfinder.com/data/icons/real-estate-240/32/10_Location_home_house_pin_gps-512.png',  scaledSize: new google.maps.Size(35,35) }
            var marker = new google.maps.Marker({
          		map: map,
         		icon: image,
        		animation: google.maps.Animation.DROP,
         		position: result
            });
            
  			drawCircle(map, result);
		}
	     
	    //Function that highlights and scrolls to the hospital in the table of hospitals
        function highlightClick(Address){
        	var elmnt = document.getElementById(Address);
        	elmnt.classList.toggle("highlight");
        	elmnt.animate({
        		background:	["#ffef9f", "#00000000"],
        		transform:	["scale(1, 1)", "scale(1.1, 1.1)", "scale(1, 1)"]
        	}, 800);        	
            elmnt.scrollIntoView({behavior: "smooth"});
        }
        
        //Function that draws a circle, with origin of the users location and a radius of the users selected range
        function drawCircle(map, address) {
        	circleRadius = range*1.62934;
            var antennasCircle = new google.maps.Circle({
            	strokeColor: "#000000",
              	strokeOpacity: 0.4,
              	strokeWeight: 2,
              	fillColor: "#00ffff",
              	fillOpacity: 0.1,
              	map: map,
              	center: address,
              	radius: circleRadius * 1000
            });
            map.fitBounds(antennasCircle.getBounds());
          }
        
            
		var key = config.API_KEY;
      	var srcText = 'https://maps.googleapis.com/maps/api/js?key=' + key + '&callback=initMap';
      	var script = document.createElement('script');
      	script.src = srcText
      	document.body.appendChild(script)
     </script>
    
   

</body>
</html>