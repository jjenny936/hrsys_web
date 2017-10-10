<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>사원정보 수정하기</title>
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
		<h1>사원정보 수정하기</h1>
		<form name="empUpdateForm" id="empUpdateForm" method="POST">
		<input type="hidden" name="ePw" id="ePw" value="<%=ePw%>" /> 
		<input type="hidden" name="eSignature" id="eSignature" value="<%=eSignature%>" /> 
		<input type="hidden" name="ePhoto" id="ePhoto" value="<%=ePhoto%>" /> 
			<table>
				<tr>
					<td>사원번호</td>
					<td><input type="text" name="eNo" id="eNo" value="<%=eNo%>" readonly/></td>
				</tr>
				
				<tr>
					<td>소속부서</td>
					<td><select id="eDept" name="eDept">
						<option value="홍보부">홍보부</option>
						<option value="영업부">영업부</option>
						<option value="인사부">인사부</option>
						<option value="재무부">재무부</option>
						<option value="점포관리부">점포관리부</option>
						<option value="연구개발부">연구개발부</option>
					<%
					if(eDept.equals("홍보부")){
						%><script>
							$("#eDept").val("홍보부");
						</script><%
					}
					
					if(eDept.equals("영업부")){
						%><script>
							$("#eDept").val("영업부");
						</script><%
					}
					
					if(eDept.equals("인사부")){
						%><script>
							$("#eDept").val("인사부");
						</script><%
					}
					
					if(eDept.equals("재무부")){
						%><script>
							$("#eDept").val("재무부");
						</script><%
					}
					
					if(eDept.equals("점포관리부")){
						%><script>
							$("#eDept").val("점포관리부");
						</script><%
					}
					
					if(eDept.equals("연구개발부")){
						%><script>
							$("#eDept").val("연구개발부");
						</script><%
					}
					%>	
					</select></td>
				</tr>
				
				<tr>
					<td>사원명</td>
					<td><input type="text" name="eName" value="<%=eName%>" /></td>
				</tr>
				
				<tr>
					<td>직책</td>
					<td><select id="ePos" name="ePos">
						<option value="사원">사원</option>
						<option value="부장">부장</option>
						<option value="사장">사장</option>
					<%
					if(ePos.equals("사원")){
						%><script>
							$("#ePos").val("사원");
						</script><%
					}
					
					if(ePos.equals("부장")){
						%><script>
							$("#ePos").val("부장");
						</script><%
					}
					
					if(ePos.equals("사장")){
						%><script>
							$("#ePos").val("사장");
						</script><%
					}
					%>	
					</select></td>
				</tr>
				
				<tr>
					<td>아이디</td>
					<td><input type="text" name="eId" id="eId" value="<%=eId%>" /></td>
				</tr>
				
				<tr>
					<td>이메일주소</td>
					<td><input type="text" name="eEmail" id="eEmail" value="<%=eEmail%>" /></td>
				</tr>
				
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="ePhone" id="ePhone" value="<%=ePhone%>" /></td>
				</tr>
				
				<tr>
					<td>집주소</td>
					<td><input type="text" name="eAddr" id="eAddr" value="<%=eAddr%>" /></td>
				</tr>
				
				<tr>
					<td>입사일</td>
					<td><input type="text" name="eInsertDate" id="eInsertDate" value="<%=eInsertDate%>" readonly/></td>
				</tr>
			</table>
			<h5>최종수정일: <%=eUpdateDate%></h5><br>
			<input type="hidden" name="eUpdateDate" id="eUpdateDate" value="<%=eUpdateDate%>">
			<button id="updateButt">수정하기</button>
		</form>
	</center>	 
	</body>
</html>