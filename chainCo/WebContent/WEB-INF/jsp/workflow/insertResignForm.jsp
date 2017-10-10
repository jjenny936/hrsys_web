<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="coffee.chain.emp.vo.EmpVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>문서작성하기 - 사직서</title>
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
				alert("세션이 만료되었습니다. 다시 로그인 해주세요");
				location.href="/chainCo/loginEntry.jsp";
			</script>
			<%
		}
		%>
		<br><br><br><br><br><br>
		<center>
		<h1>사직서</h1>
		<br><br>
		<form name="insertForm" id="insertForm" method="POST">
			<table class="tg">
			  <tr>
			    <th class="tg-le8v">소속</th>
			    <th class="tg-yw4l"><input type="text" name="eDept" value="<%=ev.geteDept()%>" readonly/></th>
			    <th class="tg-le8v">직책</th>
			    <th class="tg-yw4l"><input type="text" name="ePos" value="<%=ev.getePos()%>" readonly/></th>
			  </tr>
			  <tr>
			    <td class="tg-le8v" align="center">성명</td>
			    <td class="tg-yw4l"><input type="text" name="eName" value="<%=ev.geteName()%>" readonly/></td>
			    <td class="tg-le8v" align="center">사원번호</td>
			    <td class="tg-yw4l"><input type="text" name="eNo" value="<%=ev.geteNo()%>" readonly/></td>
			  </tr>
			  <tr>
			    <td class="tg-le8v">입사일자</td>
			    <td class="tg-yw4l"><input type="text" name="eInsertDate" value="<%=ev.geteInsertDate()%>" readonly/></td>
			    <td class="tg-le8v">퇴직희망일자</td>
			    <td class="tg-yw4l"><input type="text" name="wRresigndate" /></td>
			  </tr>
			  <tr>
			    <td class="tg-le8v">퇴직사유</td>
			    <td class="tg-yw4l" colspan="3"><input type="text" name="wRreason" /></td>
			  </tr>
			  <tr>
			    <td class="tg-le8v" rowspan="3" align="center"><br>퇴직후<br>연락처</td>
			    <td class="tg-yzt1">주소</td>
			    <td class="tg-yw4l" colspan="2"><input type="text" name="wRpostaddr" /></td>
			  </tr>
			  <tr>
			    <td class="tg-yzt1">전화번호</td>
			    <td class="tg-yw4l" colspan="2"><input type="text" name="wRposttel" /></td>
			  </tr>
			  <tr>
			    <td class="tg-yzt1">이메일</td>
			    <td class="tg-yw4l" colspan="2"><input type="text" name="wRpostemail" /></td>
			  </tr>
			  <tr>
			    <td class="tg-yw4l" colspan="4" align="center">
			    	본인은 상기와 같은 내용으로 퇴직하고자 하오니 허락하여 주시기 바랍니다.<br>
			    </td>
			  </tr>
			</table>
			<br><br><br>
			<input type="button" value="임시보관" />
			<input type="button" value="제출하기" id="submitting" />
			<input type="button" value="뒤로가기"  />
		</form>
		</center>
	</body>
</html>