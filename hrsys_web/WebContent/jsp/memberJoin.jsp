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
				alert("�ߺ�Ȯ��");
				idCheck = 1;
			}
		
			function pCheckWork(){

				if(document.getElementById("pw").value !="" && document.getElementById("pwCheck").value != ""){
					if(document.getElementById("pw").value == document.getElementById("pwCheck").value){
						alert("��й�ȣ Ȯ�� ����!");
						pCheck=1;
						return true;
					}else{
						alert("��й�ȣ�� �ٽ� Ȯ�����ּ���.");
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
				
				if(s == 'back'){//�ڷΰ���
					window.location.replace("/hrsys_web/html/LoginScr.html");
					return true;
				}
				
				if(s == 'JOIN'){//����
					
					if(id.value ==""){
						alert("id�� �Է��� �ּ���.");
						id.focus();	
						return false;
					}
					
					if(pw.value ==""){
						alert("��й�ȣ�� �Է��� �ּ���.");
						pw.focus();	
						return false;
					}
					
					if(name.value ==""){
						alert("�̸��� �Է��� �ּ���.");
						name.focus();	
						return false;
					}
					
					if(addr.value ==""){
						alert("�ּҸ� �Է��� �ּ���.");
						addr.focus();	
						return false;
					}
					
					if(phone.value ==""){
						alert("��ȭ��ȣ�� �Է��� �ּ���.");
						phone.focus();		
						return false;
					}
					
					if(email.value ==""){
						alert("�̸����ּҸ� �Է��� �ּ���.");
						email.focus();		
						return false;
					}
					
					if(pCheck != 1){
						alert("��й�ȣ Ȯ���� ���ּ���.");
						pwCheck.focus();
						return false;
					}
					
					if(idCheck != 1){
						alert("���̵� �ߺ�Ȯ���� ���ּ���.");
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
					<td><input type="button" class="button" id ="idCheck" value="ID�ߺ�Ȯ��" onclick="idCheckWork()"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="pw" id="pw"></td>
				</tr>
				<tr>
					<td>PWȮ��</td>
					<td><input type="password" name="pwCheck" id="pwCheck"></td>
					<td><input type="button" id="pwCheck" class="button" value="��й�ȣȮ��" onclick="pCheckWork()"></td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td>�ּ�</td>
					<td><input type="text" name="addr" id="addr"></td>
				</tr>
				<tr>
					<td>��ȭ��ȣ</td>
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
		<center><p><button class="button1" id="back" onclick="joinWork('back')">�ڷΰ���</button>&nbsp;&nbsp;<button class="button1" id="joinButton" onclick="joinWork('JOIN')">�����ϱ�</button></p></center>	
	</body>
</html>
	
	
	
	
	
			
		
	