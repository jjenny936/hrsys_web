<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>MemberJoin Insert</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("UTF-8");
		
		Object o = request.getAttribute("memberInsertWork");
		if(o != null){
			%><script>
				alert("ȸ�����Լ���!");
				location.href="/hrsys_web/html/LoginScr.html";
			</script><%
		}else{
			%><script>
			alert("�����߻�. �ٽ� �õ��� �ֽʽÿ�.);
			history.go(-1);
		</script><%
		}
		%>
	</body>
</html>