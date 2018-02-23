<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Policy</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
<style type="text/css">
body  {
    background-size: 90%;
    background-color: white;
    background-repeat: no-repeat;
    background-position: top; 
}
</style>
</head>
<body background="${pageContext.request.contextPath}/resources/images/cov.jpg">
<div align="left" style="margin-top: 150px ;margin-left:80px; font-size: large;color: #00008B;">
<p>Vehicle and Driver Details</p>
<c:forEach var="imageTextMap" items="${imageMap}">
     ${imageTextMap.key} -  ${imageTextMap.value}
     <br>
</c:forEach>

</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>