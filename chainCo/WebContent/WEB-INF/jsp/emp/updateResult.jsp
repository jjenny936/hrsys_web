<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>EMP DELETE JSP</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		%>
		<c:choose>
			<c:when test="${result}.indexOf('문제')>-1">
				<script>
			      	alert("오류발생! 다시 시도해 주세요.");
			      	window.close();
				</script>
			</c:when>
			<c:otherwise>
				<script>
					alert("수정성공!");
					window.close();
				</script>
			</c:otherwise>
		</c:choose>
	</body>
</html>