<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.koitt.baby.vo.HrsysReserveVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	
		<meta charset="EUC-KR">
		<meta http-equiv="X-UA-Compatible" content="IE=5">
		<meta http-equiv="X-UA-Compatible" content="IE=6">
		<meta http-equiv="X-UA-Compatible" content="IE=7">
		<meta http-equiv="X-UA-Compatible" content="IE=8">
		<meta http-equiv="X-UA-Compatible" content="IE=9">
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="X-UA-Compatible" content="IE=11">
		<title>예약조회하기</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
				<style type="text/css">
    					
			body {background: url('http://www.localhost:8089/hrsys_web/img/sixth.jpg');
			      background-repeat: no-repeat;
    			  background-attachment: fixed;
    			  background-position: center;
			      background-repeat: no-repeat;
			      background-size: contain;	
    			  height: 100%;
			      width: 100%;
			      margin: 0; }	
			      
			h1 {
				text-align: center;
				border-top: 1px solid rgba(165, 42, 42, 0.2);
				border-bottom: 1px solid rgba(165, 42, 42, 0.2);
				padding: 10px 0;
				letter-spacing: 8px;
				color: darkgray;
				margin: 30px;
			}      
			      
			button {border: none;
		    		font-style: oblique;
				    font-weight: bold;
				    text-shadow: 2px 2px gray;
				    background-color: Transparent;
					color: rgba(255, 255, 255, 0.8);
					padding: 15px 32px;
					text-align: center;
					text-decoration: none;
					font-size: 25px;
					margin: 4px 2px;
				    cursor: pointer;		    
		    }	  
		    
		    button:hover {
		    	color: rgba(255, 255, 255, 0.5);		    
		    }
    			  
			table {
				border: 1px solid white;
				border-collapse: collapse;
				background-color: rgba(255, 255, 255, 0.6);
	
			}
			
			table tr th {
				border: 1px solid white;			
				border-bottom: thick double white;
				padding: 5px;
				width: 120px;
				height: 25px;
				font-weight: bold;
			}
			
			table tr td {
				padding: 5px;
				width: 120px;
				height: 20px;
			}
			
			tr#contents td {
				border: 1px solid white;
				font-weight: bold;
				cursor: pointer;
			}
			
			tr#contents:hover {
				background-color: rgba(255, 255, 255, 0.4);
			}
			
			td:nth-child(1){text-align: right;}
			td:nth-child(6){text-align: right;}
			td:nth-child(7){text-align: right;}
			td:nth-child(4){text-align: left;}			
			td:nth-child(2){text-align: center;}
			td:nth-child(3){text-align: center;}
			td:nth-child(5){text-align: center;}
		</style>
		<script>
			$(document).ready(function(){
				$("#back").click(function(){
					document.reserveSelectForm.action="/hrsys_web/html/MainScr.html";
					document.reserveSelectForm.submit();
				});
				
				$("#select").click(function(){
					document.reserveSelectForm.action="/hrsys_web/reserveChange.do";
					document.reserveSelectForm.submit();
				});			
				
				$("tr.contents").click(function() {
					$(this).css("background-color", "rgba(255, 255, 255, 0.6)");
				    var rno = $(this).children("#rno").map(function() {
				        return $(this).text();
				    }).get();

				    $("#dif").val(rno);
				}); 
				
			});
		</script>
	</head>
	<body>
		<br><br><br>
	<h1>조회하고자 하는 예약건을 선택해 주십시오.</h1>
	<br><br><br><br><br><br><br>
	<form name = "reserveSelectForm" method="POST">
		<center>
		<table>
		<tr>	
				<th>예약번호</th>
				<th>체크인일자</th>
				<th>체크아웃일자</th>
				<th>방타입</th>
				<th>예약일</th>
				<th>결제금액</th>
				<th>인원수</th>
			</tr>
		<%
		request.setCharacterEncoding("EUC-KR");
		ArrayList aList = (ArrayList)request.getAttribute("reserveSelectResult");
		if(aList != null){
			int aSize = aList.size();
			for(int i = 0; i<aSize; i++){
				HrsysReserveVO rv = (HrsysReserveVO)aList.get(i);

				String checkin = rv.getrCheckIn();
				String checkout = rv.getrCheckOut();
				String rno = rv.getrNo();
				String date = rv.getrDate();
				String people = rv.getrNum();
				String roomtype = rv.getrType();	
				
				int roomrate = 0;
				if(roomtype.equals("싱글")){
					roomrate=50000;
				}
				if(roomtype.equals("트윈")){
					roomrate=100000;
				}
				if(roomtype.equals("트리플")){
					roomrate=150000;
				}
				
				int cin = Integer.parseInt(checkin);
				int cout = Integer.parseInt(checkout);
				
				int total = (cout-cin)*roomrate;
				String t = String.format("%,d", total) +"원";

			%>
			<input type="hidden" name="dif" id="dif"/>
			<tr id="contents" class="contents">
				<td id="rno"><%=rno%></td>
				<td id="checkin"><%=checkin%></td>
				<td id="checkout"><%=checkout%></td>
				<td id="roomtype"><%=roomtype%></td>
				<td id="date"><%=date%></td>
				<td id="total"><%=t%></td>
				<td id="people"><%=people%></td>
			</tr>
	<%
			
			} }%>
		
		</table>
		<br><br><br><br><br><br><br><br>
		<p><button id="select">조회하기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id="back">뒤로가기</button></p>
		</center>
		</form>
	</body>
</html>