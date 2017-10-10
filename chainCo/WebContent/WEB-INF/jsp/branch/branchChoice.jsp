<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>��������</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#choice").click(function(){
					var choiceFlag = $("#choiceFlag").val();
					if(choiceFlag == 'update'){
						$("#choiceForm").attr("action", "/chainCo/branch/branchUpdate.do");
					}
					if(choiceFlag == 'delete'){
						if (confirm("������ ������ ����ó�� �Ͻðڽ��ϱ�?") == true) {
							$("#choiceForm").attr("action", "/chainCo/branch/delete.do");
					    } else {
					        alert("����ϼ̽��ϴ�.");
					        window.close();
					    }
					}
					
					if(choiceFlag == 'reopen'){
						if (confirm("������ ������ �簳�� �Ͻðڽ��ϱ�?") == true) {
							$("#choiceForm").attr("action", "/chainCo/branch/reopen.do");
					    } else {
					        alert("����ϼ̽��ϴ�.");
					        window.close();
					    }
					}
					
					$("#choiceForm").submit();
				});
			});
		</script>
	</head>
	<body>
	<%
	request.setCharacterEncoding("EUC-KR");
	String choiceFlag = request.getParameter("choiceFlag");
	%>
	<br><br><br>
	<center>
		<h2>�ش������� �����ϼ���.</h2><br>
		<form name="choiceForm" id="choiceForm" method="POST">
			<input type="hidden" name="choiceFlag" id="choiceFlag" value="<%=choiceFlag%>"/>
			<c:if test="${not empty list}">
				<c:forEach items="${list}" var="row">
						<input type="radio" name="bName" value="${row.bName}">${row.bName}
						(��������: ${row.bDeleteyn})<br><br>
				</c:forEach>
			</c:if>
			<c:if test="${empty list}">
				<h3>��ϵ� ������ �����ϴ�.</h3>
			</c:if>
			<br><br>
  			<input type="button" value="����" id="choice" />
		</form>
	</center>	
	</body>
</html>