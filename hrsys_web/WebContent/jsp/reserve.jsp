<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="EUC-KR">
		<title>예약하기</title>
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
		<h1>예약창에 오신 것을 환영합니다. 아래에 정보를 기입해주십시오.</h1>
		<center>
		<form name="reserveForm" method="POST">
		<div class="main">
		<br><br><br><br>
			<table>
				<tr>
					<td>체크인일자&nbsp;&nbsp;</td>
					<td><input type="text" id="checkin" name="checkin" style="text-align: center"></td>
					<td>&nbsp;&nbsp;ex:20170701</td>
				</tr>
				<tr>
					<td>체크아웃일자&nbsp;&nbsp;</td>
					<td><input type="text" id="checkout" name="checkout" style="text-align: center"></td>
					<td>&nbsp;&nbsp;ex:20170701</td>
				</tr>
				<tr>
					<td>방타입&nbsp;&nbsp;</td>
					<td><select name="roomtype" id="roomtype">
						  <option value="싱글">SINGLE</option> <!-- 1박에 5만원 -->
						  <option value="트윈">TWIN</option> <!-- 1박에 10만원 -->
						  <option value="트리플">TRIPLE</option> <!-- 1박에 15만원 -->
			  			</select>
			  		</td>
				</tr>
				<tr>
					<td>인원수&nbsp;&nbsp;</td>
					<td><select name="people">
						  <option value="1인">1인</option>
						  <option value="2인">2인</option>
						  <option value="3인">3인</option>
			  			</select>
			  		</td>
				</tr>				
				<tr>

					<td>총액&nbsp;&nbsp;</td>
					<td><input type="text" id="total" name="total" style="text-align: right" readonly></td>
				</tr>
			</table>
			<br><br>
			<button id="reserve">예약하기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id="back">뒤로가기</button>			
		</div>
		</form>
		</center>
		<div class="bg"></div>
	</body>
</html>