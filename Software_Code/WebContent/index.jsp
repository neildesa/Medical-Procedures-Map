<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="JavaDatabaseCode.JavaFunctionsForJsp" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/Web/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
                            <a class="nav-link" href="details.jsp">Find a Hospital<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Web/about.html">About us</a>
                        </li>
                    </ul>
                </div>
            </nav>
	      <div id="map"></div> 
            <div class="container-flex content-box">    
                <div class="row align-items-center">
                    <div class="col overflow-auto" style="height: calc(100vh - 75px); padding: 0px">
                        <table class="table table-hover table-borderless table-striped">
                            <thead>
                              <tr>
                                <th scope="col">Hospital</th>
                              </tr>
                            </thead>
                            <tbody>
								<% 
                            		// procedureName would be received from the details.html drop-down object the user selects
                            		String procedure = request.getParameter("procedure"); 
                            		String procedureName = procedure;
                            		int lowerBound = Integer.parseInt(request.getParameter("minRange"));
                            		int upperBound = Integer.parseInt(request.getParameter("maxRange"));
                            		
                            		String name = procedureName.trim();
                            		
                            		System.out.println("e:" + procedureName);
                            		
                            		// Call this function if we are searching by cost
                   			  		//ArrayList<ArrayList<String>> hospitalList = JavaFunctionsForJsp.findHospitalByProcedure(name, lowerBound, upperBound);
                            		
                            		// Call this function if we are searching by Rating
                            		
                            		// Call this function if we are searching by distance
									ArrayList<ArrayList<String>> hospitalList = JavaFunctionsForJsp.findHospitalByProcedure(name);
                            		
                            		
                   			  		System.out.println("hospital size: " + hospitalList.size());
                   			  		
                   				  	for (int i = 0; i < hospitalList.size(); i++) { 
                   				%>
                   				  	<tr>
                   				  		<td><% out.println(hospitalList.get(i).get(0)); %></td>
                   				  	</tr>
                   				  	<% } %>	
                                <tr><td id="HospitalName">Hospital Name</td></tr>
                            </tbody>
                          </table>
                          
                          
                   		</div>
                	</div>
            	</div>
            	
           <% String loc = request.getParameter("location"); %>
           <% String range = request.getParameter("rangeRange"); %>
           <% String procedures = request.getParameter("procedure"); %>
            	
    	<script>
    	
    	var origin = "<%= loc%>"; 
    	var procedure = "<%= procedure%>"; 
  	 	var range = "<%= range%>" * 0.621371; 
  	 	
 		
	     var map;
	     var locations = [];
	      <% 
	      	for (int i = 0; i < hospitalList.size(); i++){ 
	      %>
	   // note: hospitalList.get(i).get(1) = hospitalAddress; hospitalList.get(i).get(0) = hospitalName 
      		var hospitalName = "<%= hospitalList.get(i).get(0) %>";
      		var hospitalAddress = "<%= hospitalList.get(i).get(1) %>";
      		var row = [hospitalName, hospitalAddress]
      		locations.push(row)
	      <% } %>
	      var distance = "Caclulating...";
	      var prevInfoWindow;
	      var markerArray = [];
	      var markerDistance = [];
	      
	      function initMap() {
	    	  var position = {lat: 56.46913, lng: -2.97489};
	    	  var map = new google.maps.Map(
	    	      document.getElementById('map'), {zoom: 4, center: position});
	    	  
	    	  var service = new google.maps.DistanceMatrixService();
	          geocoder = new google.maps.Geocoder();
	          
	          codeAddress(geocoder, map, origin, service, true);
	          
				for(var location in locations){
					codeAddress(geocoder, map, location, service, false);
				}

	      }
	      
	      function getDistance(distanceMatrix, map, address, result, distance){
	    	  dest = locations[address][0];
	    	  distanceMatrix.getDistanceMatrix(
            		  {
            			    origins: [origin],
            			    destinations: [dest],
            			    travelMode: 'DRIVING',
            			    unitSystem: google.maps.UnitSystem.IMPERIAL,
            		  }, function(response, status){
            	          	if (status == 'OK') {
            	          		var origins = response.originAddresses;
            	          	    var destinations = response.destinationAddresses;
            	          	    
            	          	  for (var i = 0; i < origins.length; i++) {
            	          	      var results = response.rows[i].elements;
            	          	      for (var j = 0; j < results.length; j++) {
            	          	        var element = results[j];
            	          	        distance = element.distance.text;
            	          	        var duration = element.duration.text;
            	          	        var from = origins[i];
            	          	        var to = destinations[j];
            	          	      	placeMarker(map, address, result, distance);
            	          	      	
            	          	      }
            	          	    }
            	          		removeMarkers();
            	          	  }
            	          	if (status == 'NOT_FOUND') {
            	          		  alert("The origin and/or destination of this pairing could not be geocoded.");
            	          		  }
            				if (status == 'ZERO_RESULTS'){
            					alert("No route could be found between the origin and destination.");				
            					}
            				});    
	    }
	      
	      
	      function codeAddress(geocoder, map, address, distanceMatrix, user) {
	    	  
	    	  if(user == true){
	    		  geocoder.geocode({'address': address}, function(results, status) {
	    	          if (status === 'OK') { 
    	        		  placeMarkerUser(map, results[0].geometry.location);
    	  			}
	    	          else {
    		            //alert('Geocode was not successful for the following reason: ' + status);
    		          }
	    	 	 });
	    	  }
	    	  else{
	    		  geocoder.geocode({'address': locations[address][0]}, function(results, status) {
	    	          if (status === 'OK') { 
	    	        	  getDistance(distanceMatrix, map, address, results[0].geometry.location, distance); 
	    		  } 
	    	          else {
	  	            	//alert('Geocode was not successful for the following reason: ' + status);
	  	          }
	        	});
	      	}
	      }
	      
              
	    function placeMarker(map, address, result, distance){
	    	
	            var image = { url: 'https://cdn1.iconfinder.com/data/icons/medicine-pt-7/100/051_-_hospital_map_marker_pin_doctor-512.png',  scaledSize: new google.maps.Size(35,35) }
	            var marker = new google.maps.Marker({
	              map: map,
	              icon: image,
	              animation: google.maps.Animation.DROP,
	              position: result
	            });
	            
	            markerArray.push(marker);
	            markerDistance.push(distance);

	            var infowindow = new google.maps.InfoWindow({
	            	  content:'<div id="content">'+
	                  '<div id="siteNotice">'+
	                  '</div>'+
	                  '<h5 id="firstHeading" class="firstHeading">' + locations[address][0] + ' </h5>' + '<b>Distance:</b> ' + distance +
	                  '<div id="bodyContent">'+
	                  '<p><b>Procedure: </b>' + procedure + '<hr> <b>Address:</b>' + locations[address][1] + ' <br> <b>Cost:</b> $6,778.64 <br>' +
	                  '</div>'+
	                  '</div>'
	            	});

	            	google.maps.event.addListener(marker, 'click', function() {
	            		
	            if(prevInfoWindow){
	            	prevInfoWindow.close();
	            }
	            
	            prevInfoWindow = infowindow;
	          	
               infowindow.open(map,marker)
               highlightClick()}                        
	            	);
	    }
	    
	    
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
	     
	    
        function highlightClick(){
          var elmnt = document.getElementById("HospitalName");
                  elmnt.scrollIntoView({behavior: "smooth"});
                  elmnt.style.backgroundColor = "#FDFF47";
        }

        
        function removeMarkers(){
			for(var marker in markerArray){
				var distance = (markerDistance[marker].replace(" mi", "")).replace(",", "");
				var distanceInt = parseInt(distance, 10); 
				
				if(distanceInt > range ){
					markerArray[marker].setMap(null);
				}
			}
        }
        
        
        function drawCircle(map, address) {
        	circleRadius = range*1.60934;
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
