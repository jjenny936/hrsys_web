<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>�����ϱ�</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
			function updateWork(){
				$("#updateForm").attr("action", "/chainCo/branch/update.do");
				$("#updateForm").submit();
			}
		</script>
	</head>
	<body>
	<br><br><br>
	<center>
		<h2>������ ������ �Է��� �ּ���.</h2>
		<form name="updateForm" id="updateForm" method="POST">
		<c:if test="${not empty branchUpdate}">
			<c:forEach items="${branchUpdate}" var="row">
			<input type="hidden" id="bLoc" value="${row.bLocation}">
				<table>
					<tr>
						<td>������: </td>
						<td><input type="text" value="${row.bName}" name="bName" /></td>
					</tr>
					<tr>
						<td>�����ڵ�: </td>
						<td><input type="text" value="${row.bNo}" name="bNo" readonly/></td>
					</tr>
					<tr>
						<td>��������: </td>
						<td><select id="bLocation" name="bLocation">
						<option value="����">����</option>
						<option value="��⵵">��⵵</option>
						<option value="������">������</option>
						<option value="��û��">��û��</option>
						<option value="���">���</option>
						<option value="����">����</option>
						<option value="�λ�">�λ�</option>
						<option value="���">���</option>
						<option value="����">����</option>
						<option value="�뱸">�뱸</option>
					
					<script>
						var bLoc = $("#bLoc").val();	
						if(bLoc == "����"){
							$("#bLocation").val("����");
						}	
						
						if(bLoc == "��⵵"){
							$("#bLocation").val("��⵵");
						}
						
						if(bLoc == "������"){
							$("#bLocation").val("������");
						}	
						
						if(bLoc == "��û��"){
							$("#bLocation").val("��û��");
						}
						
						if(bLoc == "���"){
							$("#bLocation").val("���");
						}	
						
						if(bLoc == "����"){
							$("#bLocation").val("����");
						}
						
						if(bLoc == "�λ�"){
							$("#bLocation").val("�λ�");
						}	
						
						if(bLoc == "���"){
							$("#bLocation").val("���");
						}
						
						if(bLoc == "����"){
							$("#bLocation").val("����");
						}	
						
						if(bLoc == "�뱸"){
							$("#bLocation").val("�뱸");
						}
					</script>
					</select></td>
					</tr>
					<tr>
						<td>������: </td>
						<td><input type="text" value="${row.eName}" name="eName" /></td>
					</tr>
					<tr>
						<td>������ ���: </td>
						<td><input type="text" value="${row.eNo}" name="eNo" /></td>
					</tr>
					<tr>
						<td>��������: </td>
						<td>${row.bInsertDate}</td>
					</tr>
				</table>
				<br><br>
				(����������: ${row.bUpdateDate})<input type="button" value="�����ϱ�" onclick="updateWork()">
				
			</c:forEach>
		</c:if>
		</form>
		</center>
	</body>
</html>