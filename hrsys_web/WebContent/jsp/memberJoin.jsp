<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Welcome to the Family</title>
		<script type="text/javascript">
		
			var idCheck;
			var pCheck;
			
			function idCheckWork(){
				alert("중복확인");
				idCheck = 1;
			}
		
			function pCheckWork(){

				if(document.getElementById("pw").value !="" && document.getElementById("pwCheck").value != ""){
					if(document.getElementById("pw").value == document.getElementById("pwCheck").value){
						alert("비밀번호 확인 성공!");
						pCheck=1;
						return true;
					}else{
						alert("비밀번호를 다시 확인해주세요.");
						return false;
					}
				}
				return true;
			}
			
			function joinWork(s){
				
				var id = document.getElementById("id");
				var pw = document.getElementById("pw");
				var name = document.getElementById("name");
				var addr = document.getElementById("addr");
				var phone = document.getElementById("phone");
				var email = document.getElementById("email");
				var pwCheck = document.getElementById("pwCheck");
				
				if(s == 'back'){//뒤로가기
					window.location.replace("/hrsys_web/html/LoginScr.html");
					return true;
				}
				
				if(s == 'JOIN'){//삽입
					
					if(id.value ==""){
						alert("id를 입력해 주세요.");
						id.focus();	
						return false;
					}
					
					if(pw.value ==""){
						alert("비밀번호를 입력해 주세요.");
						pw.focus();	
						return false;
					}
					
					if(name.value ==""){
						alert("이름을 입력해 주세요.");
						name.focus();	
						return false;
					}
					
					if(addr.value ==""){
						alert("주소를 입력해 주세요.");
						addr.focus();	
						return false;
					}
					
					if(phone.value ==""){
						alert("전화번호를 입력해 주세요.");
						phone.focus();		
						return false;
					}
					
					if(email.value ==""){
						alert("이메일주소를 입력해 주세요.");
						email.focus();		
						return false;
					}
					
					if(pCheck != 1){
						alert("비밀번호 확인을 해주세요.");
						pwCheck.focus();
						return false;
					}
					
					if(idCheck != 1){
						alert("아이디 중복확인을 해주세요.");
						return false;
					}
					
					document.joinForm.action = "/hrsys_web/insert.do";
				
				}	
				
				document.joinForm.submit();	
			}
			
		</script>
		<style type="text/css">
		
			body, html {
			    height: 100%;
			    margin: 0;
			}
			
			.bg {
			    /* The image used */
			    background-image: url("../img/secondPic.jpg");
			
			    /* Full height */
			    height: 40%; 
			
			    /* Center and scale the image nicely */
			    background-position: center;
			    background-repeat: no-repeat;
			    background-size: cover;
			}
			
			.indent {text-indent: 834px;}	
			.button {width: 110px;
			         height: 25px;
			         font-size: 13px;
			         cursor: pointer;
			         text-align: center;		         
		    }
		    
		    .button1 {border: none;
		    	      background-color: white;
		    		  font-style: oblique;
		    		  font-weight: bold;
					  color: gray;
					  padding: 15px 32px;
					  text-align: center;
					  text-decoration: none;
					  font-size: 25px;
					  margin: 4px 2px;
					  cursor: pointer;	    
		    }	
		    
		    .button1:hover {
		    	color: lightgray;		    
		    }
		    
		    .button:hover {background-color: white;
						  color: black;
						  border: 2px solid #555555;
						  border-radius: 2px;}	
		    
		    table, tr, td {
		    	padding: 5px;
		    }    
			
		</style>
	</head>
	<body>
		<div class="bg"></div>
		<br><br><br><br>
		
		<center>
		<form name="joinForm" method="POST" action="#">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" id="id"></td>
					<td><input type="button" class="button" id ="idCheck" value="ID중복확인" onclick="idCheckWork()"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="pw" id="pw"></td>
				</tr>
				<tr>
					<td>PW확인</td>
					<td><input type="password" name="pwCheck" id="pwCheck"></td>
					<td><input type="button" id="pwCheck" class="button" value="비밀번호확인" onclick="pCheckWork()"></td>
				</tr>
				<tr>
					<td>성명</td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" id="addr"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" id="phone"></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" name="email" id="email"></td>
				</tr>
			</table>
			</form>
		</center>	
		<br><br><br>	
		<center><p><button class="button1" id="back" onclick="joinWork('back')">뒤로가기</button>&nbsp;&nbsp;<button class="button1" id="joinButton" onclick="joinWork('JOIN')">가입하기</button></p></center>	
	</body>
</html>
	
	
	
	
	
			
		
	