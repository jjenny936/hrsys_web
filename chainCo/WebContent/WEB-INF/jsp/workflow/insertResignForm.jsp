<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="coffee.chain.emp.vo.EmpVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>�����ۼ��ϱ� - ������</title>
		<style type="text/css">
			.tg  {border-collapse:collapse;border-spacing:0;}
			.tg td{font-family:Arial, sans-serif;font-size:14px;padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
			.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
			.tg .tg-yzt1{background-color:#efefef;vertical-align:top}
			.tg .tg-le8v{background-color:#c0c0c0;vertical-align:top}
			.tg .tg-yw4l{vertical-align:top}
			
			input[type=text] {
				width: 100%;
			}
			
		</style>
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){				
				$("#submitting").click(function() {
					$("#insertForm").attr("action","/chainCo/workflow/submitDocResign.do");
					$("#insertForm").submit();
				});		
			});
			
		</script>
		
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		EmpVO ev = (EmpVO)session.getAttribute("login");
		if(ev == null){
			%>
			<script>
				alert("������ ����Ǿ����ϴ�. �ٽ� �α��� ���ּ���");
				location.href="/chainCo/loginEntry.jsp";
			</script>
			<%
		}
		%>
		<br><br><br><br><br><br>
		<center>
		<h1>������</h1>
		<br><br>
		<form name="insertForm" id="insertForm" method="POST">
			<table class="tg">
			  <tr>
			    <th class="tg-le8v">�Ҽ�</th>
			    <th class="tg-yw4l"><input type="text" name="eDept" value="<%=ev.geteDept()%>" readonly/></th>
			    <th class="tg-le8v">��å</th>
			    <th class="tg-yw4l"><input type="text" name="ePos" value="<%=ev.getePos()%>" readonly/></th>
			  </tr>
			  <tr>
			    <td class="tg-le8v" align="center">����</td>
			    <td class="tg-yw4l"><input type="text" name="eName" value="<%=ev.geteName()%>" readonly/></td>
			    <td class="tg-le8v" align="center">�����ȣ</td>
			    <td class="tg-yw4l"><input type="text" name="eNo" value="<%=ev.geteNo()%>" readonly/></td>
			  </tr>
			  <tr>
			    <td class="tg-le8v">�Ի�����</td>
			    <td class="tg-yw4l"><input type="text" name="eInsertDate" value="<%=ev.geteInsertDate()%>" readonly/></td>
			    <td class="tg-le8v">�����������</td>
			    <td class="tg-yw4l"><input type="text" name="wRresigndate" /></td>
			  </tr>
			  <tr>
			    <td class="tg-le8v">��������</td>
			    <td class="tg-yw4l" colspan="3"><input type="text" name="wRreason" /></td>
			  </tr>
			  <tr>
			    <td class="tg-le8v" rowspan="3" align="center"><br>������<br>����ó</td>
			    <td class="tg-yzt1">�ּ�</td>
			    <td class="tg-yw4l" colspan="2"><input type="text" name="wRpostaddr" /></td>
			  </tr>
			  <tr>
			    <td class="tg-yzt1">��ȭ��ȣ</td>
			    <td class="tg-yw4l" colspan="2"><input type="text" name="wRposttel" /></td>
			  </tr>
			  <tr>
			    <td class="tg-yzt1">�̸���</td>
			    <td class="tg-yw4l" colspan="2"><input type="text" name="wRpostemail" /></td>
			  </tr>
			  <tr>
			    <td class="tg-yw4l" colspan="4" align="center">
			    	������ ���� ���� �������� �����ϰ��� �Ͽ��� ����Ͽ� �ֽñ� �ٶ��ϴ�.<br>
			    </td>
			  </tr>
			</table>
			<br><br><br>
			<input type="button" value="�ӽú���" />
			<input type="button" value="�����ϱ�" id="submitting" />
			<input type="button" value="�ڷΰ���"  />
		</form>
		</center>
	</body>
</html>