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
		<title>내 정보 수정하기</title>
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
						alert("비밀번호 확인을 해주세요!");
						$("#ePwCheck").focus();
						return false;
					}
					
					if($("#ePhoto").val().indexOf(".")>-1){
						var ext = $("#ePhoto").val().split(".").pop().toLowerCase();
						if(jQuery.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1){
							alert("gif, png, jpg, jpeg 파일만 업로드 할 수 있습니다.");
							return;
						}
					}
					
					if($("#eSignature").val().indexOf(".")>-1){
						var ext = $("#eSignature").val().split(".").pop().toLowerCase();
						if(jQuery.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1){
							alert("gif, png, jpg, jpeg 파일만 업로드 할 수 있습니다.");
							return;
						}
					}
					
					var photoFlag=0;//업로드가 되면 1
					var sigFlag=0;
					
					//id="ePhoto" -> 업로드한 파일, id="ePhoto_1" ->넘겨받은 파일
					if($("#ePhoto").val() != null && $("#ePhoto").val() != ""){
						photoFlag = 1;//사진 업로드가 됨
						$("#ePhoto_1").removeAttr("name");
					}else{//사진 업로드가 안됨
						$("#ePhoto").removeAttr("name");
					}
					
					if($("#eSignature").val() != null && $("#eSignature").val() != ""){
						sigFlag = 1; //사인 업로드가 됨
						$("#eSignature_1").removeAttr("name");
					}else{//사인 업로드가 안됨
						$("#eSignature").removeAttr("name");
					}
					
					if(epw == epwcheck){
						if(photoFlag == 1 && sigFlag == 1){
							//둘다 업로드가 됨					
							$("#uploadFlag").val("bothUploaded"); 							
							$("#empMyPageForm").attr("action", "/chainCo/file.jsp");
						}
						
						if(photoFlag == 1 && sigFlag == 0){
							//사진만 업로드됨
							$("#uploadFlag").val("photoUploaded");
							$("#empMyPageForm").attr("action", "/chainCo/file.jsp");
						}
						
						if(photoFlag == 0 && sigFlag == 1){
							//사인만 업로드됨
							$("#uploadFlag").val("signatureUploaded");
							$("#empMyPageForm").attr("action", "/chainCo/file.jsp");
						}
						
						if(photoFlag == 0 && sigFlag == 0){
							//둘다 업로드 되지 않음
							$("#empMyPageForm").attr("action", "/chainCo/emp/empUpdate.do");
						}
						
						$("#empMyPageForm").submit();
						return true;
					}else{
						alert("비밀번호를 다시 확인해주세요!");
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
			    cell1.innerHTML = "사진 불러오기: ";
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
			alert("session이 만료되었습니다. <br> 로그아웃 후  다시 로그인 해주세요.");
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
			alert("session이 만료되었습니다. <br> 로그아웃 후  다시 로그인 해주세요.");
			window.close();
		</script>
		<%
	}
	
	%>
	<c:if test="${empty empMyPage}">
		<script>
			alert("오류발생! 다시 시도해주세요.");
		</script>
	</c:if>	
	<center>
	<br>
		<h1>내 정보 수정하기</h1>
		<form name="empMyPageForm" enctype="multipart/form-data" id="empMyPageForm" method="POST"> 
			<input type="hidden" name="eSignature" id="eSignature_1" value="<%=ev.geteSignature()%>" /> 
			<input type="hidden" name="ePhoto" id="ePhoto_1" value="<%=ev.getePhoto()%>" /> 
			<input type="hidden" name="uploadFlag" id="uploadFlag" />
			<table id="tableId">
				<tr>
					<td>현재 프로필사진</td>
					<td><img src="<%=ev.getePhoto()%>" alt="photo" height="111" width="75"/>
					<input type="button" value="바꾸기" onclick="changePhoto()"></td>
				</tr>
				<tr id="photoChange">
					<td>사진 불러오기: </td>
					<td><input type="file" name="ePhoto" id="ePhoto"></td>
				</tr>
				<tr>
					<td>사원번호</td>
					<td><input type="text" name="eNo" value="<%=ev.geteNo()%>" readonly/></td>
				</tr>
				
				<tr>
					<td>소속부서</td>
					<td><input type="text" name="eDept" value="<%=ev.geteDept()%>" readonly/></td>
				</tr>
				
				<tr>
					<td>사원명</td>
					<td><input type="text" name="eName" value="<%=ev.geteName()%>" readonly/></td>
				</tr>
				
				<tr>
					<td>직책</td>
					<td><input type="text" name="ePos" value="<%=ev.getePos()%>" readonly/></td>
				</tr>
				
				<tr>
					<td>아이디</td>
					<td><input type="text" name="eId" value="<%=ev.geteId()%>"/></td>
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="ePw"  id="ePw" value="<%=ev.getePw()%>"/></td>
				</tr>
				
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="ePwCheck"  id="ePwCheck"/></td>
				</tr>
				
				<tr>
					<td>이메일주소</td>
					<td><input type="text" name="eEmail" value="<%=ev.geteEmail()%>" /></td>
				</tr>
				
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="ePhone" value="<%=ev.getePhone()%>" /></td>
				</tr>
				
				<tr>
					<td>집주소</td>
					<td><input type="text" name="eAddr" value="<%=ev.geteAddr()%>" /></td>
				</tr>
				
				<tr>
					<td>입사일</td>
					<td><input type="text" name="eInsertDate" value="<%=ev.geteInsertDate()%>" readonly/></td>
				</tr>
				<tr>
					<td>현재 서명</td>
					<td><img src="<%=ev.geteSignature()%>" alt="signature" height="50" width="100"/>
					<input type="button" value="바꾸기" onclick="changeSignature()"></td>
				</tr>
				<tr id="signatureChange">
					<td>사인 불러오기: </td>
					<td><input type="file" name="eSignature" id="eSignature"/></td>
				</tr>
			</table>
			<h5>최종수정일: <%=ev.geteUpdateDate()%></h5><br>
			<button id="updateButt">수정하기</button>
		</form>
	</center>	 
	</body>
</html>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		