<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page import="coffee.chain.branch.vo.BranchVO" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>폐점관리 페이지 입니다.</title>
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
			
			button.sideButt:hover{
				font-weight: bold;
			}
			
			h1 {
				color: white;
			}

		</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){				
				$('.tree-toggle').click(function(){
					$(this).parent().children('ul.tree').toggle(200);
				});
				
				$(function(){
					$('.tree-toggle').parent().children('ul.tree').toggle(200);
				});	
				
				$("#update").click(function(){
					$("#choiceFlag").val("update");
					var sessionEdept = $("#sessionEdept").val();
					var sessionEpos = $("#sessionEpos").val();
					
					if(sessionEdept == '점포관리부' || sessionEpos == '사장'){
						window.open("", "pop", "width=600, height=600, left=600px, top=200px");
						$("#deleteForm").attr("action", "/chainCo/branch/list.do");
						$("#deleteForm").attr("target", "pop");
						$("#deleteForm").submit();
					}else{
						alert("귀하는 점포정보를 수정할 권한이 없습니다.");
					}
				});	
				
				$("#delete").click(function(){
					$("#choiceFlag").val("delete");
					var sessionEdept = $("#sessionEdept").val();
					var sessionEpos = $("#sessionEpos").val();
					
					if(sessionEdept == null && sessionEpos ==  null){
						alert("세션이 만료되었습니다. 다시 로그인 해주세요.");
					}
					
					if(sessionEdept == '점포관리부' || sessionEpos == '사장'){
						$("#deleteForm").attr("action", "/chainCo/branch/branchDelete.do");
						$("#deleteForm").submit();
					}else{
						alert("귀하는 폐점관리할 권한이 없습니다.");
					}
				});	
				
				$("#sales").click(function(){
					$("#deleteForm").attr("action", "/chainCo/branch/sales.do");
					$("#deleteForm").submit();
				});
			});
			
			function branches(branch){
				$("#bName").val(branch);
				
				$("#deleteForm").attr("action", "/chainCo/branch/branchList.do");
				$("#deleteForm").submit();
			}	
			
			function deleteWork(){
				$("#choiceFlag").val("delete");
				window.open("", "pop", "width=600, height=600, left=600px, top=200px");
				$("#deleteForm").attr("action", "/chainCo/branch/list.do");
				$("#deleteForm").attr("target", "pop");
				$("#deleteForm").submit();
			}
			
			function reopenWork(){
				$("#choiceFlag").val("reopen");
				window.open("", "pop", "width=600, height=600, left=600px, top=200px");
				$("#deleteForm").attr("action", "/chainCo/branch/list.do");
				$("#deleteForm").attr("target", "pop");
				$("#deleteForm").submit();
			}
		</script>
	</head>
	<body>
	<%
	String sessionEno = (String)session.getAttribute("eNo");
	String sessionEpos = (String)session.getAttribute("ePos");
	String sessionEdept = (String)session.getAttribute("eDept");
	%>
		<form name="deleteForm" id="deleteForm" method="POST">
			<input type="hidden" name="choiceFlag" id="choiceFlag" />
			<input type="hidden" name=bName id="bName" />
			<input type="hidden" name="sessionEdept" id="sessionEdept" value="<%=sessionEdept%>"/>
			<input type="hidden" name="eNo" id="eNo" value="<%=sessionEno%>"/>
			<input type="hidden" name="sessionEpos" id="sessionEpos" value="<%=sessionEpos%>"/>
		</form>

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
    					<h1>점포정보 열람하기</h1>
  					</div>
				</div>	
				<br><br>			
				<div class="well no-padding">
					<div>
    					<ul class="nav nav-list nav-menu-list-style">
        					<li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
        							 &loz;&nbsp;지점별 기본정보
                     			</label>
               					<ul class="nav nav-list tree bullets">
	                   			 	<li><button class="sideButt" id="gasan" onclick="branches('가산점')">&raquo;&nbsp;가산점</button></li>
	                   				<li><button class="sideButt" id="gangnam" onclick="branches('강남점')">&raquo;&nbsp;강남점</button></li>                    
                            	</ul>
                            </li>
                            <br>
                            <li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
    							 	&loz;&nbsp;지점별 실적
                     			</label>
                     			<ul class="nav nav-list tree bullets">
	                   			 	<li><button class="sideButt" id="sales">&raquo;&nbsp;매출보기</button></li>                       
                            	</ul>
                            </li>
                            <br>
                            <li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
    							 	&loz;&nbsp;점포관리
                     			</label>
                     			<ul class="nav nav-list tree bullets">
	                   			 	<li><button class="sideButt" id="update">&raquo;&nbsp;정보 수정하기</button></li> 
	                   			 	<li><button class="sideButt" id="delete">&raquo;&nbsp;폐점관리</button></li>                      
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
			<center>
				<c:if test="${not empty branchDelete}">
					<h2><strong>&spades;폐점 리스트&spades;</strong></h2>
					<br><br>
					<c:forEach items="${branchDelete}" var="row">
						<h3>&bull;${row.bName}&bull;</h3>
						<table>
							<tr>
								<td>지점코드: </td>
								<td>${row.bNo}</td>
							</tr>
							<tr>
								<td>지역구분: </td>
								<td>${row.bLocation}</td>
							</tr>
							<tr>
								<td>지점장: </td>
								<td>${row.eName} (사원번호: ${row.eNo})</td>
							</tr>
							<tr>
								<td>개점일자: </td>
								<td>${row.bInsertDate}</td>
							</tr>
							<tr>
								<td>폐점일자: </td>
								<td>${row.bUpdateDate}</td>
							</tr>
						</table>
						<br>
					</c:forEach>
				</c:if>
				<c:if test="${empty branchDelete}">
					<h2>폐점 확인된 지점이 없습니다.</h2>
				</c:if>
				<br><br>
				<input type="button" id="deleteButt" value="추가폐점관리" onclick="deleteWork()">
				<input type="button" id="reopenButt" value="재개업설정" onclick="reopenWork()">
				</center>
			</div>
		</section>
		
		<footer>
			<div id="footer">			
				<p id="copy">&copy; 2017, all rights reserved.</p>
				<p id="us">나현수 오근주 최재은 </p>		
			</div>
		</footer>
	</body>
</html>