<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>환영합니다.</title>
		<style type="text/css">
			@import url(//fonts.googleapis.com/earlyaccess/hanna.css);
			
			body, html {
			    height: 100%;
			    width: 100%;
			    margin: 20;
			}
			
			
			p#main{
				font-family: 'Hanna';
				color: rgba(0, 0, 0, 0.7);
				font-size: 50px;
			}
						
			nav {			
				margin: 10px;
			} 
			
			nav ul {
				list-style: none; 
				text-align: center; 
				border-top: 1px solid black; 
				border-bottom: 1px solid black;
				padding: 10px 0; 
			}
				   
			nav ul li {
				display: inline; 
	            text-transform: uppercase; 
	            padding: 10px 40px; 
	            letter-spacing: 10px; 
            }	
			          	    
			nav ul li a {
				font-family: 'Hanna';
				font-size: 25px;
				text-decoration: none;
				color: gray;
				padding-top: 20px;
				padding-buttom: 20px;
			}
						 
			nav ul li a:hover {
				font-weight: bold;
				margin-top: 10px;
				margin-button: 10px;
				text-decoration: underline;
			}
			
			div#content{
				border: 1px solid black;
				width: 100%;
				padding: 50px;
				float: left;
				height: 700px;
				box-sizing: border-box;
				background-color: black;
				overflow: auto;
			}
			
			div#footer {
				position: absolute;
				bottom: 0;
				border-top: 1px solid rgba(0, 0, 0, 0.3);
				color: #8DB6CD;
				width: 100%;
				text-align: center;
			}
			
			p#copy {
				font-size: 17px;
				margin: 5px;
			}
			
			p#us {
				font-size: 13px;
				margin: 5px;
			}
			
			p#label{
				color: white;
				font-size: 50px;
			}
		</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		</head>
	<body>
	<%
	request.setCharacterEncoding("EUC-KR");
	String eNo = request.getParameter("eNo");
	String ePos = request.getParameter("ePos");
	String eDept = request.getParameter("eDept");
	String eName = request.getParameter("eName");
	
	session.setAttribute("eNo", eNo);
	session.setAttribute("ePos", ePos);
	session.setAttribute("eDept", eDept);
	session.setAttribute("eName", eName);
	%>
	
		<div id="header" align="center">
			<p id="main">&diams;&nbsp;&nbsp;MOONBUCKS COFFEE INC.&nbsp;&nbsp;&diams;</p>
		</div>

		<nav>
			<ul>
				<li><a href="/chainCo/main.jsp">홈</a></li>
				<li><a href="#">출석체크</a></li>
				<li><a href="workflow/mainScreen.do">전자결재</a></li>
				<li><a href="emp/empEntry.do">사원정보</a></li>
				<li><a href="branch/branchEntry.do">점포정보</a></li>
				<li><a href="#">게시판</a></li>
				<li><a href="/chainCo/logout.jsp">로그아웃</a></li>
			</ul>
		</nav>

		<div id="content">
		<center>
			
			<img src="/chainCo/img/moon.jpg" />	
		</center>
		</div>
	
		<div id="footer">		
			<p id="copy">&copy; 2017, all rights reserved.</p>
			<p id="us">나현수 오근주 최재은 </p>
		</div>
	
	</body>
</html>