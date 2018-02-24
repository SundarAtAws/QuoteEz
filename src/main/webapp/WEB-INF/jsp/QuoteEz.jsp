<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>QuoteEz</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="${pageContext.request.contextPath}/resources/images/qlogo.png" rel="icon">
  <link href="${pageContext.request.contextPath}/resources/images/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="${pageContext.request.contextPath}/resources/lib/animate/animate.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/lib/magnific-popup/magnific-popup.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
  
  	<!------------
	Range Slider statement ends
	--->
    <link href="${pageContext.request.contextPath}/resources/css/sldier-css.css" rel="stylesheet">

  
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7/css/bootstrap.min.css" >
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7/css/bootstrap-theme.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dropzone.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dropzone.css">

	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/checkbox_radio_font.css">
<script>
var householdDrivers;
var resultData;
var liabilityCov=0,collisionCov=0,compreCov=0, basicPremimum=0, premimum =0;
var insurerName = ["InsurerOne","InsurerTwo","InsurerThree"];
jQuery(document).ready(function($) {
	
	$("#getDrivers").click(function(event) {
		event.preventDefault();
		getHouseHoldDrivers();
	});
	
 $("#getQuote").click(function(event) {
		event.preventDefault();
		getQuoteCoverageDetails();
		calPremimum();
	}); 
 

 var presets = ["25$","100$","250$","500$","750$","1000$","2000$"];

 var sheet1 = document.createElement('style'),  
   $range1Input = $('.range1 input'),
   prefs = ['webkit-slider-runnable-track', 'moz-range-track', 'ms-track'];

   
 var sheet2 = document.createElement('style'),  
   $range2Input = $('.range2 input'),
   prefs = ['webkit-slider-runnable-track', 'moz-range-track', 'ms-track'];

   
 var sheet3 = document.createElement('style'),  
   $range3Input = $('.range3 input'),
   prefs = ['webkit-slider-runnable-track', 'moz-range-track', 'ms-track'];

   
 document.body.appendChild(sheet1);
 document.body.appendChild(sheet2);
 document.body.appendChild(sheet3);

 var getTrackStyle1 = function (el) {  
   var curVal = el.value,
       val = (curVal - 1) * 16.666666667,
       style = '';
   
   // Set active label
   $('.range-labels1 li').removeClass('active selected');
   
   var curLabel = $('.range-labels1').find('li:nth-child(' + curVal + ')');
   
   curLabel.addClass('active selected');
   curLabel.prevAll().addClass('selected');
   
   // Change background gradient
   for (var i = 0; i < prefs.length; i++) {
     style += '.range1 {background: linear-gradient(to right, #37adbf 0%, #37adbf ' + val + '%, #fff ' + val + '%, #fff 100%)}';
     style += '.range1 input::-' + prefs[i] + '{background: linear-gradient(to right, #37adbf 0%, #37adbf ' + val + '%, #b2b2b2 ' + val + '%, #b2b2b2 100%)}';
   }

   return style;
 }


 var getTrackStyle2 = function (el) {  
   var curVal = el.value,
       val = (curVal - 1) * 16.666666667,
       style = '';
   
   // Set active label
   $('.range-labels2 li').removeClass('active selected');
   
   var curLabel = $('.range-labels2').find('li:nth-child(' + curVal + ')');
   
   curLabel.addClass('active selected');
   curLabel.prevAll().addClass('selected');
   
   // Change background gradient
   for (var i = 0; i < prefs.length; i++) {
     style += '.range2 {background: linear-gradient(to right, #37adbf 0%, #37adbf ' + val + '%, #fff ' + val + '%, #fff 100%)}';
     style += '.range2 input::-' + prefs[i] + '{background: linear-gradient(to right, #37adbf 0%, #37adbf ' + val + '%, #b2b2b2 ' + val + '%, #b2b2b2 100%)}';
   }

   return style;
 }



 var getTrackStyle3 = function (el) {  
   var curVal = el.value,
       val = (curVal - 1) * 16.666666667,
       style = '';
   
   // Set active label
   $('.range-labels3 li').removeClass('active selected');
   
   var curLabel = $('.range-labels3').find('li:nth-child(' + curVal + ')');
   
   curLabel.addClass('active selected');
   curLabel.prevAll().addClass('selected');
   
   // Change background gradient
   for (var i = 0; i < prefs.length; i++) {
     style += '.range3 {background: linear-gradient(to right, #37adbf 0%, #37adbf ' + val + '%, #fff ' + val + '%, #fff 100%)}';
     style += '.range3 input::-' + prefs[i] + '{background: linear-gradient(to right, #37adbf 0%, #37adbf ' + val + '%, #b2b2b2 ' + val + '%, #b2b2b2 100%)}';
   }

   return style;
 }


 $range1Input.on('input', function () {
   sheet1.textContent = getTrackStyle1(this);
   
 });

 $range2Input.on('input', function () {
   sheet2.textContent = getTrackStyle2(this);
   
 });


 $range3Input.on('input', function () {
   sheet3.textContent = getTrackStyle3(this);
   
 });

	
 // Change input value on label click
 $('.range-labels1 li').on('click', function () {
   var index = $(this).index();
   $range1Input.val(index + 1).trigger('input');
   //alert(index); USE index to know the value to process
   var libCovRange = presets[index];
   document.getElementById('covergaePrice1').innerHTML= libCovRange;
   calPremimum();
   
 });


 // Change input value on label click
 $('.range-labels2 li').on('click', function () {
   var index = $(this).index();
   
   $range2Input.val(index + 1).trigger('input');
   //alert(index); USE index to know the value to process
   document.getElementById('covergaePrice2').innerHTML= presets[index];
   calPremimum();
 });


 // Change input value on label click
 $('.range-labels3 li').on('click', function () {
   var index = $(this).index();
   
   $range3Input.val(index + 1).trigger('input');
   //alert(index); USE index to know the value to process
   document.getElementById('covergaePrice3').innerHTML= presets[index];
   calPremimum();

 });

 
});

