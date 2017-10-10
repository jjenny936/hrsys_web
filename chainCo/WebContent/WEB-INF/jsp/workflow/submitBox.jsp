<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>전자결재 페이지</title>
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
			
			button.go {
				cursor: pointer;
				background-color: black;
				border-radius: 10%;
				border: none;
				font-weight: bold;
				color: white;
			}
			
			button.go:hover {
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
			});
			

		</script>
	</head>
	<body>
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
			<center>
			<div id="content1">
			<br><br>
				<a href="/chainCo/workflow/insertJobreportForm.do"><button class="go">일일업무보고</button></a>
				<a href="/chainCo/workflow/insertVacationForm.do"><button class="go">휴가신청서</button></a>
				<a href="/chainCo/workflow/insertResignForm.do"><button class="go">사직서</button></a>
			</div>

			<br><br>
			<div id="content2">
			임시저장된 문서<br>
			<table border="1">
				<colgroup>
					<col width="200px">
					<col width="200px">
					<col width="200px">					
				</colgroup>
				<thead>
					<tr>
						<th>문서종류</th>
						<th>제목</th>
						<th>생성일</th>
					</tr>				
				</thead>
				<tbody>
					<c:if test="${empty viewTempList}">
							<tr>
								<td colspan="3" align="center">
								문서 목록이 존재하지 않습니다.</td>
							</tr>
					</c:if>
					<c:forEach items="${viewTempList}" var="workflow">
						<tr>
							<td align="center">${workflow.wFormat}</td>
							<td align="center">${workflow.wTitle}</td>
							<td align="center">${workflow.wInsertDate}</td>
						</tr>					
					</c:forEach>			
				</tbody>
			</table>

				
			</div>	
			<br><br>
			<div id="content3">
			상신한 문서<br>
			<table border="1">
				<colgroup>
					<col width="100px">
					<col width="100px">
					<col width="100px">	
					<col width="100px">
					<col width="100px">	
					<col width="100px">					
				</colgroup>
				<thead>
					<tr>
						<th>1단계<br>결재여부</th>
						<th>결재상태</th>
						<th>문서종류</th>
						<th>제목</th>
						<th>생성일</th>
						<th>1단계<br>결재일자</th>
					</tr>				
				</thead>
				<tbody>
					<c:if test="${empty viewSubmitList}">
							<tr>
								<td colspan="6" align="center">
								문서 목록이 존재하지 않습니다.</td>
							</tr>
					</c:if>
					<c:forEach items="${viewSubmitList}" var="workflow1">
						<tr>
							<td align="center">${workflow1.wFirstState}</td>
							<td align="center">${workflow1.wCode}</td>						
							<td align="center">${workflow1.wFormat}</td>
							<td align="center">${workflow1.wTitle}</td>
							<td align="center">${workflow1.wInsertDate}</td>
							<td align="center">${workflow1.wFirstokDate}</td>
						</tr>					
					</c:forEach>			
				</tbody>
			</table>

				
			</div>
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