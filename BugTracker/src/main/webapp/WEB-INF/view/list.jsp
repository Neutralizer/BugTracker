<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

	<title>BugTracker | Defect list</title>

	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">

    <!-- Toastr style -->
    <link href="${pageContext.request.contextPath}/resources/css/toastr.min.css" rel="stylesheet">

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

		
		
        <div class="wrapper wrapper-content  animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>Issue list</h5>
                            
                            <sec:authorize access="hasRole('ADMIN') or hasRole('QA')">
                            <div class="ibox-tools">
                                <a href="${pageContext.request.contextPath}/defect/add" class="btn btn-primary btn-xs">Add new issue</a>
                            </div>
                            </sec:authorize>
                            
                            
                        </div>
                        <div class="ibox-content">
                        
                        <form:form action="${pageContext.request.contextPath}/defect" method="POST">

                            <div class="m-b-lg">

                                <div class="input-group">
                                    <input type="text" placeholder="Search issue by name..." class=" form-control"
                                     name="name" value="${searchedValue}">
                                    <span class="input-group-btn">
<!--                                         <button type="button" class="btn btn-white"> Search</button> -->
                                        <input class="btn btn-default" type="submit" value="Search"/>
                                    </span>
                                </div>
<!--                                 <div class="m-t-md"> -->
<!--                                     <strong>Found 3 issues.</strong> -->
<!--                                 </div> -->

                            </div>
                            
                        </form:form >


                            <div class="table-responsive">
                            <table class="table table-hover issue-tracker">
                                <tbody>
<!-- 								 <thead> -->
<!-- 									<tr> -->
<!-- 										<th>Id</th> -->
<!-- 										<th>Title</th> -->
<!-- 										<th>Severity</th> -->
<!-- 										<th>Status</th> -->
<!-- 										<th></th> -->
<!-- 										<th></th> -->
<!-- 										<th></th> -->
<!-- 									</tr> -->
<!-- 								</thead> -->

								<tr>
                                    <td>
                                        <h3>Id</h3>
                                    </td>
                                    <td>
                                        <h3>Title</h3>
                                    </td>
                                    <td>
                                        <h3>Severity</h3>
                                    </td>
                                    <td>
                                        <h3>Status</h3>
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                                
                        <c:forEach items="${defectList}" var="defect">
							<tr>
								<td>${defect.id}</td>
								<td>${defect.title}</td>
								<td>${defect.severity}</td>
								<td>${defect.status}</td>
								<td>
									<button class="btn btn-primary"
										onclick="location.href='${pageContext.request.contextPath}/defect/view?id=${defect.id}'">View</button>
								<sec:authorize access="hasRole('ADMIN') or hasRole('QA')">
									<button class="btn btn-primary"
										onclick="location.href='${pageContext.request.contextPath}/defect/edit?id=${defect.id}'">Edit</button>
									<button class="btn btn-danger"
										onclick="location.href='${pageContext.request.contextPath}/defect/delete?id=${defect.id}'">Delete</button>
								</sec:authorize>
								</td>
							</tr>
						</c:forEach>
                               
							
                                </tbody>
                            </table>
                            </div>
                        </div>

                    </div>
                </div>
            </div>


        </div>














<%-- 	<c:url value="/j_spring_security_logout" var="logoutUrl" /> --%>

<%-- 	<form action="${logoutUrl}" method="post" id="logoutForm"> --%>
<%-- 		<input type="hidden" name="${_csrf.parameterName}" --%>
<%-- 			value="${_csrf.token}" /> --%>
<%-- 	</form> --%>

<!-- 	<script> -->
<!-- // 		function formSubmit() { -->
<!-- // 			document.getElementById("logoutForm").submit(); -->
<!-- // 		} -->
<!-- 	</script> -->
		
<!-- 	<div class="container"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-lg-12"> -->
			
<!-- 				<h3>Defect List</h3> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
<%-- 		<form:form action="${pageContext.request.contextPath}/defect" method="POST"> --%>
<!-- 			<div class="col-lg-4 col-lg-offset-4"> -->
<!-- 				<div class="input-group"> -->
<%-- 					<input type="text" class="form-control" name="name" value="${searchedValue}" placeholder="Search for issue"> --%>
<!-- 					<span class="input-group-btn"> -->
<!-- 						<input class="btn btn-default" type="submit" value="Search"/> -->
<!-- 					</span> -->
<!-- 				</div> -->
<!-- 				/input-group -->
<!-- 			</div> -->
<!-- 			<!-- /.col-lg-6 -->

<%-- 		</form:form > --%>
		
				
<!-- 		<div class="row"> -->
<!-- 			<div class="col-lg-12"> -->
<!-- 				<table class="table" id="table"> -->
<!-- 					<thead> -->
<!-- 						<tr> -->
<!-- 							<th>Id</th> -->
<!-- 							<th>Title</th> -->
<!-- 							<th>Severity</th> -->
<!-- 							<th>Status</th> -->
<!-- 						</tr> -->
<!-- 					</thead> -->
<!-- 					<tbody> -->
<%-- 						<c:forEach items="${defectList}" var="defect"> --%>
<!-- 							<tr> -->
<%-- 								<td>${defect.id}</td> --%>
<%-- 								<td>${defect.title}</td> --%>
<%-- 								<td>${defect.severity}</td> --%>
<%-- 								<td>${defect.status}</td> --%>
<!-- 								<td> -->
<!-- 									<button class="btn btn-primary" -->
<%-- 										onclick="location.href='${pageContext.request.contextPath}/defect/view?id=${defect.id}'">View</button> --%>
<%-- 								<sec:authorize access="hasRole('ADMIN') or hasRole('QA')"> --%>
<!-- 									<button class="btn btn-primary" -->
<%-- 										onclick="location.href='${pageContext.request.contextPath}/defect/edit?id=${defect.id}'">Edit</button> --%>
<!-- 									<button class="btn btn-danger" -->
<%-- 										onclick="location.href='${pageContext.request.contextPath}/defect/delete?id=${defect.id}'">Delete</button> --%>
<%-- 								</sec:authorize> --%>
<!-- 								</td> -->
<!-- 							</tr> -->
<%-- 						</c:forEach> --%>
<!-- 					</tbody> -->
<!-- 				</table> -->
<!-- 				<hr> -->
<!-- 			</div> -->
<!-- 		</div> -->
<%-- 		<sec:authorize access="hasRole('ADMIN') or hasRole('QA')"> --%>
<!-- 			<button class="btn btn-primary" -->
<%-- 				onclick="location.href='${pageContext.request.contextPath}/defect/add'">Add issue</button> --%>
<%-- 		</sec:authorize> --%>
<!-- 		<p> </p> -->
<!-- 		<div class="col-lg-4 col-lg-offset-4" align="left"> -->
<!-- 			<button class="btn btn-danger" -->
<!-- 				onclick="location.href='javascript:formSubmit()'">Logout</button> -->
<!-- 		</div> -->
<!--  			<button class="btn btn-primary" -->
<!-- 				onclick="location.href='/'">Return to Main</button> --> 
<!-- 	</div> -->
	

<!-- Mainly scripts -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="${pageContext.request.contextPath}/resources/js/inspinia.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/pace.min.js"></script>

    <!-- Peity -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.peity.min.js"></script>

    <!-- Peity demo data -->
    <script src="${pageContext.request.contextPath}/resources/js/peity-demo.js"></script>

	
</body>
</html>