function calPremimum(){
	
	 $(resultData.insurerRating).each(function(index, insurerRating) {
		 var insurerNames = ["InsurerOne","InsurerTwo","InsurerThree"];
		   var k;
		   for(k=0;k<insurerNames.length; k++){
/* 			   alert("k"+k+" insurerNames"+ insurerNames[k] + "-"+insurerRating.insuranceName);
		    */if(insurerRating.insuranceName == insurerNames[k]){
			   
			var liabilityCov=0,collisionCov=0,compreCov=0, basicPremimum=0, premimum =0;
			   basicPremimum = parseFloat(insurerRating.basePremium).toFixed(2);
		   $(insurerRating.coverages).each(function(id, coverage){
			   var covRange = coverage.coverageRange;
			   var libCovRange = document.getElementById('covergaePrice1').innerHTML;
			   var collisionCovRange =  document.getElementById('covergaePrice2').innerHTML;
			   var compreCovRange =  document.getElementById('covergaePrice3').innerHTML;
			   if(covRange == libCovRange){
				    liabilityCov = parseFloat(coverage.liabilityBIPD).toFixed(2);
			   }
			   if(covRange == collisionCovRange){
				    collisionCov= parseFloat(coverage.collision).toFixed(2);
			   }
			   if(covRange == compreCovRange){
				    compreCov = parseFloat(coverage.comprehensive).toFixed(2);
			   }
			   
			   if(liabilityCov != 0 && collisionCov != 0 && compreCov != 0 ){
				   premimum = parseFloat((+basicPremimum + +liabilityCov + +collisionCov + +compreCov)/12).toFixed(2);
				   /*  alert( insurerRating.insuranceName+ "premimum :"+ premimum + "covRange " + covRange + "liabilityCov" + liabilityCov + collisionCov + compreCov +"basicPremimum"+basicPremimum);   */
			   }
			  
			   
		   });
		   var sixMonths =6;
		   var oneMonthId= "#basicPremimum"+insurerRating.insuranceName;
			 var sixMonthId= "#sixMonthsPremimum"+insurerRating.insuranceName;
			 $(oneMonthId).text(premimum);
			 var sixMonthsPremimum = parseFloat(premimum*sixMonths).toFixed(2);
			 $(sixMonthId).text(sixMonthsPremimum);
		   }
	   }
	   });
}

