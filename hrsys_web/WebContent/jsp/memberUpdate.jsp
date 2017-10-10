<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Member Update Jsp</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		String mid = (String)request.getAttribute("mid");
		Object o = request.getAttribute("updateResult");
		if(o != null){
			session.setAttribute("mid", mid);
			%>
			<script>
				alert("수정성공!");
				location.href = "/hrsys_web/memberSelect.do";
				</script>
				<%
			}else{
				%>
				<script>
					alert("오류발생. 다시 시도해 주십시오.");
					history.go(-1);
				</script>
				<%
			}
			%>
		</body>
	</html>
			
			
			
			
			
			
			
			
			
			
			
			
			
			