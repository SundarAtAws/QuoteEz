<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>QuoteEz</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://rawgit.com/enyo/dropzone/master/dist/dropzone.js"></script>
<link rel="stylesheet" href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css">

<script>
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
body  {
    background-image:url("${pageContext.request.contextPath}/resources/images/bg1.png");
    background-position: inherit;
    background-size: cover;
    background-color: white;
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
.footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: yellow;
    color: white;
    text-align: center;
}

</style>
  </head>
 <body>
 <div class="container-fluid" >
<%-- <jsp:include page="header.jsp"></jsp:include>
 --%><br>
<div class= "col-md-6 col-md-offset-3" style="margin-top:250px;left: 300px; " >
<SECTION>
  <DIV id="dropzone">
    <form class="dropzone" id="demo-upload" action="imageToText" enctype="multipart/form-data" method="POST" >
      <DIV class="dz-message" style="color: #00008B; font-size: medium;">    
        Drop files here or click to upload.<BR>
        <SPAN class="note needsclick">(Upload a image with <i><Strong>VIN number</Strong></i> 
        or <i><Strong>Drivinglicense number</Strong></i>)</SPAN>
      </DIV>
    </form>
  </DIV>
</SECTION>

<br/>
<hr size="3" noshade color="#F00000">
<DIV id="preview-template" style="display: none;">
<DIV class="dz-preview dz-file-preview">
<DIV class="dz-image"><IMG data-dz-thumbnail=""></DIV>
<DIV class="dz-details">
<DIV class="dz-size"><SPAN data-dz-size=""></SPAN></DIV>
<DIV class="dz-filename"><SPAN data-dz-name=""></SPAN></DIV></DIV>
<DIV class="dz-progress"><SPAN class="dz-upload" 
data-dz-uploadprogress=""></SPAN></DIV>
<DIV class="dz-error-message"><SPAN data-dz-errormessage=""></SPAN></DIV>
<div class="dz-success-mark">
  <svg width="54px" height="54px" viewBox="0 0 54 54" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:sketch="http://www.bohemiancoding.com/sketch/ns">
    <title>Check</title>
    <desc>Created with Sketch.</desc>
    <defs></defs>
    <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage">
        <path d="M23.5,31.8431458 L17.5852419,25.9283877 C16.0248253,24.3679711 13.4910294,24.366835 11.9289322,25.9289322 C10.3700136,27.4878508 10.3665912,30.0234455 11.9283877,31.5852419 L20.4147581,40.0716123 C20.5133999,40.1702541 20.6159315,40.2626649 20.7218615,40.3488435 C22.2835669,41.8725651 24.794234,41.8626202 26.3461564,40.3106978 L43.3106978,23.3461564 C44.8771021,21.7797521 44.8758057,19.2483887 43.3137085,17.6862915 C41.7547899,16.1273729 39.2176035,16.1255422 37.6538436,17.6893022 L23.5,31.8431458 Z M27,53 C41.3594035,53 53,41.3594035 53,27 C53,12.6405965 41.3594035,1 27,1 C12.6405965,1 1,12.6405965 1,27 C1,41.3594035 12.6405965,53 27,53 Z" id="Oval-2" stroke-opacity="0.198794158" stroke="#747474" fill-opacity="0.816519475" fill="#FFFFFF" sketch:type="MSShapeGroup"></path>
    </g>
  </svg>
</div>
<div class="dz-error-mark">
  <svg width="54px" height="54px" viewBox="0 0 54 54" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:sketch="http://www.bohemiancoding.com/sketch/ns">
      <title>error</title>
      <desc>Created with Sketch.</desc>
      <defs></defs>
      <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage">
          <g id="Check-+-Oval-2" sketch:type="MSLayerGroup" stroke="#747474" stroke-opacity="0.198794158" fill="#FFFFFF" fill-opacity="0.816519475">
              <path d="M32.6568542,29 L38.3106978,23.3461564 C39.8771021,21.7797521 39.8758057,19.2483887 38.3137085,17.6862915 C36.7547899,16.1273729 34.2176035,16.1255422 32.6538436,17.6893022 L27,23.3431458 L21.3461564,17.6893022 C19.7823965,16.1255422 17.2452101,16.1273729 15.6862915,17.6862915 C14.1241943,19.2483887 14.1228979,21.7797521 15.6893022,23.3461564 L21.3431458,29 L15.6893022,34.6538436 C14.1228979,36.2202479 14.1241943,38.7516113 15.6862915,40.3137085 C17.2452101,41.8726271 19.7823965,41.8744578 21.3461564,40.3106978 L27,34.6568542 L32.6538436,40.3106978 C34.2176035,41.8744578 36.7547899,41.8726271 38.3137085,40.3137085 C39.8758057,38.7516113 39.8771021,36.2202479 38.3106978,34.6538436 L32.6568542,29 Z M27,53 C41.3594035,53 53,41.3594035 53,27 C53,12.6405965 41.3594035,1 27,1 C12.6405965,1 1,12.6405965 1,27 C1,41.3594035 12.6405965,53 27,53 Z" id="Oval-2" sketch:type="MSShapeGroup"></path>
          </g>
      </g>
  </svg>
</div>
   </div>
</div>
</div>
<div class= "col-md-6 col-md-offset-3 " align="right" style="left: 80px;">
<form action="quote" method="post">
<button type="submit" class="btn btn-success btn-lg" id="submit" name="submit">Snap a Quote</button>
</form>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>