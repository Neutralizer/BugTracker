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
<title>Add defect</title>

	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styleDefect.css" rel="stylesheet">


</head>

<body>

<c:url value="/j_spring_security_logout" var="logoutUrl" />

	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>




<div class="row navbar navbar-static-top">
			<div class="col-xs-8">
				<h1 class="text-right">Welcome to BUGTRACKER</h1>
			</div>
			<div class="col-xs-4">
			<ul class="nav navbar-top-links navbar-right">
				<li>
                    <a href="javascript:formSubmit()">
                        Log out
                    </a>
                </li>
            </ul>
				
			</div>
		</div>

<div id="wrapper">

		
		
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
    <div class="middle-box text-center animated fadeInDown">
    </div>
        <div class="wrapper wrapper-content animated fadeInRight">
	
            <div class="row">
                <div class="col-lg-12">
                    <div class="tabs-container">
						<div class="tab-content">
							<div id="tab-1" class="tab-pane active">
								<div class="ibox">
										<div class="ibox-title">
											<h2>Add defect</h2>
										</div>
									<div class="panel-body">
									
									
										<fieldset class="form-horizontal">
										<form:form action="${pageContext.request.contextPath}/defect/add" method="POST">
											<div class="form-group"><label class="col-sm-2 control-label">Title:</label>
												<div class="col-sm-10"><input type="text" name="title"  class="form-control" placeholder="Title..."></div>
											</div>
											<div class="form-group"><label class="col-sm-2 control-label">Description:</label>
												<div class="col-sm-10">
													<textarea class="form-control"  name="description" >
														
													</textarea>
												</div>
											</div>
											<div class="form-group"><label class="col-sm-2 control-label">Assigned to:</label>
												<div class="col-sm-10"><input type="text" name="assignedTo" class="form-control" placeholder="Assigned to..."></div>
											</div>
											<div class="form-group"><label class="col-sm-2 control-label">Severity:</label>
												<div class="col-sm-10">
													<select class="form-control m-b" name="severity">
														<c:forEach items="${allSeverity}" var="severity">     										
								 							<option value="${severity}">${severity}</option>
														</c:forEach> 
													</select>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-10 col-sm-offset-2">
													<button class="btn btn-primary" type="submit">Save changes</button>
												</div>
											</div>
											</form:form>
											
											<div class="form-group">
												<div class="col-sm-10 col-sm-offset-2">
											<button class="btn btn-white" 
													onclick="location.href='${pageContext.request.contextPath}/defect'">Cancel</button>
												</div>
											</div>
										</fieldset>
										
									</div>
								</div>
							</div>
						</div>
                    </div>
                </div>
            </div>

        </div>
</div>





    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/inspinia.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/pace.min.js"></script>




<!-- 	<div class="col-sm-5 form-box"> -->
<!-- 		<div class="form-top"> -->
<!-- 			<div class="form-top-right"> -->
<!-- 				<i class="fa fa-pencil"></i> -->
<!-- 			</div> -->
<!-- 		</div> -->
<%-- 		<form:form action="${pageContext.request.contextPath}/defect/add" method="POST"> --%>
		
<%-- 		<c:if test="${not empty error}"> --%>
<%-- 			<div class="error">${error}</div> --%>
<%-- 		</c:if> --%>
		
<!-- 			<div class="form-bottom"> -->
<!-- 					<div class="form-group"> -->
<!-- 						<h5>Title</h5> -->
<!-- 						<input type="text" name="title"	 -->
<!-- 						class="form-control" > -->
<!-- 					</div> -->
<!-- 					<div class="form-group"> -->
<!-- 						<h5>Description</h5> -->
<!-- 						<input type="text" name="description" -->
<!-- 							class="form-control" > -->
<!-- 					</div> -->

<!-- 					<div class="form-group"> -->
<!-- 						<h5>Assigned to</h5> -->
<!-- 						<input type="text" name="assignedTo" -->
<!-- 							class="form-control" > -->
<!-- 					</div> -->
					
				
<!-- 					<div class="form-group"> -->
<!-- 						<h5>Severity</h5> -->
<!-- 						<select class="form-control" name=severity > -->
<%-- 							<c:forEach items="${allSeverity}" var="severity">     										 --%>
<%-- 	 							<option value="${severity}">${severity}</option> --%>
<%-- 							</c:forEach>  --%>
<!-- 						</select> -->
<!-- 					</div> -->
<!-- 					<input type="submit" class="btn" value="Add" /> -->
<!-- 			</div> -->
<%-- 		</form:form> --%>
<!-- 		<button class="btn btn-primary" -->
<%-- 			onclick="location.href='${pageContext.request.contextPath}/defect'">Return to Defect Listing</button> --%>
<!-- 	</div> -->
	

<!-- 	<!-- Javascript -->
<!-- 	<script src="assets/js/jquery-1.11.1.min.js"></script> -->
<!-- 	<script src="assets/bootstrap/js/bootstrap.min.js"></script> -->
<!-- 	<script src="assets/js/jquery.backstretch.min.js"></script> -->
<!-- 	<script src="assets/js/retina-1.1.0.min.js"></script> -->
<!-- 	<script src="assets/js/scripts.js"></script> -->



</body>

</html>