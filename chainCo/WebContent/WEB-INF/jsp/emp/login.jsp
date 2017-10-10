<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Login Jsp</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$(document).ready(function(){
					var v = $("#flag").val()
					if(v == 'true'){
						document.loginSession.action="/chainCo/main.jsp"
						document.loginSession.submit();
					}               
				});			
			});
		</script>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		%>
		<form name="loginSession" method="POST">
   		<c:if test="${empty login}">
	      	<script>
				alert("정보가 일치하지 않습니다.");
				history.go(-1);
			</script>
	    </c:if>
	    
		<c:if test="${not empty login}">
			<input type="hidden" id="flag" value="true">   		
			<input type="hidden" name="eNo" value="${login.eNo}">
			<input type="hidden" name="ePos" value="${login.ePos}">
			<input type="hidden" name="eDept" value="${login.eDept}">
			<input type="hidden" name="eName" value="${login.eName}">	
			<script>
				alert("로그인 성공!");
			</script>
   		</c:if>
 		</form>
	</body>
</html>