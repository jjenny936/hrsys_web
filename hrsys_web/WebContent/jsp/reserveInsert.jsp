<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Reserve Insert Jsp</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		Object o = request.getAttribute("reserveInsertResult");
		if(o != null){
			%>
			<script>
				alert("예약성공!");
				location.href="/hrsys_web/html/MainScr.html";
			</script>
			<%
		}else{
			%>
			<script>
				alert("오류발생! 다시 시도해주세요.");
				history.go(-1);
			</script>
			<%
		}
		%>
	</body>
</html>