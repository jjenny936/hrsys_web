<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>로그인</title>
		<style type="text/css">
			@import url(//fonts.googleapis.com/earlyaccess/hanna.css);
			
		    body {
		       background: url('/chainCo/img/login.jpg');
		       background-repeat: no-repeat;
   			   background-attachment: fixed;}
		
			
			h1 {
				font-family: 'Hanna';
				color: rgba(0, 0, 0, 0.7);
			}
			
			table tr td {
				padding: 10px;
			}
			
			input[type=button] {
				border: none;
    	        background-color: rgba(255, 255, 255, 0);
    		    font-style: italic;
    		    font-weight: bold;
    		    font-family: 'Hanna';
			    color: black;
			    padding: 15px 32px;
			    text-align: center;
			    text-decoration: none;
			    font-size: 30px;
			    margin: 4px 2px;
			    cursor: pointer;		    
		    }	  
		    
		    input[type=button]:hover {
		    	color: lightgray;		    
		    }
		    
		    #mainDiv{
		    	border: none;
		    	background-color: rgba(255, 255, 255, 0.4);
		    	padding: 25px;
		    	margin-top: 11%;
		    	margin-left: 5%;
		    	width: 65%;
		    }
		    
		    div#firstPart{
		    	border: none;		    	
		    }
		    
		    #first {
		    	color: white;
		    	font-size: 110px;
		    	font-weight: bold;
		    }
		    
		    #second {
		    	color: white;
		    	font-size: 75px;
		    	font-weight: bold;
		    }
		    
		    #lastPart {
		    	position: absolute;
		    	border: none;	
		    	bottom: 0;
		    	right: 0;
		    	color: white;
		    	font-size: 65px;
		    	font-weight: bold;
		    	text-align: right;
		    }
		    
		</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#login").click(function(){
					$("#loginForm").attr("action", "emp/login.do");
					$("#loginForm").submit();
				});
			});
		</script>
	</head>
	<body>
	<div id="firstPart">
			<label id="first">MOONBUCKS COFFEE INC.</label><br>
			<label id="second">Collaborative Work System</label>
	</div>
	<center>
		<div id="mainDiv">
		<form id="loginForm" name="loginForm" method="POST">
			<table>
				<tr>
					<td style="font-weight:bold;">ID</td>
					<td><input type="text" size="50" name="eId" id="eId"/></td>
					<td rowspan="2">
						<input type="button" value="로그인" id="login">
					</td>
				</tr>
				<tr>
					<td style="font-weight:bold;">PW</td>
					<td><input type="password" size="50" name="ePw" id="ePw"/></td>
					<td></td>
				</tr>
			</table>
		</form>
		</div>
	</center>
	<div id="lastPart">
			We Sell The Experience <br>
			Beyond Just A Cup of Coffee
	</div>
	</body>
</html>