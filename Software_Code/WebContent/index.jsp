<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Maps</title>

<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>

</head>
<body>


<% System.out.println("Hello World!");%>
<h2>TESTING :)</h2>

<div id="map"></div>
    <script>
      var map;
      var address = "5 Blackness Avenue";
      function initMap() {
    	  //Dundee Location
    	  var position = {lat: 56.46913, lng: -2.97489};
    	  // The map, centered at Uluru
    	  var map = new google.maps.Map(
    	      document.getElementById('map'), {zoom: 4, center: position});
    	  // The marker, positioned at Uluru
    	  var marker = new google.maps.Marker({position: position, map: map});
          geocoder = new google.maps.Geocoder();
          codeAddress(geocoder, map);
      }
     
      function codeAddress(geocoder, map) {
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
              map: map,
              position: results[0].geometry.location
            });
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }
      
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjm5XXe-NiqA8H5Z_LQzmDpNXlPQQiEUs&callback=initMap"
    async defer></script>


</body>
</html>