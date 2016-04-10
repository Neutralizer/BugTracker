<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
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
		
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
			
				<h3>Defect List</h3>
			</div>
		</div>
		
		<form:form action="${pageContext.request.contextPath}/defect" method="POST">
			<div class="col-lg-4 col-lg-offset-4">
				<div class="input-group">
					<input type="text" class="form-control" name="name" value="${searchedValue}" placeholder="Search for issue">
					<span class="input-group-btn">
						<input class="btn btn-default" type="submit" value="Search"/>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->

		</form:form >
		
				
		<div class="row">
			<div class="col-lg-12">
				<table class="table" id="table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Title</th>
							<th>Severity</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
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
				<hr>
			</div>
		</div>
		<sec:authorize access="hasRole('ADMIN') or hasRole('QA')">
			<button class="btn btn-primary"
				onclick="location.href='${pageContext.request.contextPath}/defect/add'">Add issue</button>
		</sec:authorize>
		<p> </p>
		<div class="col-lg-4 col-lg-offset-4" align="left">
			<button class="btn btn-danger"
				onclick="location.href='javascript:formSubmit()'">Logout</button>
		</div>
<!-- 			<button class="btn btn-primary" -->
<!-- 				onclick="location.href='/'">Return to Main</button> -->
	</div>
	



	<script src="/dist/jquery.searchable-1.0.0.min.js"></script>
</body>
</html>