<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Registration Page</title>

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

.success {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #000000;
	background-color: #A2DEB1;
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

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>


<div class="form">
      
<p class="forgot"><a href="${pageContext.request.contextPath}/login">Log in</a></p>
      

        <div id="signup">   
          <h1>Sign Up for Free</h1>
          
          <form name='registrationForm'
			action="${pageContext.request.contextPath}/registration" method='POST'>
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
                User Name<span class="req">*</span>
              </label>
              <input type="text" name="username" required autocomplete="off" />
            </div>
        
            <div class="field-wrap">
              <label>
                Full Name<span class="req">*</span>
              </label>
              <input type="text" name="fullName"  required autocomplete="off"/>
            </div>
          </div>

          <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email" name="email" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Set A Password<span class="req">*</span>
            </label>
            <input type="password" name="password" required autocomplete="off"/>
          </div>
          
          <button type="submit" class="button button-block">Get Started</button>
          
          <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
				
          </form>

        </div>
        
        
        

      
</div> <!-- /form -->




<!-- 	<div id="login-box"> -->

<!-- 		<h2>Registration</h2> -->

<%-- 		<c:if test="${not empty error}"> --%>
<%-- 			<div class="error">${error}</div> --%>
<%-- 		</c:if> --%>
		
<%-- 		<c:if test="${not empty success}"> --%>
<%-- 			<div class="success">${success}</div> --%>
<%-- 		</c:if> --%>
		
<!-- 		<form name='registrationForm' -->
<%-- 			action="${pageContext.request.contextPath}/registration" method='POST'> --%>

<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<td>User name:</td> -->
<!-- 					<td><input type='text' name='username' value=''></td> -->
<!-- 				</tr> -->
				
<!-- 				<tr> -->
<!-- 					<td>Full name:</td> -->
<!-- 					<td><input type='text' name='fullName' value=''></td> -->
<!-- 				</tr> -->
				
<!-- 				<tr> -->
<!-- 					<td>Email</td> -->
<!-- 					<td><input type='text' name='email' value=''></td> -->
<!-- 				</tr> -->
				
<!-- 				<tr> -->
<!-- 					<td>Password:</td> -->
<!-- 					<td><input type='password' name='password' /></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Position:</td> -->
<!-- 					<td> -->
<!-- 						<select name="role"> -->
<%-- 							<c:forEach items="${roleList}" var="r"> --%>
<%-- 								<option value="${r.code}">${r.role}</option> --%>
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td colspan='2'> -->
<!-- 					<input name="submit" type="submit" value="submit" /> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<%-- 			<input type="hidden" name="${_csrf.parameterName}" --%>
<%-- 				value="${_csrf.token}" /> --%>
<!-- 		</form> -->
<!-- 	</div> -->
	
	<button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/login'">Login</button>

	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>

</body>
</html>