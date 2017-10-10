<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="EUC-KR">
		<title>�����ϱ�</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<style type="text/css">
		
			body, html {
			    height: 100%;
			    width: 100%;
			    margin: 0;
			}
			
			.bg {
			    background-image: url("../img/fifth.jpg");
			    height: 80%; 
			    background-position: center;
			    background-repeat: no-repeat;
			    background-size: cover;
			    opacity: 0.5;
			    z-index: 100;				
			}
			
			div.main {
				position: absolute;
				top: 30%;
				left: 23%; 
				width: 1020px;
				height: 550px;
				background-color: rgba(0, 0, 0, 0.5);
				color: white;
				z-index: 200;
				font-size: 120%;
			}
			
			div button {
				background-color: ligthgray; 
			    color: black;
			    cursor: pointer;
			    border-radius: 2px; 
			}
			
			div button:hover {background-color: #555555;
						  color: white;
						  border: 2px solid white;
						  border-radius: 2px;}			
			
			h1 {
				text-align: center;
				border-top: 1px solid rgba(165, 42, 42, 0.2);
				border-bottom: 1px solid rgba(165, 42, 42, 0.2);
				padding: 10px 0;
				letter-spacing: 5px;
				color: gray;
				margin: 30px;
			}
			
			table, tr, td{
				padding: 8px;
			}
			
		</style>
		<script>
			$(document).ready(function(){
				
				$("#back").click(function(){
					document.reserveForm.action="/hrsys_web/html/MainScr.html";
					document.reserveForm.submit();
				});
				
				$("#reserve").click(function(){
					document.reserveForm.action="/hrsys_web/reserve.do";
					document.reserveForm.submit();
				});
				
			});
			
		</script>
		
	</head>
	<body>
		<br><br>
		<h1>����â�� ���� ���� ȯ���մϴ�. �Ʒ��� ������ �������ֽʽÿ�.</h1>
		<center>
		<form name="reserveForm" method="POST">
		<div class="main">
		<br><br><br><br>
			<table>
				<tr>
					<td>üũ������&nbsp;&nbsp;</td>
					<td><input type="text" id="checkin" name="checkin" style="text-align: center"></td>
					<td>&nbsp;&nbsp;ex:20170701</td>
				</tr>
				<tr>
					<td>üũ�ƿ�����&nbsp;&nbsp;</td>
					<td><input type="text" id="checkout" name="checkout" style="text-align: center"></td>
					<td>&nbsp;&nbsp;ex:20170701</td>
				</tr>
				<tr>
					<td>��Ÿ��&nbsp;&nbsp;</td>
					<td><select name="roomtype" id="roomtype">
						  <option value="�̱�">SINGLE</option> <!-- 1�ڿ� 5���� -->
						  <option value="Ʈ��">TWIN</option> <!-- 1�ڿ� 10���� -->
						  <option value="Ʈ����">TRIPLE</option> <!-- 1�ڿ� 15���� -->
			  			</select>
			  		</td>
				</tr>
				<tr>
					<td>�ο���&nbsp;&nbsp;</td>
					<td><select name="people">
						  <option value="1��">1��</option>
						  <option value="2��">2��</option>
						  <option value="3��">3��</option>
			  			</select>
			  		</td>
				</tr>				
				<tr>

					<td>�Ѿ�&nbsp;&nbsp;</td>
					<td><input type="text" id="total" name="total" style="text-align: right" readonly></td>
				</tr>
			</table>
			<br><br>
			<button id="reserve">�����ϱ�</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id="back">�ڷΰ���</button>			
		</div>
		</form>
		</center>
		<div class="bg"></div>
	</body>
</html>