<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Reserve Change Jsp</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		Object o = request.getAttribute("updateResult");
		
		if(o != null){
			%>
			<script>
				alert("��������!");
				location.href = "/hrsys_web/reserveChange.do";
			</script>
			<%
		}else{
			%>
			<script>
				alert("�����߻�: �ٽ� �õ��� �ּ���.");
				history.go(-1);
			</script>
			<%
		}
		%>
	</body>
</html>