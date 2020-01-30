<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="JavaDatabaseCode.JavaFunctionsForJsp" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./Web/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>
    </head>
    <body>
        <div class="container-flex">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="index.html">Help! I'm a Fish</a>
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

            <div class="container-flex px-lg-5 w-auto content-box stuff-holder">    
                <form action="index.jsp" method="POST">

                    <script>
	                    $(document).ready(function() {
	                        $('.js-example-basic-single').select2();
	                    });
					</script>
					
					<div class="form-group form-item">
                        <label for="procedure">Procedure</label>
	                    <select class="js-example-basic-single form-control" data-placeholder="Select a Procedure" id="procedure">
	                    	<% 
                        		ArrayList<String> procedure = JavaFunctionsForJsp.returnListOfProcedures();
								for (int i=0; i<procedure.size(); i++) { %> 
									<option> <% out.println(procedure.get(i)); %> </option> 
								<% } 
							%>
						</select>
					</div>
                    

                    <!-- Price -->

                    <div class="row form-item">
                        <div class="col">
                            <div class="slidecontainer">                        
                                <p>Minimum Price: $<span id="min"></span></p>
                                <input type="range" name="minRange" min="1" max="2000000" value="150000" class="slider" id="minRange">
                            </div>
        
                            <script>
                                var minSlider = document.getElementById("minRange");
                                var minOutput = document.getElementById("min");
                                minOutput.innerHTML = minSlider.value; // Display the default slider value
            
                                // Update the current slider value (each time you drag the slider handle)
                                minSlider.oninput = function() {
                                    minOutput.innerHTML = this.value;
                                }
                            </script>
                        </div>
                        <div class="col">
                            <div class="slidecontainer">                        
                                <p>Maximum Price: $<span id="max"></span></p>
                                <input type="range" name="maxRange" min="1" max="2000000" value="300000" class="slider" id="maxRange">
                            </div>
        
                            <script>
                                var maxSlider = document.getElementById("maxRange");
                                var maxOutput = document.getElementById("max");
                                maxOutput.innerHTML = maxSlider.value; // Display the default slider value
            
                                // Update the current slider value (each time you drag the slider handle)
                                maxSlider.oninput = function() {
                                    maxOutput.innerHTML = this.value;
                                }
                            </script>
                        </div>
                    </div>
                    
                    <!-- Star Rating -->
                    <div class="form-item">
	                    <label for="exampleFormControlSelect2">Minimum Star Rating</label>
	                    <div class="form-group">
	                        <div class="form-check form-check-inline">
	                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineCheckbox1" value="option1">
	                            <label class="form-check-label" for="inlineCheckbox1">1</label>
	                        </div>
	                        <div class="form-check form-check-inline">
	                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineCheckbox2" value="option2">
	                            <label class="form-check-label" for="inlineCheckbox2">2</label>
	                        </div>
	                        <div class="form-check form-check-inline">
	                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineCheckbox3" value="option3">
	                            <label class="form-check-label" for="inlineCheckbox3">3</label>
	                        </div>
	                        <div class="form-check form-check-inline">
	                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineCheckbox4" value="option4">
	                            <label class="form-check-label" for="inlineCheckbox4">4</label>
	                        </div>
	                        <div class="form-check form-check-inline">
	                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineCheckbox5" value="option5">
	                            <label class="form-check-label" for="inlineCheckbox5">5</label>
	                        </div>
	                    </div>
                    </div>
                    
                    <!-- Range -->
                    <div class="slidecontainer form-item">                        
                        <p>Distance from you: <span id="range"></span> KM</p>
                        <input type="range" name="rangeRange" min="10" max="5000" value="50" class="slider" id="rangeRange">
                    </div>

                    <script>
                        var ranSlider = document.getElementById("rangeRange");
                        var ranOutput = document.getElementById("range");
                        ranOutput.innerHTML = ranSlider.value; // Display the default slider value
    
                        // Update the current slider value (each time you drag the slider handle)
                        ranSlider.oninput = function() {
                            ranOutput.innerHTML = this.value;
                        }
                    </script>
                    
                    
                    <!-- Location -->
                    <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal">Find me a hospital</button>
                    
                    <!-- Location Modal -->
					<div class="modal fade" id="myModal">
					    <div class="modal-dialog modal-dialog-centered">
					      	<div class="modal-content">
					      
					        	<!-- Modal Header -->
					        	<div class="modal-header">
					          		<h4 class="modal-title">Where you at?</h4>
					          		<button type="button" class="close" data-dismiss="modal">&times;</button>
					        	</div>
					        
					        	<!-- Modal body -->
					        	<div class="modal-body">
					          		<button class="btn btn-warning" onclick="locate()" id="getLocation" type="button">Let us find you</button>
					        	</div>
					        	<div class="modal-body">
					          		OR
					        	</div>
					        	<div class="modal-body">
					          		<label class="form-col-label">Tell me where you are</label><br>
					          		<input type="text" class="form-control" name="location" id="location"></input>
					        	</div>
					        
					        	<!-- Modal footer -->
					        	<div class="modal-footer">
					          		<input class="btn btn-success" type="submit" value="Hit Me Up" />
					        	</div>
					      	</div>
					    </div>
					</div>
					
		            <script >
		            function locate() 
		            {
		               // document.getElementById("getLocation").onclick 
		                console.log('Button Clicked!')
		                if (navigator.geolocation) {
		                        console.log('Geolocation is supported!');
		                    }
		                else {
		                    console.log('Geolocation is not supported for this Browser/OS.');
		                }
		
		               // window.onload = function() {
		                var startPos;
		                var geoSuccess = function(position) {
		                    startPos = position;
		                    console.log(startPos.coords.latitude);
		                    console.log(startPos.coords.longitude);
		                    document.getElementById("getLocation").classList.add('disabled');
			                document.getElementById("getLocation").classList.remove('btn-warning');
			                document.getElementById("getLocation").classList.add('btn-success');
			                document.getElementById("location").value=startPos.coords.latitude + ", " + startPos.coords.longitude;
		                };
		                navigator.geolocation.getCurrentPosition(geoSuccess);
		                
		            }
		            </script>
                </form>  
            </div>
        </div>
    </body>
</html>