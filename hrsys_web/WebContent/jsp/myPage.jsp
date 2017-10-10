<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.koitt.baby.vo.HrsysMemberVO" %>
<%@ page import="org.apache.commons.codec.binary.Base64" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>MyPage Jsp</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#back").click(function(){
					document.myPageForm.action="/hrsys_web/html/MainScr.html";
					document.myPageForm.submit();
				});
				
				$("#update").click(function(){
					document.myPageForm.action="/hrsys_web/update.do";
					document.myPageForm.submit();	
				});
				
				$("#delete").click(function(){
					document.myPageForm.action="/hrsys_web/delete.do";
					document.myPageForm.submit();	
				});
				
			});
		</script>
		<style>
			body {background: url('../img/fourth.jpg');
			      background-repeat: no-repeat;
    			  background-attachment: fixed;}
    			  
    		ul {list-style: none;
    		    background-color: rgba(255, 255, 255, 0.4);
    		    padding: 30px 40px;
    		    width: 600px;
    		    height: 800px;}	  
    		    
    		ul li {display: table;}	
    		       
    		p.text {font-weight: bold;
    		   font-size: 130%;}   
						   
		    ul li#button{display: inline;
		    			 padding: 8px;}
		    
		    button {background-color: rgba(102, 102, 102, 0.8); 
					color: white;
				    cursor: pointer;
				    width: 90;
				    height: 40;
				    border-radius: 3px;
				    font-size: 100%;}	 
					      
			button:hover {background-color: white;
						  color: black;
						  border: 2px solid #555555;
						  border-radius: 2px;}					              
			        
		</style>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		%>
		<center>
		<br><br><br><br>
		<form name="myPageForm" method="POST" action="#">
		<ul>
			<br><br><br><br><br><br>
				
			<li><p class="text">ID&nbsp;:&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="mid" value="${mid}" readonly></p></li>
				
			<li><p class="text">PW&nbsp;:&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
				<input type="password" name="mpw" value="${mpw}"></p></li>
				
			<li><p class="text">성명&nbsp;:&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="mname" value="${mname}"></p></li>
				
			<li><p class="text">주소&nbsp;:&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="maddr" value="${maddr}"></p></li>
				
			<li><p class="text">전화번호&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="text" name="mphone" value="${mphone}"></p></li>
				
			<li><p class="text">EMAIL&nbsp;:&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="memail" value="${memail}"></p></li>

	
		<br><br><br><br><br>
		<li id="button"><button id="update">&nbsp;&nbsp;수정&nbsp;&nbsp;</button></li>
		<li id="button"><button id="delete">회원탈퇴</button></li>
		<li id="button"><button id="back">뒤로가기</button></li>
	</ul>
	</form>
	
	</center>
</body>
</html>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		