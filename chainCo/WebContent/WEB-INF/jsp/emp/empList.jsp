<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>사원정보 페이지 입니다.</title>
		<style type="text/css">
			@import url(//fonts.googleapis.com/earlyaccess/hanna.css);
			
			body, html {
			    height: 100%;
			    width: 100%;
			    margin: 20;
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
			}			body {
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
			
			.butts {
				display: none;
				cursor: pointer;
				background-color: black;
				border-radius: 11%;
				border: none;
				font-weight: bold;
				color: white;
			}
			
			.butts:hover {
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
				
				//login session 정보에 담겨있는 애들
				var sessionEdept = $("#sessionEdept").val();
				var sessionEpos = $("#sessionEpos").val();
				
				if(sessionEpos == '사장'){$('.butts').show();}
				if(sessionEdept == '인사부'){$('.butts').show();}
				
				$("#marketing").click(function(){
					$("#eDept").val("홍보부");
					$("#listForm").attr("action", "/chainCo/emp/empList.do");
					$("#listForm").submit();
					
				});
				
				$("#sales").click(function(){
					$("#eDept").val("영업부");
					$("#listForm").attr("action", "/chainCo/emp/empList.do");
					$("#listForm").submit();
					
				});
				
				$("#human").click(function(){
					$("#eDept").val("인사부");
					$("#listForm").attr("action", "/chainCo/emp/empList.do");
					$("#listForm").submit();
				});
				
				$("#finance").click(function(){
					$("#eDept").val("재무부");
					$("#listForm").attr("action", "/chainCo/emp/empList.do");
					$("#listForm").submit();
				});
				
				$("#branchMgt").click(function(){
					$("#eDept").val("점포관리부");
					$("#listForm").attr("action", "/chainCo/emp/empList.do");
					$("#listForm").submit();
				
				});
				
				$("#reaserch").click(function(){
					$("#eDept").val("연구개발부");
					$("#listForm").attr("action", "/chainCo/emp/empList.do");
					$("#listForm").submit();
				});
				
				$("#myPage").click(function(){
					var eno = $("#sessionEno").val()
					$("#eNo").val(eno);
					
					window.open("", "pop", "width=900, height=1000, left=500px, top=50px");
					$("#listForm").attr("action", "/chainCo/emp/empMyPage.do");
					$("#listForm").attr("target", "pop");
					$("#listForm").submit();
				});
				
				$("#organChart").click(function(){
					location.href="#";
				});
				
			});
			
			function deleteWork(index){
				var eno = "";
				var edept = "";
				$(".empTable").each(function(i){
					if(i == index){
						eno = $(this).find('#rowEno').map(function() {
					        return $(this).text();
						}).get();
						edept = $("#rowDept").text();
					}	
				});
				
				$("#eDept").val(edept);
				$("#eNo").val(eno);
				$("#listForm").attr("action", "/chainCo/emp/empDelete.do");
				$("#listForm").submit();
			}
			
			function updateWork(index){
				var sessionEpos = $("#sessionEpos").val();
				
				var eno = "";
				var edept = "";
				var eid = "";
				var eemail = "";
				var epos = "";
				var ephone = "";
				var eaddr = "";
				var ename = "";
				var einsertdate = "";
				var eupdatedate = "";
				var epw = "";
				var ephoto = "";
				var esignature = "";
				
				$(".empTable").each(function(i){
					if(i == index){
						eno = $(this).find('#rowEno').map(function() {
					        return $(this).text();
						}).get();
						eid = $(this).find('#rowId').map(function() {
					        return $(this).text();
						}).get();
						eemail = $(this).find('#rowEmail').map(function() {
					        return $(this).text();
						}).get();
						ephone = $(this).find('#rowPhone').map(function() {
					        return $(this).text();
						}).get();
						ename = $(this).find('#rowName').map(function() {
					        return $(this).text();
						}).get();
						einsertdate = $(this).find('#rowInsertDate').map(function() {
					        return $(this).text();
						}).get();
						epos = $(this).find('#rowPos').map(function() {
					        return $(this).text();
						}).get();
						eaddr = $(this).find('#rowAddr').map(function() {
					        return $(this).text();
						}).get();
						epw = $(this).find('#rowPw').map(function() {
					        return $(this).val();
						}).get();
						eupdatedate = $(this).find('#rowUpdateDate').map(function() {
					        return $(this).val();
						}).get();
						ephoto = $(this).find('#rowPhoto').map(function() {
					        return $(this).val();
						}).get();
						esignature = $(this).find('#rowSignature').map(function() {
					        return $(this).val();
						}).get();
						edept = $(this).find('#rowDept').map(function() {
					        return $(this).text();
						}).get();
					}	
				});
				
				$("#ePhoto").val(ephoto);
				$("#eSignature").val(esignature);
				$("#eDept").val(edept);
				$("#eNo").val(eno);
				$("#eAddr").val(eaddr);
				$("#ePos").val(epos);
				$("#ePw").val(epw);
				$("#eId").val(eid);
				$("#eName").val(ename);
				$("#eEmail").val(eemail);
				$("#ePhone").val(ephone);
				$("#eUpdateDate").val(eupdatedate);
				$("#eInsertDate").val(einsertdate);
	
				window.open("", "pop", "width=850, height=900, left=450px, top=70px");
				$("#listForm").attr("action", "/chainCo/empUpdate_1.jsp");
				$("#listForm").attr("target", "pop");
				$("#listForm").submit();
				
			}
			

		</script>
	</head>
	<body>
	<%
	String sessionEno = (String)session.getAttribute("eNo");
	String sessionEpos = (String)session.getAttribute("ePos");
	String sessionEdept = (String)session.getAttribute("eDept");
	%>
	<form name="listForm" id="listForm" method="POST">
		<input type="hidden" name="sessionEdept" id="sessionEdept" value="<%=sessionEdept%>"/>
		<input type="hidden" name="sessionEno" id="sessionEno" value="<%=sessionEno%>"/>
		<input type="hidden" name="sessionEpos" id="sessionEpos" value="<%=sessionEpos%>"/>
		<input type="hidden" name="eNo" id="eNo" />
		<input type="hidden" name="eDept" id="eDept" />
		<input type="hidden" name="eName" id="eName" />
		<input type="hidden" name="ePos" id="ePos" />
		<input type="hidden" name="ePhone" id="ePhone" />
		<input type="hidden" name="eAddr" id="eAddr" />
		<input type="hidden" name="eId" id="eId" />
		<input type="hidden" name="eInsertDate" id="eInsertDate" />
		<input type="hidden" name="eEmail" id="eEmail" />
		<input type="hidden" name="ePw" id="ePw" />
		<input type="hidden" name="eUpdateDate" id="eUpdateDate" />
		<input type="hidden" name="ePhoto" id="ePhoto" />
		<input type="hidden" name="eSignature" id="eSignature" />

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
    					<h1>사원정보 열람하기</h1>
  					</div>
				</div>	
				<br><br>			
				<div class="well no-padding">
					<div>
    					<ul class="nav nav-list nav-menu-list-style">
        					<li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
        							 &loz;&nbsp;부서목록
                     			</label>
               					<ul class="nav nav-list tree bullets">
	                   			 	<li><button class="sideButt" id="marketing">&raquo;&nbsp;홍보부</button></li>
	                   				<li><button class="sideButt" id="sales">&raquo;&nbsp;영업부 </button></li>
	                   				<li><button class="sideButt" id="human">&raquo;&nbsp;인사부</button></li>
	                   				<li><button class="sideButt" id="finance">&raquo;&nbsp;재무부 </button></li>
	                   				<li><button class="sideButt" id="branchMgt">&raquo;&nbsp;점포관리부</button></li>
	                   				<li><button class="sideButt" id="reaserch">&raquo;&nbsp;연구개발부 </button></li>                       
                            	</ul>
                            </li>
                            <br><br>                       
                            <li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
    							 	&loz;&nbsp;내 정보 열람
                     			</label>
                     			<ul class="nav nav-list tree bullets">
	                   			 	<li><button class="sideButt" id="myPage">&raquo;&nbsp;내 정보 수정하기</button></li>                       
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
				<c:if test="${empty empList}">
						<h1>해당 부서의 정보가 존재하지 않습니다.</h1>
				</c:if>
				<c:forEach items="${empList}" var="row" varStatus="loop">
					<table class="empTable" id="empTable">
						<input type="hidden" id="rowSignature" value="${row.eSignature}">
						<input type="hidden" id="rowPhoto" value="${row.ePhoto}">
						<input type="hidden" id="rowPw" value="${row.ePw}">
						<input type="hidden" id="rowUpdateDate" value="${row.eUpdateDate}">
						<tr>
							<td rowspan="10"><img src="${row.ePhoto}" alt="photo" height="333" width="250"/></td>
							<td>사원번호: </td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="rowEno">${row.eNo}</td>
						</tr>
						<tr>
							<td>소속부서: </td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="rowDept">${row.eDept}</td>
						</tr>
						<tr>
							<td>사원명: </td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="rowName">${row.eName}</td>
						</tr>
						<tr>
							<td>직책: </td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="rowPos">${row.ePos}</td>
						</tr>
						<tr>
						<tr>
							<td>아이디: </td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="rowId">${row.eId}</td>
						</tr>
							<td>이메일주소: </td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="rowEmail">${row.eEmail}</td>
						</tr>
						<tr>
							<td>전화번호: </td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="rowPhone">${row.ePhone}</td>
						</tr>
						<tr>
							<td>집주소: </td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="rowAddr">${row.eAddr}</td>
						</tr>
						<tr>
							<td>입사일: </td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="rowInsertDate">${row.eInsertDate}</td>
						</tr>
						<tr id="buttonTr">
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td></td>
							<td colspan="3" align="left"><input type="button" class="butts" id="updateButt" value="수정하기" onclick="updateWork(${loop.index})"/>&nbsp;&nbsp;<input type="button" class="butts" id="deleteButt" value="퇴사처리" onclick="deleteWork(${loop.index})"/></td>
						</tr>
					</table>
					<br><br>
				</c:forEach>
			</center>	
			</div>
		</section>
		
		<footer>
			<div id="footer">			
				<p id="copy">&copy; 2017, all rights reserved.</p>
				<p id="us">나현수 오근주 최재은 </p>		
			</div>
		</footer>
	</form>	
	</body>
</html>