<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
</style>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit defect</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="/resources/core/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>

<body>

	<div class="col-sm-5 form-box">
		<div class="form-top">
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>
		<form:form action="${pageContext.request.contextPath}/defect/add" method="POST">
		
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		
			<div class="form-bottom">
					<div class="form-group">
						<h5>Title</h5>
						<input type="text" name="title"	
						class="form-control" >
					</div>
					<div class="form-group">
						<h5>Description</h5>
						<input type="text" name="description"
							class="form-control" >
					</div>

					<div class="form-group">
						<h5>Assigned to</h5>
						<input type="text" name="assignedTo"
							class="form-control" >
					</div>
					
				
					<div class="form-group">
						<h5>Severity</h5>
						<select class="form-control" name=severity >
							<c:forEach items="${allSeverity}" var="severity">     										
	 							<option value="${severity}">${severity}</option>
							</c:forEach> 
						</select>
					</div>
					<input type="submit" class="btn" value="Add" />
			</div>
		</form:form>
		<button class="btn btn-primary"
			onclick="location.href='${pageContext.request.contextPath}/defect'">Return to Defect Listing</button>
	</div>

	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/retina-1.1.0.min.js"></script>
	<script src="assets/js/scripts.js"></script>

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>

</html>