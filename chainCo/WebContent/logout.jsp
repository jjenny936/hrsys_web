<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>�α׾ƿ�</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		session.removeAttribute("eNo");
		session.removeAttribute("eDept");
		session.removeAttribute("ePos");
		session.removeAttribute("eName");
		session.removeAttribute("login");
		%>
		<script>
			alert("�α׾ƿ� �ϼ̽��ϴ�.");
			location.href="/chainCo/loginEntry.jsp";
		</script>
	</body>
</html>