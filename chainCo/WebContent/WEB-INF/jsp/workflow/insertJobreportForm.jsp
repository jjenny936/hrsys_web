<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="coffee.chain.emp.vo.EmpVO" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>문서작성하기 - 일일업무보고</title>
		<style type="text/css">
			@import url(//fonts.googleapis.com/earlyaccess/hanna.css);
			
			body {
		       background: url('../img/cafe2.jpg');
		       background-repeat: no-repeat;
  			   background-attachment: fixed;}
			
			p#main{
				font-family: 'Hanna';
				font-size: 50px;
				color: white;
				background-color: black;
			}
			
			div#header {
				background-color: black;
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
			
			div#aside {
				border: 1px solid black;
				width: 23%;
	            margin: 20px;
	            float: left;
	            padding: 30px;
	            box-sizing: border-box;
	            text-align: center;
	            font-size: 20px
			}
			
			div#content{
				border: 1px solid black;
				position: absolute;
				top: 250px;
				right: 20px;
				text-align: center;
				font-size: 20px;
				width:73%;
			    height: 650px;
			    scrollable: true;
			    overflow: auto;
			}
			
			div#footer {
				position: absolute;
				bottom: 0;
				border-top: 1px solid rgba(0, 0, 0, 0.3);
				color: #8DB6CD;
				float: bottom;
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
					
			ul.nav-menu-list-style .nav-header{
				border-top:1px solid #FFFFFF;
				border-bottom:1px solid #e8e8e8;
				display:block;
				margin:0;
				line-height:42px;
				padding:0 8px;
				font-weight:600;
			}
			
			ul.nav-menu-list-style{
				list-style:none; 
				padding:0px; 
				margin:0px;
				font-size: 27px;
			}
			
			ul.bullets{
				list-style:none;
			}
			
			button.sideButt {
				border: none;
    	        background-color: Transparent;
				text-decoration: none;
				cursor: pointer;
				font-size: 22px;
			}
			
			button.sideButt:hover{
				font-weight: bold;
			}		
			
			p#main{
				font-family: 'Hanna';
				font-size: 50px;
				color: white;
				background-color: black;
			}
			
			div#header {
				background-color: black;
			}
						
			nav {			
				margin: 10px;
			} 
			
			nav ul {
				list-style: none; 
				text-align: center; 
				border-top: 1px solid white; 
				border-bottom: 1px solid white;
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
				color: white;
				padding-top: 20px;
				padding-buttom: 20px;
			}
						 
			nav ul li a:hover {
				font-weight: bold;
				margin-top: 10px;
				margin-button: 10px;
				text-decoration: underline;
			}
			
			div#aside {
				border: 1px solid white;
				width: 23%;
	            margin: 20px;
	            float: left;
	            padding: 30px;
	            box-sizing: border-box;
	            text-align: center;
	            font-size: 20px
			}
			
			div#content {
				border: 1px solid white;
				background-color: rgba(255, 255, 255, 0.6);
				font-weight: bold;
				position: absolute;
				top: 250px;
				right: 20px;
				text-align: center;
				font-size: 20px;
				width:73%;
			    height: 650px;
			    scrollable: true;
			    overflow: auto;
			}
			
			div#footer {
				position: absolute;
				bottom: 0;
				border-top: 1px solid #8DB6CD;
				color: #8DB6CD;
				float: bottom;
				width: 100%;
				text-align: center;
			}
			
			ul.nav-menu-list-style .nav-header{
				border-top:1px solid #FFFFFF;
				border-bottom:1px solid #e8e8e8;
				display:block;
				margin:0;
				line-height:42px;
				padding:0 8px;
				font-weight:600;
				color:white;
			}
			
			ul.nav-menu-list-style{
				list-style:none; 
				padding:0px; 
				margin:0px;
				font-size: 27px;
				color:white;
			}
			
			ul.bullets{
				list-style:none;
			}
			
			button.sideButt {
				border: none;
    	        background-color: Transparent;
				text-decoration: none;
				cursor: pointer;
				font-size: 22px;
				color: white;
			}
			
			p#copy {
				font-size: 17px;
				margin: 5px;
			}
			
			p#us {
				font-size: 13px;
				margin: 5px;
			}
			
			button.sideButt:hover {
				font-weight: bold;
			}
			
			h1 {
				color: white;
			}
			
			.go {
				cursor: pointer;
				background-color: black;
				border-radius: 10%;
				border: none;
				font-weight: bold;
				color: white;
			}
			
			.go:hover {
				color: black;
				background-color: Transparent;
				font-weight: bold;
			}
		</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){				
				$('.tree-toggle').click(function(){
					$(this).parent().children('ul.tree').toggle(200);
				});
				
				$(function(){
					$('.tree-toggle').parent().children('ul.tree').toggle(200);
				});

				$("#save").click(function() {
					$("#insertForm").attr("action","/chainCo/workflow/saveDoc.do");
					$("#insertForm").submit();
				});
				$("#submitDoc").click(function() {
					$("#insertForm").attr("action","/chainCo/workflow/submitDoc.do");
					$("#insertForm").submit();
				});	
				
				$("#goback").click(function() {
					$("#insertForm").attr("action","/chainCo/workflow/submitBox.do");
					$("#insertForm").submit();
				});	
				
			});
			

		</script>
	</head>
	<body>
		<%
		EmpVO login = (EmpVO)session.getAttribute("login");
		if(login==null){
			%>
			<script>
				alert("세션이 만료되었습니다. 다시 로그인 해주세요");
				location.href="/chainCo/WEB-INF/jsp/workflow/sessionEnd.jsp";
			</script>
			<%
		}
		%>
		<div id="header" align="center">
			<p id="main">&diams;&nbsp;&nbsp;MOONBUCKS COFFEE INC.&nbsp;&nbsp;&diams;</p>
		</div>	
		<nav>
			<ul>
				<li><a href="/chainCo/main.jsp">홈</a></li>
				<li><a href="#">출석체크</a></li>
				<li><a href="/chainCo/workflow/mainScreen.do">전자결재</a></li>
				<li><a href="/chainCo/emp/empEntry.do">사원정보</a></li>
				<li><a href="/chainCo/branch/branchEntry.do">점포정보</a></li>
				<li><a href="#">게시판</a></li>
				<li><a href="/chainCo/logout.jsp">로그아웃</a></li>
			</ul>
		</nav>
		
		<aside>
			<div id="aside">			
				<div class="container">
  					<div class="row">
    					<h1>문서 결재하기</h1>
  					</div>
				</div>	
				<br><br>			
				<div class="well no-padding">
					<div>
    					<ul class="nav nav-list nav-menu-list-style">
        					<li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
        							<span class="glyphicon glyphicon-folder-close m5"></span>
        							 &loz;결재문서함
                     				<span class="menu-collapsible-icon glyphicon glyphicon-chevron-down"></span>
                     			</label>
               					<ul class="nav nav-list tree bullets">
	                   			 	<li><a href="/chainCo/workflow/submitBox.do"><button class="sideButt">&raquo;&nbsp;상신함</button></a></li>
	                   				<li><a href="/chainCo/workflow/approvalBox.do"><button class="sideButt">&raquo;&nbsp;승인함</button></a></li> 
	                   				<li><a href="/chainCo/workflow/denyBox.do"><button class="sideButt">&raquo;&nbsp;반려함</button></a></li>
	                   				<li><a href="/chainCo/workflow/receptionBox.do"><button class="sideButt">&raquo;&nbsp;수신함</button></a></li> 
	                   				<li><a href="/chainCo/workflow/approvalHistory.do"><button class="sideButt">&raquo;&nbsp;결재처리내역</button></a></li> 
	                   				<li><a href="#"><button class="sideButt">&raquo;&nbsp;참조문서함</button></a></li>                        
                            	</ul>
                            </li>                                                     
                        </ul>
                    </div>
                </div>
            </div>   
            <br><br><br><br>        
		</aside>
		
		<section>
			<div id="content">
			<div id="mainContent" name="mainContent">
			<form id="insertForm" name="insertForm" method="POST">				 				 
				<p /><p /><p />
				<center>
				<table id="table1">
					<tr>
						<td>제목</td>
						<td><input type="text" id="wTitle" name="wTitle"></td>
					</tr>
					<tr>
						<td>소속부서</td>
						<td>${login.ePos}</td>
					</tr>
					<tr>
						<td>직위</td>
						<td>${login.eDept}</td>
					</tr>															
					<tr>
						<td>작성자</td>
						<td>${login.eName}</td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td></td>
					</tr>						
					<tr>
						<td>금일실시사항</td>
					</tr>
					<tr>
						<td>오전</td>
						<td>오후</td>
					</tr>						
					<tr>
						<td><input type="text" id="wWtodayDone1" name="wWtodayDone1"></td>
						<td><input type="text" id="wWtodayDone2" name="wWtodayDone2"></td>
					</tr>					
					<tr>
						<td>익일예정사항</td>
						<td><input type="text" id="wWnextdayDo" name="wWnextdayDo"></td>
					</tr>						
					<tr>
						<td>지시사항</td>
						<td><input type="text" id="wWinstruction" name="wWinstruction"></td>
					</tr>
				</table>
				</center>
			</form>
				<input type="button" class="go" id="submitDoc" name="submitDoc" value="보내기">
				<input type="button" class="go" id="save" name="save" value="임시저장">
				<a href="#"><button class="go" id="goback" name="goback">뒤로 가기</button></a>
			</div>
			</div>
		</section>
	</body>
</html>




















