<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>수정하기</title>
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
		<h2>수정할 정보를 입력해 주세요.</h2>
		<form name="updateForm" id="updateForm" method="POST">
		<c:if test="${not empty branchUpdate}">
			<c:forEach items="${branchUpdate}" var="row">
			<input type="hidden" id="bLoc" value="${row.bLocation}">
				<table>
					<tr>
						<td>지점명: </td>
						<td><input type="text" value="${row.bName}" name="bName" /></td>
					</tr>
					<tr>
						<td>지점코드: </td>
						<td><input type="text" value="${row.bNo}" name="bNo" readonly/></td>
					</tr>
					<tr>
						<td>지역구분: </td>
						<td><select id="bLocation" name="bLocation">
						<option value="서울">서울</option>
						<option value="경기도">경기도</option>
						<option value="강원도">강원도</option>
						<option value="충청도">충청도</option>
						<option value="경상도">경상도</option>
						<option value="전라도">전라도</option>
						<option value="부산">부산</option>
						<option value="울산">울산</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
					
					<script>
						var bLoc = $("#bLoc").val();	
						if(bLoc == "서울"){
							$("#bLocation").val("서울");
						}	
						
						if(bLoc == "경기도"){
							$("#bLocation").val("경기도");
						}
						
						if(bLoc == "강원도"){
							$("#bLocation").val("강원도");
						}	
						
						if(bLoc == "충청도"){
							$("#bLocation").val("충청도");
						}
						
						if(bLoc == "경상도"){
							$("#bLocation").val("경상도");
						}	
						
						if(bLoc == "전라도"){
							$("#bLocation").val("전라도");
						}
						
						if(bLoc == "부산"){
							$("#bLocation").val("부산");
						}	
						
						if(bLoc == "울산"){
							$("#bLocation").val("울산");
						}
						
						if(bLoc == "대전"){
							$("#bLocation").val("대전");
						}	
						
						if(bLoc == "대구"){
							$("#bLocation").val("대구");
						}
					</script>
					</select></td>
					</tr>
					<tr>
						<td>지점장: </td>
						<td><input type="text" value="${row.eName}" name="eName" /></td>
					</tr>
					<tr>
						<td>지점장 사번: </td>
						<td><input type="text" value="${row.eNo}" name="eNo" /></td>
					</tr>
					<tr>
						<td>개점일자: </td>
						<td>${row.bInsertDate}</td>
					</tr>
				</table>
				<br><br>
				(최종수정일: ${row.bUpdateDate})<input type="button" value="수정하기" onclick="updateWork()">
				
			</c:forEach>
		</c:if>
		</form>
		</center>
	</body>
</html>