function getHouseHoldDrivers() {
	$.ajax({
		async:false,
		type : "POST",
		contentType : "application/json",
		url : "household",		
		timeout : 100000,
		success : function(data) {
			$("#primaryDriverAddress").text(data.address);
			$("#primaryDriver").text(data.primaryDriver);
			$("#vehicleModel").text(data.vehicleModel);
		$(data.driverLicenseNumList).each(function(index, driverLicenseNum) {
           var divId= "#driver"+index;
           var parentDivId= "#divDriver"+index;
           $(parentDivId).show();
  		 $(divId).text(driverLicenseNum);
         });
		},
		error : function() {
			alert("error");
			alert(e);
			console.log("ERROR: ");
		}
	});
	
}

 function getQuoteCoverageDetails() {
	 var insurerName = ["InsurerOne","InsurerTwo","InsurerThree"];
	  var driverNamesAr =  new Array();
	 var i;
	 for(i=0;i<=4;i++){
		 var checkboxDivId= "#checkBoxDriver";
		 var divId= "#driver";
		 var driverId= "#householdDriver";
		 checkboxDivId= checkboxDivId+i;
		 divId = divId+i;
		 driverId = driverId+i;
		 if($(checkboxDivId).prop("checked") == true){
			 var driverName = $(divId).text();
			 driverNamesAr [i] = driverName;
			 if(i != 0){
				 $(driverId).text(driverName);
			 }
		 }
	 }   
	
	
	$.ajax({
		async:false,
		type : "POST",
		contentType : "application/json",
		headers : {
		    'Accept' : 'application/json',
		    'Content-Type' : 'application/json'
		},
		url : "quote",		
		timeout : 100000,
		data: JSON.stringify(driverNamesAr),
		//datatype: "json",
		
		success : function(result) {
			$(result.insurerRating).each(function(index, insurerRating) {
				var i;
				   for(i=0;i<insurerName.length; i++){
				if(insurerRating.insuranceName == insurerName[i]){
				var sixMonths = 6;
 				var premimum = parseFloat(insurerRating.basePremium).toFixed(2);
 				var oneMonthId= "#basicPremimum"+insurerRating.insuranceName;
 				 var sixMonthId= "#sixMonthsPremimum"+insurerRating.insuranceName;
 				 var sixMonthsPremimum = premimum*sixMonths;
 				 $(oneMonthId).text(premimum);
 				 $(sixMonthId).text(sixMonthsPremimum);
				}
				}
			});
			resultData = result;
		},
		error : function() {
			alert("error");
		}
	});
}
 
var dropzone = new Dropzone('#demo-upload', {
	  previewTemplate: document.querySelector('#preview-template').innerHTML,
	  parallelUploads: 2,
	  thumbnailHeight: 120,
	  thumbnailWidth: 120,
	  maxFilesize: 3,
	  filesizeBase: 1000,
	  thumbnail: function(file, dataUrl) {
	    if (file.previewElement) {
	      file.previewElement.classList.remove("dz-file-preview");
	      var images = file.previewElement.querySelectorAll("[data-dz-thumbnail]");
	      for (var i = 0; i < images.length; i++) {
	        var thumbnailElement = images[i];
	        thumbnailElement.alt = file.name;
	        thumbnailElement.src = dataUrl;
	      }
	      setTimeout(function() { file.previewElement.classList.add("dz-image-preview"); }, 1);
	    }
	  }

	});
	



</script>
<style>

.quote-img img { 
  padding: 0;
  width: 100%;
  height: 70vh;
  opacity: 0.8;
  transition: 0.3s;
  
}

.padBetween { 
  padding-top:1%;
  padding-right:1.5%;
  
}

.centerAlign { 
  padding-left:30%;
  padding-right:30%;
  
}

.padRight { 
 padding-right:10%;
  
}

.dropzone {
    background: inherit;
    border-radius: 5px;
    border: 2px dashed rgb(0, 135, 247);
    border-image: none;
    max-width: 500px;
    margin-left: auto;
    margin-right: auto;
    
}

