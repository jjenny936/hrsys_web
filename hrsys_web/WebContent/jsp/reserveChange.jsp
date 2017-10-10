<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.koitt.baby.vo.HrsysReserveVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>예약변경하기</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<style type="text/css">
		
			body, html {
			    height: 100%;
			    margin: 0;
			}
			
			.bg {
			    background-image: url('http://www.localhost:8089/hrsys_web/img/seventh.jpg');
			    height: 100%; 
			    background-position: center;
			    background-repeat: no-repeat;
			    background-size: cover;
			    padding-top: 57%;
			    z-index: -1;
			}
			
			table, tr, td{
				padding: 15px;
			}
			
			img{
				position: absolute;
				top: 72%;
				right: 1%;
				margin: 0;			
			}
			
			#main {
				width: 830px;
				height: 600px;
				background-color: rgba(255, 255, 255, 0.6);
				position: absolute;
				top: 20%;
				left: 28%;
				font-weight: bold;
			}
			
		 	div button {
		 			background-color: rgba(255, 255, 255, 0);
		 			border: none;
		    		font-style: oblique;
				    font-weight: bold;
					color: black;
					padding: 15px 32px;
					text-align: center;
					text-decoration: none;
					font-size: 20px;
					margin: 4px 2px;
				    cursor: pointer;		    
		    }	  
		    
		    div button:hover {
		    	color: gray;		    
		    }	
			
		</style>
		<script>
			$(document).ready(function(){
				$("#back").click(function(){
					document.reserveChangeForm.action="/hrsys_web/reserveSelect.do";
					document.reserveChangeForm.submit();					
				});
				
				$("#cancel").click(function(){
					document.reserveChangeForm.action="/hrsys_web/reserveDelete.do";
					document.reserveChangeForm.submit();					
				});
				
				$("#change").click(function(){
					document.reserveChangeForm.action="/hrsys_web/reserveUpdate.do";
					document.reserveChangeForm.submit();					
				});
			});
		</script>
	</head>
	<body>
		<form name="reserveChangeForm" method="POST" action="#">
			<div id="main">
				<center>
				<br><br><br><br>
				<table>
	<%
	request.setCharacterEncoding("EUC-KR");
	ArrayList aList = (ArrayList)request.getAttribute("reserveChangeResult");
	if(aList != null){
		int aSize = aList.size();
		for(int i = 0; i<aSize; i++){
			HrsysReserveVO rv = (HrsysReserveVO)aList.get(i);
		
			String mno = rv.getmNo();	
			String checkin = rv.getrCheckIn();
			String checkout = rv.getrCheckOut();
			String rno = rv.getrNo();
			String date = rv.getrDate();
			String people = rv.getrNum();
			String roomtype = rv.getrType();
			
			session.setAttribute("mno", mno);
			%>
			<input type="hidden" value="<%=rno%>" name="rno">
			<%
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

				<tr>
					<td>체크인일자&nbsp;&nbsp;</td>
					<td><input type="text" name="checkin" style="text-align: center" value=<%=checkin%>></td>
					<td>&nbsp;&nbsp;ex:20170701</td>
				</tr>
				<tr>
					<td>체크아웃일자&nbsp;&nbsp;</td>
					<td><input type="text" name="checkout" style="text-align: center" value=<%=checkout%>></td>
					<td>&nbsp;&nbsp;ex:20170701</td>
				</tr>
				<tr>
					<td>방타입&nbsp;&nbsp;</td>
					<td><select name="roomtype" id="roomtype">
							<option value="싱글">SINGLE</option>
							<option value="트윈">TWIN</option>
							<option value="트리플">TRIPLE</option>
					<%
					if(roomtype.equals("싱글")){
						%>
						<script>
							//this.roomtype.value="싱글";
							$("#roomtype").val("싱글");
						</script>
						<%
					}
					
					if(roomtype.equals("트윈")){
						%>
						<script>
							//this.roomtype.value="트윈";
							$("#roomtype").val("트윈");
						</script>
						<%
					}
					
					if(roomtype.equals("트리플")){
						%>
						<script>
							//this.roomtype.value="트리플";
							$("#roomtype").val("트리플");
						</script>
						<%
					}
					%>
			  			</select>
			  		</td>
				</tr>
				<tr>
					<td>인원수&nbsp;&nbsp;</td>
					<td><select id="people" name="people">
						  <option value="1인">1인</option>
						  <option value="2인">2인</option>
						  <option value="3인">3인</option>
					<%
					if(people.equals("1인")){
						%>
						<script>
							//this.people.value="1인";
							$("#people").val("1인");
						</script>
						<%
					}
					
					if(people.equals("2인")){
						%>
						<script>
							//this.people.value="2인";
							$("#people").val("2인");
						</script>
						<%
					}
					
					if(people.equals("3인")){
						%>
						<script>
							//this.people.value="3인";
							$("#people").val("3인");
						</script>
						<%
					}
					%>
			
			  			</select>
			  		</td>
				</tr>
				<tr>
					<td>총액&nbsp;&nbsp;</td>
					<td><input type="text" name="total" style="text-align: right" value=<%=t%> readonly></td>
				</tr>
	<%	}
	}
 %>		
			</table>
			<br><br><br>
			<button id="cancel">예약취소</button>&nbsp;&nbsp;&nbsp;<button id="change">변경하기</button>&nbsp;&nbsp;&nbsp;<button id="back">뒤로가기</button>
			</center>	
		</div>	
		<div class="bg"></div>
		</form>
	</body>
</html>