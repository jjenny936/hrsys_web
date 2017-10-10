<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="coffee.chain.emp.vo.EmpVO" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ page import="com.oreilly.servlet.MultipartRequest" %>  
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>    
<%@ page import="java.util.Enumeration" %>    	  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>�� ���� �����ϱ�</title>
		<style type="text/css">
			table tr td {
				padding: 5px;
			}
			
			tr#photoChange{
				display: none;
			}
			
			tr#signatureChange{
				display: none;
			}
		</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#updateButt").click(function(){
					
					var epw = $("#ePw").val();
					var epwcheck = $("#ePwCheck").val();
					
					if(epwcheck == ''){
						alert("��й�ȣ Ȯ���� ���ּ���!");
						$("#ePwCheck").focus();
						return false;
					}
					
					if($("#ePhoto").val().indexOf(".")>-1){
						var ext = $("#ePhoto").val().split(".").pop().toLowerCase();
						if(jQuery.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1){
							alert("gif, png, jpg, jpeg ���ϸ� ���ε� �� �� �ֽ��ϴ�.");
							return;
						}
					}
					
					if($("#eSignature").val().indexOf(".")>-1){
						var ext = $("#eSignature").val().split(".").pop().toLowerCase();
						if(jQuery.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1){
							alert("gif, png, jpg, jpeg ���ϸ� ���ε� �� �� �ֽ��ϴ�.");
							return;
						}
					}
					
					var photoFlag=0;//���ε尡 �Ǹ� 1
					var sigFlag=0;
					
					//id="ePhoto" -> ���ε��� ����, id="ePhoto_1" ->�Ѱܹ��� ����
					if($("#ePhoto").val() != null && $("#ePhoto").val() != ""){
						photoFlag = 1;//���� ���ε尡 ��
						$("#ePhoto_1").removeAttr("name");
					}else{//���� ���ε尡 �ȵ�
						$("#ePhoto").removeAttr("name");
					}
					
					if($("#eSignature").val() != null && $("#eSignature").val() != ""){
						sigFlag = 1; //���� ���ε尡 ��
						$("#eSignature_1").removeAttr("name");
					}else{//���� ���ε尡 �ȵ�
						$("#eSignature").removeAttr("name");
					}
					
					if(epw == epwcheck){
						if(photoFlag == 1 && sigFlag == 1){
							//�Ѵ� ���ε尡 ��					
							$("#uploadFlag").val("bothUploaded"); 							
							$("#empMyPageForm").attr("action", "/chainCo/file.jsp");
						}
						
						if(photoFlag == 1 && sigFlag == 0){
							//������ ���ε��
							$("#uploadFlag").val("photoUploaded");
							$("#empMyPageForm").attr("action", "/chainCo/file.jsp");
						}
						
						if(photoFlag == 0 && sigFlag == 1){
							//���θ� ���ε��
							$("#uploadFlag").val("signatureUploaded");
							$("#empMyPageForm").attr("action", "/chainCo/file.jsp");
						}
						
						if(photoFlag == 0 && sigFlag == 0){
							//�Ѵ� ���ε� ���� ����
							$("#empMyPageForm").attr("action", "/chainCo/emp/empUpdate.do");
						}
						
						$("#empMyPageForm").submit();
						return true;
					}else{
						alert("��й�ȣ�� �ٽ� Ȯ�����ּ���!");
						$("#ePw").focus();
					}
					
				});
			});
			
			function changePhoto(){
				$("tr#photoChange").show();
				/*var table = document.getElementById("tableId");
			    var row = table.insertRow(1);
			    var cell1 = row.insertCell(0);
			    var cell2 = row.insertCell(1);
			    cell1.innerHTML = "���� �ҷ�����: ";
			    cell2.innerHTML = "<input type='file' name='ePhoto' /> ";*/	
			}
			
			function changeSignature(){
				$("tr#signatureChange").show();	
			}
		</script>
	</head>
	<body>
	<%
	request.setCharacterEncoding("EUC-KR");
	
	EmpVO ev = (EmpVO)request.getAttribute("empMyPage");
	if(ev == null){
		%>
		<script>
			alert("session�� ����Ǿ����ϴ�. <br> �α׾ƿ� ��  �ٽ� �α��� ���ּ���.");
			window.close();
		</script>
		<%
	}
	Object sessionEno = session.getAttribute("eNo");
	session.setAttribute("sessionEphoto", ev.getePhoto());
	session.setAttribute("sessionEsignature", ev.geteSignature());
	Object sessionEphoto = session.getAttribute("sessionEphoto");
	Object sessionEsignature = session.getAttribute("sessionEsignature");
	
	if(sessionEno == null || sessionEphoto == null || sessionEsignature == null){
		%>
		<script>
			alert("session�� ����Ǿ����ϴ�. <br> �α׾ƿ� ��  �ٽ� �α��� ���ּ���.");
			window.close();
		</script>
		<%
	}
	
	%>
	<c:if test="${empty empMyPage}">
		<script>
			alert("�����߻�! �ٽ� �õ����ּ���.");
		</script>
	</c:if>	
	<center>
	<br>
		<h1>�� ���� �����ϱ�</h1>
		<form name="empMyPageForm" enctype="multipart/form-data" id="empMyPageForm" method="POST"> 
			<input type="hidden" name="eSignature" id="eSignature_1" value="<%=ev.geteSignature()%>" /> 
			<input type="hidden" name="ePhoto" id="ePhoto_1" value="<%=ev.getePhoto()%>" /> 
			<input type="hidden" name="uploadFlag" id="uploadFlag" />
			<table id="tableId">
				<tr>
					<td>���� �����ʻ���</td>
					<td><img src="<%=ev.getePhoto()%>" alt="photo" height="111" width="75"/>
					<input type="button" value="�ٲٱ�" onclick="changePhoto()"></td>
				</tr>
				<tr id="photoChange">
					<td>���� �ҷ�����: </td>
					<td><input type="file" name="ePhoto" id="ePhoto"></td>
				</tr>
				<tr>
					<td>�����ȣ</td>
					<td><input type="text" name="eNo" value="<%=ev.geteNo()%>" readonly/></td>
				</tr>
				
				<tr>
					<td>�ҼӺμ�</td>
					<td><input type="text" name="eDept" value="<%=ev.geteDept()%>" readonly/></td>
				</tr>
				
				<tr>
					<td>�����</td>
					<td><input type="text" name="eName" value="<%=ev.geteName()%>" readonly/></td>
				</tr>
				
				<tr>
					<td>��å</td>
					<td><input type="text" name="ePos" value="<%=ev.getePos()%>" readonly/></td>
				</tr>
				
				<tr>
					<td>���̵�</td>
					<td><input type="text" name="eId" value="<%=ev.geteId()%>"/></td>
				</tr>
				
				<tr>
					<td>��й�ȣ</td>
					<td><input type="password" name="ePw"  id="ePw" value="<%=ev.getePw()%>"/></td>
				</tr>
				
				<tr>
					<td>��й�ȣ Ȯ��</td>
					<td><input type="password" name="ePwCheck"  id="ePwCheck"/></td>
				</tr>
				
				<tr>
					<td>�̸����ּ�</td>
					<td><input type="text" name="eEmail" value="<%=ev.geteEmail()%>" /></td>
				</tr>
				
				<tr>
					<td>��ȭ��ȣ</td>
					<td><input type="text" name="ePhone" value="<%=ev.getePhone()%>" /></td>
				</tr>
				
				<tr>
					<td>���ּ�</td>
					<td><input type="text" name="eAddr" value="<%=ev.geteAddr()%>" /></td>
				</tr>
				
				<tr>
					<td>�Ի���</td>
					<td><input type="text" name="eInsertDate" value="<%=ev.geteInsertDate()%>" readonly/></td>
				</tr>
				<tr>
					<td>���� ����</td>
					<td><img src="<%=ev.geteSignature()%>" alt="signature" height="50" width="100"/>
					<input type="button" value="�ٲٱ�" onclick="changeSignature()"></td>
				</tr>
				<tr id="signatureChange">
					<td>���� �ҷ�����: </td>
					<td><input type="file" name="eSignature" id="eSignature"/></td>
				</tr>
			</table>
			<h5>����������: <%=ev.geteUpdateDate()%></h5><br>
			<button id="updateButt">�����ϱ�</button>
		</form>
	</center>	 
	</body>
</html>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		