.btn-get-started1 {
  font-family: "Montserrat", sans-serif;
  margin-top:1.5%;
  letter-spacing: 1px;
  padding: 8px 8px;
  border-radius: 50px;
  transition: 0.5s;
  border: 2px solid #1E90FF;
  color: #1E90FF;
  
 }
 
 .btn-get-started1:hover {
  color: #FFF;
  background: #1E90FF;
}
</style>

  
</head>

<body style="overflow: hidden;">

  <!--==========================
    Header
  ============================-->
  <header id="header">
    <div class="container">

      <div id="logo" class="pull-left">
        <h1><a href="#intro" class="scrollto">QuoteEz</a></h1>
      </div>

      <nav id="nav-menu-container">
        <ul class="nav-menu">
          <li class="menu-active"><a href="#intro">Home</a></li>
          <li><a href="#about">Get Quote</a></li>
		   <li><a href="#faq">FAQs</a></li>
          <li><a href="#team">Team</a></li>
          <li><a href="#contact">Contact Us</a></li>
        </ul>
      </nav><!-- #nav-menu-container -->
    </div>
  </header><!-- #header -->

  <!--==========================
    Intro Section
  ============================-->
  <section id="intro">

    <div class="intro-text">
      <h2>Welcome to QuoteEz</h2>
      <p>
		  Easy to grab Quotation for vehicle. <br>
		  Getting quotation is as simple as uploading an image! <br>
	  </p>
      <a href="#about" class="btn-get-started scrollto">Get Started</a>
    </div>


    </div>

  </section><!-- #intro -->

  <main id="main">

    <!--==========================
      Get Quote
    ============================-->
    <section id="about" class="section-bg">
      <div class="container-fluid">
        <div class="section-header">
          <h3 class="section-title">Get Quote</h3>
          <span class="section-divider"></span>
          <p class="section-description">
            Upload Driver license number and the vehicle RegNo/VIN number images
          </p>
        </div>

        <div class="row">
          <div class="col-lg-6 content wow fadeInLeft">
            <SECTION>
			  <DIV id="dropzone">
				<form class="dropzone" id="demo-upload" action="dlImageToText" enctype="multipart/form-data" method="POST" >
				  <DIV class="dz-message" style="color: #00008B; font-size: medium;">    
					Drop files here or click to upload.<BR>
					<SPAN class="note needsclick">(Upload an image with <i> <Strong>Driving license number</Strong></i>)</SPAN>
				  </DIV>
				</form>
				<center><SPAN> <i> <Strong class="name">Driver license Image</Strong></i></SPAN></center>
			  </DIV>
			</SECTION>
          </div>
		  
		   <div class="col-lg-6 content wow fadeInRight">
            <SECTION>
			  <DIV id="dropzone">
				<form class="dropzone" id="demo-upload" action="vinImageToText" enctype="multipart/form-data" method="POST" >
				  <DIV class="dz-message" style="color: #00008B; font-size: medium;">    
					Drop files here or click to upload.<BR>
					<SPAN class="note needsclick">(Upload an image with <i><Strong>VIN number</Strong></i> or <i><Strong>Vehicle RegNo</Strong></i>)</SPAN>
				  </DIV>
				</form>
				<center ><SPAN ><i><Strong class="name">VIN Image</Strong></i> or <i><Strong class="name">Vehicle RegNo Image</Strong></i></SPAN></center>
			  </DIV>
			</SECTION>
          </div>
			      <a id="getDrivers" href="#features" class="btn-get-started scrollto">Go to Household</a>
			     <!--  <button onclick="goToHousehold()" class="btn-get-started scrollto">Household</button> -->

        </div>

      </div>
    </section><!-- #about -->

    <!--==========================
      Product Featuress Section
    ============================-->
    <section id="features">
      <div class="container-fluid">

        <div class="row">

          <div class="col-lg-8 offset-lg-4">
            <div class="section-header wow fadeIn" data-wow-duration="1s">
              <h3 class="section-title">Drivers in Household</h3>
              <span class="section-divider"></span>
            </div>
          </div>

          <div class="col-lg-4 col-md-5 features-img">
            <img src="${pageContext.request.contextPath}/resources/images/product-features.png" alt="" class="wow fadeInLeft">
          </div>

          <div class="col-lg-8 col-md-7 ">

              <div class="col-lg-6 col-md-6 box wow fadeInRight" id="divDriver0" style="visibility: hidden; display: none;" >
              <label class="checkbox">
				<input type="checkbox" id="checkBoxDriver0">
				<i class="fa fa-5x icon-checkbox"></i><label>
                <div class="icon"><i class="ion-person"></i></div>
                <h4 class="title" id="driver0"></h4>
                </label></label>
			  </div>
			   <div class="col-lg-6 col-md-6 box wow fadeInRight" id="divDriver1" style="visibility: hidden; display: none;" >
			   <label class="checkbox">
				<input type="checkbox" id="checkBoxDriver1">
				<i class="fa fa-5x icon-checkbox"></i><label>
                <div class="icon"><i class="ion-person"></i></div>
                <h4 class="title" id="driver1"></h4>
                </label></label>
			  </div>
          <div class="col-lg-6 col-md-6 box wow fadeInLeft" id="divDriver2" style="visibility: hidden; display: none;" >
          <label class="checkbox">
				<input type="checkbox" id="checkBoxDriver2">
				<i class="fa fa-5x icon-checkbox"></i><label>
                <div class="icon"><i class="ion-person"></i></div>
                <h4 class="title" id="driver2"></h4>
                </label></label>
              </div>
              <div class="col-lg-6 col-md-6 box wow fadeInLeft" id="divDriver3" style="visibility: hidden; display: none;" >
              <label class="checkbox">
				<input type="checkbox" id="checkBoxDriver3">
				<i class="fa fa-5x icon-checkbox"></i><label>
                <div class="icon"><i class="ion-person"></i></div>
                <h4 class="title" id="driver3"></h4>
                </label></label>
              </div>
              
			      <a id="getQuote" href="#pricing" class="btn-get-started scrollto">Get Quote</a>
            </div>
			
			

        </div>

      </div>

    </section><!-- #features -->

    <!--==========================
      Pricing Section
    ============================-->
   <section id="pricing" class="section-md">
      <div class="container-fluid">

  
		<div class="col-lg-3">
            
			  
			<div class="plan-container fadeInLeft">
			  <div class="plan-header">
				<div class="col-md-12 ">
					<div class="col-lg-6 vertical-divider">
						<div class="icon-box"><i class="fa fa-users icon"></i></div>
						<h2 id="primaryDriver">Edward Leo Mcmahon <i class="capt">(Primary)</i></h2>
					
					</div>
					<div class="col-lg-6">
						<div class="icon-box"><i class="fa fa-car icon"></i></div>
						<h2 id="vehicleModel">Chevrolet City Express <i class="capt">($55560)</i></h2>
					
					</div>
				</div>
				<div>
				<div class="icon-box"><i class="fa fa-calendar icon"></i></div>
					<h2></i>Effective Date: 02/26/2018<i class="capt"></i></h2>
				</div>
			  </div>
			  <div class="plan-details">
				<h5>Drivers in Household</h5>
				<ul id="householdDriversList">
				  <li id="householdDriver1"></li>
				  <li id="householdDriver2"></li>
				  <li id="householdDriver3"></li>
				</ul>
				<p id="primaryDriverAddress">750 GONZALEZ DR APT 6B, SAN FRANCISCO, CA 94512</p>
				<button><a href="#features" class="scrollto">Click here to Customize Driver Selection</a></button>
			  </div>
			</div>
			
          </div>

          <div class="col-md-9">
		  
			  <div class="section-header" >
				<h2 class="section-title" style="margin-bottom: 0px;margin-top: 0px;">Approximate Quote</h2>
				<p class="section-description" style="padding-bottom: 0px;margin-bottom: 10px;">Below are the apporx. quotation for the given drivers and vehicle.
			  </div> <!-- End of Section header -->
			
			<div class="row">

			  <div class="col-lg-4">
				<div class="box wow fadeInLeft">
				  <h3>Insurer One</h3>
				 <h4><sup>$</sup><i id="basicPremimumInsurerOne"></i><span> /month</span></h4>
					  <h5><sup>$</sup><i id="sixMonthsPremimumInsurerOne"></i><span> /6 months</span></h5>
				  <a href="#" class="get-started-btn">Buy</a>
				</div>
			  </div>

			  <div class="col-lg-4">
				<div class="box wow fadeInUp">
				  <h3>Insurer Two</h3>
					<h4 ><sup>$</sup><i id="basicPremimumInsurerTwo"></i><span> /month</span></h4>
					  <h5><sup>$</sup><i id="sixMonthsPremimumInsurerTwo"></i><span> /6 months</span></h5>
				  <a href="#" class="get-started-btn">Buy</a>
				</div>
			  </div>

			  <div class="col-lg-4">
				<div class="box wow fadeInRight">
				  <h3>Insurer Three</h3>
				  <h4><sup>$</sup><i id="basicPremimumInsurerThree"></i><span> /month</span></h4>
					  <h5><sup>$</sup><i id="sixMonthsPremimumInsurerThree"></i><span> /6 months</span></h5>
				  <a href="#" class="get-started-btn">Buy</a>
				</div>
			  </div>

			</div>	 <!--  End  of Row - Insurer Names  -->
		  
			<div class="row padBetween fadeInUp"> <!-- Beginning of coverage sliders row-->

				<div class="box col-md-12 wow ">
				  <h3>Coverage Customization</h3>
				   			 
						<div class="boxRound wow">
							<div class="col-lg-4">
								<h5>Liability: <span id="covergaePrice1">25$</span></h5>
							</div>
							
							<div class = "col-lg-8">
							
								<div class="range1">
								  <input type="range" min="1" max="7" steps="1" value="1">
								</div>

								<ul class="range-labels1">
								  <li class="active selected">25$</li>
								  <li>100$</li>
								  <li>250$</li>
								  <li>500$</li>
								  <li>750$</li>
								  <li>1000$</li>
								  <li>2000$</li>
								</ul>						
							</div>					  
					    </div>
				

						<div class="boxRound wow">
							<div class="col-lg-4">
								<h5>Collision: <span id="covergaePrice2">25$</span></h5>
							</div>
							
							<div class = "col-lg-8">
							
								<div class="range2">
								  <input type="range" min="1" max="7" steps="1" value="1">
								</div>

								<ul class="range-labels2">
								  <li class="active selected">25$</li>
								  <li>100$</li>
								  <li>250$</li>
								  <li>500$</li>
								  <li>750$</li>
								  <li>1000$</li>
								  <li>2000$</li>
								</ul>						
							</div>					  
					    </div>

						<div class="boxRound wow">
							<div class="col-lg-4">
								<h5>Comprehensive: <span id="covergaePrice3">25$</span></h5>
							</div>
							
							<div class = "col-lg-8">
							
								<div class="range3">
								  <input type="range" min="1" max="7" steps="1" value="1">
								</div>

								<ul class="range-labels3">
								  <li class="active selected">25$</li>
								  <li>100$</li>
								  <li>250$</li>
								  <li>500$</li>
								  <li>750$</li>
								  <li>1000$</li>
								  <li>2000$</li>
								</ul>						
							</div>					  
					    </div>						
						
				</div>
			

			</div>	 <!--  End  Coverage sliders row  -->
		  
			<div class="row centerAlign buttons">
 
				<button class=" slide scrollto"> <a href="#about">Get Another Quote</a> </button>
				 
			</div>	 <!--  End  of Row - buttons  -->
		  					
				
          </div> <!-- End of col-lg-8 for insurers and coverage details-->
			 
      </div> <!-- End of container -->
    </section><!-- #pricing -->


    <!--==========================
      Frequently Asked Questions Section
    ============================-->
    <section id="faq">
      <div class="container">

        <div class="section-header">
          <h3 class="section-title">Frequently Asked Questions</h3>
          <span class="section-divider"></span>
        </div>

        <ul id="faq-list" class="wow fadeInUp">
          <li>
            <a data-toggle="collapse" class="collapsed" href="#faq1">What does auto insurance cover? <i class="ion-android-remove"></i></a>
            <div id="faq1" class="collapse" data-parent="#faq-list">
              <p>
                Auto insurance covers you, your vehicle and others involved in a vehicular accident.
              </p>
            </div>
          </li>

          <li>
            <a data-toggle="collapse" href="#faq2" class="collapsed">What happens if I lie about my driving history? <i class="ion-android-remove"></i></a>
            <div id="faq2" class="collapse" data-parent="#faq-list">
              <p>
                If you lie about your driving history, the DMV reports that you are committing what is known as “soft fraud.” If you do lie, the insurance company can deny you services and cancel your coverage.
              </p>
            </div>
          </li>

          <li>
            <a data-toggle="collapse" href="#faq3" class="collapsed">Are there different insurance coverage types? <i class="ion-android-remove"></i></a>
            <div id="faq3" class="collapse" data-parent="#faq-list">
              <p>
                Yes, there are different insurance coverage types and they are as follows: Bodily Liability, Property Damage Liability, Comprehensive, Collision and Uninsured & Underinsured.
              </p>
            </div>
          </li>

          <li>
            <a data-toggle="collapse" href="#faq4" class="collapsed">Is auto insurance mandatory? <i class="ion-android-remove"></i></a>
            <div id="faq4" class="collapse" data-parent="#faq-list">
              <p>
                Yes, auto insurance is mandatory in every state across the U.S., but insurance carrying laws vary. To make sure you have the right insurance, visit your state government’s transportation website.
              </p>
            </div>
          </li>

          <li>
            <a data-toggle="collapse" href="#faq5" class="collapsed">What happens if I don’t get auto insurance? <i class="ion-android-remove"></i></a>
            <div id="faq5" class="collapse" data-parent="#faq-list">
              <p>
                If you get in an accident and you’re uninsured, you face getting sued, losing your life’s savings and getting jail time.
              </p>
            </div>
          </li>

          <li>
            <a data-toggle="collapse" href="#faq6" class="collapsed">How expensive is auto insurance? <i class="ion-android-remove"></i></a>
            <div id="faq6" class="collapse" data-parent="#faq-list">
              <p>
                Auto insurance is relatively inexpensive, but this depends on your driving history and credit report.
              </p>
            </div>
          </li>

        </ul>

      </div>
    </section><!-- #faq -->

 
   <!--==========================
      Our Team Section
    ============================-->
    <section id="team" class="section-bg">
      <div class="container">
        <div class="section-header">
          <h3 class="section-title">Our Team</h3>
          <span class="section-divider"></span>
        </div>
        <div class="row wow fadeInUp">
          <div class="col-lg-1 col-md-6">
		  </div>
		  
		  <div class="col-lg-2 col-md-6">
            <div class="member">
              <div class="pic"><img src="${pageContext.request.contextPath}/resources/images/team/phani.jpg" alt=""></div>
              <h4>Phanindra Uppalapati</h4>
              <span>Developer</span>
              <div class="social">
                <a href=""><i class="fa fa-twitter"></i></a>
                <a href=""><i class="fa fa-facebook"></i></a>
                <a href=""><i class="fa fa-google-plus"></i></a>
                <a href=""><i class="fa fa-linkedin"></i></a>
              </div>
            </div>
          </div>

          
		  <div class="col-lg-2 col-md-6">
            <div class="member">
              <div class="pic"><img src="${pageContext.request.contextPath}/resources/images/team/kumar1.jpg" alt=""></div>
              <h4>Kumaravel V</h4>
              <span>Developer</span>
              <div class="social">
                <a href=""><i class="fa fa-twitter"></i></a>
                <a href=""><i class="fa fa-facebook"></i></a>
                <a href=""><i class="fa fa-google-plus"></i></a>
                <a href=""><i class="fa fa-linkedin"></i></a>
              </div>
            </div>
          </div>

          <div class="col-lg-2 col-md-6">
            <div class="member">
              <div class="pic"><img src="${pageContext.request.contextPath}/resources/images/team/anu.jpg" alt=""></div>
              <h4>Anupriya</h4>
              <span>Quality Analyst</span>
              <div class="social">
                <a href=""><i class="fa fa-twitter"></i></a>
                <a href=""><i class="fa fa-facebook"></i></a>
                <a href=""><i class="fa fa-google-plus"></i></a>
                <a href=""><i class="fa fa-linkedin"></i></a>
              </div>
            </div>
          </div>

          <div class="col-lg-2 col-md-6">
            <div class="member">
              <div class="pic"><img src="${pageContext.request.contextPath}/resources/images/team/venkat1.jpg" alt=""></div>
              <h4>Venkatesh E</h4>
              <span>Tester</span>
              <div class="social">
                <a href=""><i class="fa fa-twitter"></i></a>
                <a href=""><i class="fa fa-facebook"></i></a>
                <a href=""><i class="fa fa-google-plus"></i></a>
                <a href=""><i class="fa fa-linkedin"></i></a>
              </div>
            </div>
          </div>
         
		  <div class="col-lg-2 col-md-6">
            <div class="member">
              <div class="pic"><img src="${pageContext.request.contextPath}/resources/images/team/sundar.jpg" alt=""></div>
              <h4>Sundaresan N</h4>
              <span>Mentor</span>
              <div class="social">
                <a href=""><i class="fa fa-twitter"></i></a>
                <a href=""><i class="fa fa-facebook"></i></a>
                <a href=""><i class="fa fa-google-plus"></i></a>
                <a href=""><i class="fa fa-linkedin"></i></a>
              </div>
            </div>
          </div>
        </div>

      </div>
    </section><!-- #team -->


    <!--==========================
      Contact Section
    ============================-->
    <section id="contact">
      <div class="container">
        <div class="row wow fadeInUp">

          <div class="col-lg-4 col-md-4">
            <div class="contact-about">
              <h3>QuoteEz</h3>
              <p>We're ready to help you to know approx quote for your vehicle</p>
              <div class="social-links">
                <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
                <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
                <a href="#" class="instagram"><i class="fa fa-instagram"></i></a>
                <a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a>
                <a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-4">
            <div class="info">
              <div>
                <i class="ion-ios-location-outline"></i>
                <p>Semmencherry<br>Chennai, Tamilanadu 60119</p>
              </div>

              <div>
                <i class="ion-ios-email-outline"></i>
                <p>info@quoteez.com</p>
              </div>

              <div>
                <i class="ion-ios-telephone-outline"></i>
                <p>1800 22 2222</p>
              </div>

            </div>
          </div>

          <div class="col-lg-5 col-md-8">
            <div class="form">
              <div id="sendmessage">Your message has been sent. Thank you!</div>
              <div id="errormessage"></div>
              <form action="" method="post" role="form" class="contactForm">
                <div class="form-row">
                  <div class="form-group col-lg-6">
                    <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                    <div class="validation"></div>
                  </div>
                  <div class="form-group col-lg-6">
                    <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
                    <div class="validation"></div>
                  </div>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                  <textarea class="form-control" name="message" rows="5" data-rule="required" data-msg="Please write something for us" placeholder="Message"></textarea>
                  <div class="validation"></div>
                </div>
                <div class="text-center"><button type="submit" title="Send Message">Send Message</button></div>
              </form>
            </div>
          </div>

        </div>

      </div>
    </section><!-- #contact -->

  </main>

  <!--==========================
    Footer
  ============================-->
  <footer id="footer">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 text-lg-left text-center">
          <div class="copyright">
            &copy; Copyright <strong>QuoteEz</strong>. All Rights Reserved
          </div>
      
        </div>
        <div class="col-lg-6">
          <nav class="footer-links text-lg-right text-center pt-2 pt-lg-0">
            <a href="#intro" class="scrollto">Home</a>
            <a href="#about" class="scrollto">About</a>
            <a href="#">Privacy Policy</a>
            <a href="#">Terms of Use</a>
          </nav>
        </div>
      </div>
    </div>
  </footer><!-- #footer -->

  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

  <!-- JavaScript Libraries -->
  <script src="${pageContext.request.contextPath}/resources/lib/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/lib/jquery/jquery-migrate.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/lib/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/lib/easing/easing.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/lib/wow/wow.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/lib/superfish/hoverIntent.js"></script>
  <script src="${pageContext.request.contextPath}/resources/lib/superfish/superfish.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/lib/magnific-popup/magnific-popup.min.js"></script>

  <!-- Contact Form JavaScript File -->
  <script src="${pageContext.request.contextPath}/resources/contactform/contactform.js"></script>

  <!-- Template Main Javascript File -->
  <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</body>
</html>
    
