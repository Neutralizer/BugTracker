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

	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styleDefect.css" rel="stylesheet">


</head>

<body>

    <div class="middle-box text-center animated fadeInDown">
        <h2>This view is under development...</h2>
    </div>

	<div class="col-sm-5 form-box">
		<div class="form-top">
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>
		<form:form action="${pageContext.request.contextPath}${defectAction}" method="POST">
<%-- 		<form:form action="/defect/edit" method="POST"> --%>
		
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		
		<div class="form-bottom">
		
				<div class="form-group">
					<h5>Id</h5>
					<input type="text" name="title" value="${defect.id}" disabled
					class="form-first-name form-control" id="form-first-name">
				</div>
				
				<div class="form-group">
					<h5>Title</h5>
					<input type="text" name="title" value="${defect.title}"	${disabled}
					class="form-first-name form-control" id="form-first-name">
				</div>
				
				<div class="form-group">
					<h5>Description - long</h5>
					
					<input type="text" size="80" name="description" 
					value="${defect.description}" ${disabled}
						class="form-last-name form-control" id="form-last-name">
				</div>
				
				<div class="form-group">
					<h5>Author</h5>
					<input type="text" name="title" value="${defect.author}" disabled	
					class="form-first-name form-control" id="form-first-name">
				</div>
				
				<div class="form-group">
					<h5>Date created</h5>
					<input type="text" name="title" value="${defect.dateCreated}" disabled
					class="form-first-name form-control" id="form-first-name">
				</div>
				
				<div class="form-group">
					<h5>Last changed date</h5>
					<input type="text" name="title" value="${defect.lastChangedDate}" disabled
					class="form-first-name form-control" id="form-first-name">
				</div>
				
				<div class="form-group">
					<h5>Assigned to</h5>
					<input type="text" name="assignedTo" value="${defect.assignedTo}"	
					class="form-first-name form-control" id="form-first-name">
				</div>
				
				<div class="form-group">
					<h5>Status</h5>
					<select class="form-control" name=status >
							<c:forEach items="${allStatus}" var="status">     										
	 							<option value="${status}" 
	 					${status == defect.status? 'selected' : ''}>${status}</option>
							</c:forEach> 
					</select>
				</div>
				
				<div class="form-group">
					<h5>Severity</h5>
						<select class="form-control" name=severity  ${disabled}>
							<c:forEach items="${allSeverity}" var="severity">     										
	 							<option value="${severity}" 
	 					${severity == defect.severity? 'selected' : ''}>${severity}</option>
							</c:forEach> 
						</select>
				</div>
				
				<table class="table" id="table">
					<c:forEach items="${commentList}" var="comments">
							<tr>
							<td>${comments.creationDate} </td>
							<td>${comments.author} - ${comments.text}</td>
							</tr>
					</c:forEach>
							
				</table>
					<input type="text" size="80" name="comment" placeholder="add new comment"
					class="form-first-name form-control" id="form-first-name">
				<br/>
				<input type="hidden" name="id"  value="${defect.id}"> 
				<input type="submit" class="btn" value="Apply" />
		</div>
		</form:form>
		<button class="btn btn-primary"
			onclick="location.href='${pageContext.request.contextPath}/defect'">Return to Defect Listing</button>
	</div>

 	<script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/inspinia.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/pace.min.js"></script>


</body>

</html>