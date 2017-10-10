<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>������� �����ϱ�</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#updateButt").click(function(){
					$("#empUpdateForm").attr("action", "/chainCo/emp/empUpdate_1.do");
					$("#empUpdateForm").submit();
				});
			});
		</script>
	</head>
	<body>
	<%
	request.setCharacterEncoding("EUC-KR");
	String ePhoto = request.getParameter("ePhoto");
	String eSignature = request.getParameter("eSignature");
	String ePw = request.getParameter("ePw");
	String eNo = request.getParameter("eNo");
	String eEmail = request.getParameter("eEmail");
	String ePhone = request.getParameter("ePhone");
	String eName = request.getParameter("eName");
	String eDept = request.getParameter("eDept");
	String eAddr = request.getParameter("eAddr");
	String eId = request.getParameter("eId");
	String eInsertDate = request.getParameter("eInsertDate");
	String eUpdateDate = request.getParameter("eUpdateDate");
	String ePos = request.getParameter("ePos");
	%>
	<center>
	<br><br><br><br>
		<h1>������� �����ϱ�</h1>
		<form name="empUpdateForm" id="empUpdateForm" method="POST">
		<input type="hidden" name="ePw" id="ePw" value="<%=ePw%>" /> 
		<input type="hidden" name="eSignature" id="eSignature" value="<%=eSignature%>" /> 
		<input type="hidden" name="ePhoto" id="ePhoto" value="<%=ePhoto%>" /> 
			<table>
				<tr>
					<td>�����ȣ</td>
					<td><input type="text" name="eNo" id="eNo" value="<%=eNo%>" readonly/></td>
				</tr>
				
				<tr>
					<td>�ҼӺμ�</td>
					<td><select id="eDept" name="eDept">
						<option value="ȫ����">ȫ����</option>
						<option value="������">������</option>
						<option value="�λ��">�λ��</option>
						<option value="�繫��">�繫��</option>
						<option value="����������">����������</option>
						<option value="�������ߺ�">�������ߺ�</option>
					<%
					if(eDept.equals("ȫ����")){
						%><script>
							$("#eDept").val("ȫ����");
						</script><%
					}
					
					if(eDept.equals("������")){
						%><script>
							$("#eDept").val("������");
						</script><%
					}
					
					if(eDept.equals("�λ��")){
						%><script>
							$("#eDept").val("�λ��");
						</script><%
					}
					
					if(eDept.equals("�繫��")){
						%><script>
							$("#eDept").val("�繫��");
						</script><%
					}
					
					if(eDept.equals("����������")){
						%><script>
							$("#eDept").val("����������");
						</script><%
					}
					
					if(eDept.equals("�������ߺ�")){
						%><script>
							$("#eDept").val("�������ߺ�");
						</script><%
					}
					%>	
					</select></td>
				</tr>
				
				<tr>
					<td>�����</td>
					<td><input type="text" name="eName" value="<%=eName%>" /></td>
				</tr>
				
				<tr>
					<td>��å</td>
					<td><select id="ePos" name="ePos">
						<option value="���">���</option>
						<option value="����">����</option>
						<option value="����">����</option>
					<%
					if(ePos.equals("���")){
						%><script>
							$("#ePos").val("���");
						</script><%
					}
					
					if(ePos.equals("����")){
						%><script>
							$("#ePos").val("����");
						</script><%
					}
					
					if(ePos.equals("����")){
						%><script>
							$("#ePos").val("����");
						</script><%
					}
					%>	
					</select></td>
				</tr>
				
				<tr>
					<td>���̵�</td>
					<td><input type="text" name="eId" id="eId" value="<%=eId%>" /></td>
				</tr>
				
				<tr>
					<td>�̸����ּ�</td>
					<td><input type="text" name="eEmail" id="eEmail" value="<%=eEmail%>" /></td>
				</tr>
				
				<tr>
					<td>��ȭ��ȣ</td>
					<td><input type="text" name="ePhone" id="ePhone" value="<%=ePhone%>" /></td>
				</tr>
				
				<tr>
					<td>���ּ�</td>
					<td><input type="text" name="eAddr" id="eAddr" value="<%=eAddr%>" /></td>
				</tr>
				
				<tr>
					<td>�Ի���</td>
					<td><input type="text" name="eInsertDate" id="eInsertDate" value="<%=eInsertDate%>" readonly/></td>
				</tr>
			</table>
			<h5>����������: <%=eUpdateDate%></h5><br>
			<input type="hidden" name="eUpdateDate" id="eUpdateDate" value="<%=eUpdateDate%>">
			<button id="updateButt">�����ϱ�</button>
		</form>
	</center>	 
	</body>
</html>