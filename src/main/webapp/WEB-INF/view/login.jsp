<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	
	<title>Login Page</title>

	<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css" type="text/css" > 

    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" >
    
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
	
	.msg {
		padding: 15px;
		margin-bottom: 20px;
		border: 1px solid transparent;
		border-radius: 4px;
		color: #31708f;
		background-color: #d9edf7;
		border-color: #bce8f1;
	}
	
/* 	#login-box { */
/* 		width: 300px; */
/* 		padding: 20px; */
/* 		margin: 100px auto; */
/* 		background: #fff; */
/* 		-webkit-border-radius: 2px; */
/* 		-moz-border-radius: 2px; */
/* 		border: 1px solid #000; */
/* 	} */
	</style>
    

</head>
<body>


		
		
		<div class="form">
		
		<c:if test="${not empty dberror}">
				<div class="error">${dberror}</div>
		</c:if>
      
        
        <div id="login">   
          <h1>Log In!</h1>
          
         	<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
          
          <form name='loginForm' action="j_spring_security_check" method='POST'>
          
            <div class="field-wrap">
            <label>
              User name<span class="req">*</span>
            </label>
            <input type="text" name="username" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" name="password" required autocomplete="off"/>
          </div>
          
           <p class="forgot"><a href="${pageContext.request.contextPath}/registration">Register</a></p>
          
          <button class="button button-block">Log In</button>
          
          <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
          
          </form>
          

        </div>
        
      </div><!-- tab-content -->
      

		
	
<%-- 	<button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/registration'">Register</button> --%>
	   
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>

</body>
</html>