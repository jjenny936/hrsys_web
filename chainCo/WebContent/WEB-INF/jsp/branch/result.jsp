<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>BRANCH DELETE JSP</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		%>
		<c:choose>
			<c:when test="${update}.indexOf('문제')>-1">
				<script>
			      	alert("오류발생");
					history.go(-1);
				</script>
			</c:when>
			<c:otherwise>
				<script>
					alert("성공!");
					window.close();
				</script>
			</c:otherwise>
		</c:choose>
	</body>
</html>