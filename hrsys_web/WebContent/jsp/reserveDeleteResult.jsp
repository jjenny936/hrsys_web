<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Delete jsp</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		Object o = request.getAttribute("deleteResult");
		
		if(o != null){
			%>
			<script>
				alert("해당 예약건이 취소되었습니다.");
				location.href = "/hrsys_web/reserveSelect.do";
			</script>
			<%
		}else{
			%>
			<script>
				alert("오류발생: 다시 시도해 주세요.");
				history.go(-1);
			</script>
			<%
		}
		%>
	</body>
</html>