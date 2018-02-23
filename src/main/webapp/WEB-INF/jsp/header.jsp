<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%-- <c:set var="appContext" value="${pageContext.request.contextpath}"></c:set>  --%>
<html>
<body>
	<div class="row">
		<div class="col-md-3" align="right" style="margin-top: 20px">
			
			<img src="${pageContext.request.contextPath}/resources/images/logo.jpg" width="200" height="80">
				
		</div>
		<div class="col-md-9" align="right" style="font-size: 16px;">
			<ul class="nav nav-pills" class="col-md-3" style="margin-top: 50px">
				<li role="presentation" class="active"><a href="#">Home</a></li>
				<li role="presentation"><a href="#">Know your Insurance</a></li>
				<li role="presentation"><a href="#">Add Drivers</a></li>
				<li role="presentation"><a href="#">Quote History</a></li>
				<li role="presentation"><a href="#">Support</a></li>
				<li role="presentation"><a href="#">About us</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">My Account<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">My profile</a></li>
						<li><a href="#">Password Management</a></li>
						<li><a href="#">Logout</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	

</body>
</html>