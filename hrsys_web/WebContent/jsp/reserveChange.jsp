<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.koitt.baby.vo.HrsysReserveVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>���ຯ���ϱ�</title>
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
			if(roomtype.equals("�̱�")){
				roomrate=50000;
			}
			if(roomtype.equals("Ʈ��")){
				roomrate=100000;
			}
			if(roomtype.equals("Ʈ����")){
				roomrate=150000;
			}
			
			int cin = Integer.parseInt(checkin);
			int cout = Integer.parseInt(checkout);
			
			int total = (cout-cin)*roomrate;
			String t = String.format("%,d", total) +"��";

	%>

				<tr>
					<td>üũ������&nbsp;&nbsp;</td>
					<td><input type="text" name="checkin" style="text-align: center" value=<%=checkin%>></td>
					<td>&nbsp;&nbsp;ex:20170701</td>
				</tr>
				<tr>
					<td>üũ�ƿ�����&nbsp;&nbsp;</td>
					<td><input type="text" name="checkout" style="text-align: center" value=<%=checkout%>></td>
					<td>&nbsp;&nbsp;ex:20170701</td>
				</tr>
				<tr>
					<td>��Ÿ��&nbsp;&nbsp;</td>
					<td><select name="roomtype" id="roomtype">
							<option value="�̱�">SINGLE</option>
							<option value="Ʈ��">TWIN</option>
							<option value="Ʈ����">TRIPLE</option>
					<%
					if(roomtype.equals("�̱�")){
						%>
						<script>
							//this.roomtype.value="�̱�";
							$("#roomtype").val("�̱�");
						</script>
						<%
					}
					
					if(roomtype.equals("Ʈ��")){
						%>
						<script>
							//this.roomtype.value="Ʈ��";
							$("#roomtype").val("Ʈ��");
						</script>
						<%
					}
					
					if(roomtype.equals("Ʈ����")){
						%>
						<script>
							//this.roomtype.value="Ʈ����";
							$("#roomtype").val("Ʈ����");
						</script>
						<%
					}
					%>
			  			</select>
			  		</td>
				</tr>
				<tr>
					<td>�ο���&nbsp;&nbsp;</td>
					<td><select id="people" name="people">
						  <option value="1��">1��</option>
						  <option value="2��">2��</option>
						  <option value="3��">3��</option>
					<%
					if(people.equals("1��")){
						%>
						<script>
							//this.people.value="1��";
							$("#people").val("1��");
						</script>
						<%
					}
					
					if(people.equals("2��")){
						%>
						<script>
							//this.people.value="2��";
							$("#people").val("2��");
						</script>
						<%
					}
					
					if(people.equals("3��")){
						%>
						<script>
							//this.people.value="3��";
							$("#people").val("3��");
						</script>
						<%
					}
					%>
			
			  			</select>
			  		</td>
				</tr>
				<tr>
					<td>�Ѿ�&nbsp;&nbsp;</td>
					<td><input type="text" name="total" style="text-align: right" value=<%=t%> readonly></td>
				</tr>
	<%	}
	}
 %>		
			</table>
			<br><br><br>
			<button id="cancel">�������</button>&nbsp;&nbsp;&nbsp;<button id="change">�����ϱ�</button>&nbsp;&nbsp;&nbsp;<button id="back">�ڷΰ���</button>
			</center>	
		</div>	
		<div class="bg"></div>
		</form>
	</body>
</html>