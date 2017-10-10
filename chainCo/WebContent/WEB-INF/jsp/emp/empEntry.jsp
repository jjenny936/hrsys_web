<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page import="coffee.chain.emp.vo.EmpVO" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>사원정보 페이지 입니다.</title>
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
		<script>
			$(document).ready(function(){				
				$('.tree-toggle').click(function(){
					$(this).parent().children('ul.tree').toggle(200);
				});
				
				$(function(){
					$('.tree-toggle').parent().children('ul.tree').toggle(200);
				});	
				
				$("#marketing").click(function(){
					//location.href="../emp/empList.do";
					$("#eDept").val("홍보부");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#sales").click(function(){
					$("#eDept").val("영업부");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#human").click(function(){
					$("#eDept").val("인사부");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#finance").click(function(){
					$("#eDept").val("재무부");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#reaserch").click(function(){
					$("#eDept").val("연구개발부");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#branchMgt").click(function(){
					$("#eDept").val("점포관리부");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#myPage").click(function(){
					window.open("", "pop", "width=800, height=800, left=500px, top=100px");
					$("#entryForm").attr("action", "/chainCo/emp/empMyPage.do");
					$("#entryForm").attr("target", "pop");
					$("#entryForm").submit();
				});
				
			});
		</script>
	</head>
	<body>
	<%
	String sessionEno = (String)session.getAttribute("eNo");
	String sessionEpos = (String)session.getAttribute("ePos");
	String sessionEdept = (String)session.getAttribute("eDept");
	%>
	<form name="entryForm" id="entryForm" method="POST">
		<input type="hidden" name="sessionEdept" id="sessionEdept" value="<%=sessionEdept%>"/>
		<input type="hidden" name="eNo" id="eNo" value="<%=sessionEno%>"/>
		<input type="hidden" name="sessionEpos" id="sessionEpos" value="<%=sessionEpos%>"/>
		<input type="hidden" name="eDept" id="eDept" />
	</form>
		<header>
			<div id="header" align="center">
				<p id="main">&diams;&nbsp;&nbsp;MOONBUCKS COFFEE INC.&nbsp;&nbsp;&diams;</p>
			</div>
		</header>	
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
	                   				<li><button class="sideButt" id="research">&raquo;&nbsp;연구개발부 </button></li>                       
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
			<%
			EmpVO ev = (EmpVO)request.getAttribute("empEntry");
			%>
			<center>
				<h2><strong>&spades; 사장 인사말 &spades;</strong></h2>	
				<table>
				<tr><td align="center"><img src="<%=ev.getePhoto()%>" alt="photo" /></td>
				</tr><tr><td><p>직원 여러분 안녕하십니까. 문벅스 대표 나현수 입니다. <br>
			         무더웠던 여름이 지나 가을 바람이 살며시 고개를 내미는 요즈음, 언제나 처럼 우리 회사에 열정을 다하여 주시는 여러분께 항상 감사할다름입니다.<br><br>
				
				헨리 포드 포드자동차 창업회장은 어떤 결과에 대한 이윤에 대해 이렇게 이야기한 바가 있는데요,<br>
				"이윤이 없으면 비지니스를 확장하는 것은 불가능하다.<br>
				 이윤을 내는 것이 본래부터 잘못된 것은 절대 아니다.<br>
				 제대로 관리되는 기업이라면 이윤을 낼 수 밖에 없다.<br>
				 하지만 이윤이라는 것은 반드시 훌륭한 서비스에 대한 보상으로 주어져야 한다.<br>
				 이윤이 기초가 될 수는 없다.<br>
				 그것은 서비스의 결과가 되어야만 한다."<br><br>
				
				자고로 돈을 향한 경영은 성공하기 어렵고 사람을 향해야 원하는 목표에 다다를 수 있습니다.<br>
				고객만족을 위하여 뛰다 보면 이윤은 저절로 따라오게 되어 있습니다.<br>
				이미 레드오션을 이룬 커피전문점 업계에서 아직 스타트업 단계인 우리회사의 순조로운 성장을 위해서는 저를 비롯한 우리 모두의 노력이 필요할 것입니다.<br>
				단순이 음료만이 아닌, 고객에게 특별한 순간, 경험을 선사하는 것이 우리의 소명임을 압니다.<br>
				단순히 이윤을 이루기 위함이 아닌 서비스의 결과에 따라 부차적으로 얻어지는 것임을 안다면 우리의 목표를 어디로 두어야 하는지 자명해집니다.<br>
				성공적인 올한해 마무리를 기원하며 지금껏 해온 것 처럼 앞으로도 힘차게 나아갑시다.<br>
				감사합니다.
				</p></td></tr>
				</table>
				<br><br>
				</center>
				<h5 align="right">사장 프로필</h5>
				<table align="right">
					<tr align="left">
						<td>사원번호: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.geteNo()%></td>
					</tr>
					<tr align="left">
						<td>성명: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.geteName()%></td>
					</tr>
					<tr align="left">
						<td>아이디: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.geteId()%></td>
					</tr>
					<tr align="left">
						<td>이메일주소: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.geteEmail()%></td>
					</tr>
					<tr align="left">
						<td>전화번호: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.getePhone()%></td>
					</tr>
					<tr align="left">
						<td>집주소: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.geteAddr()%></td>
					</tr>
				</table>
				<br><br><br>
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