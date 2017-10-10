<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page import="coffee.chain.emp.vo.EmpVO" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>������� ������ �Դϴ�.</title>
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
					$("#eDept").val("ȫ����");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#sales").click(function(){
					$("#eDept").val("������");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#human").click(function(){
					$("#eDept").val("�λ��");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#finance").click(function(){
					$("#eDept").val("�繫��");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#reaserch").click(function(){
					$("#eDept").val("�������ߺ�");
					$("#entryForm").attr("action", "/chainCo/emp/empList.do");
					$("#entryForm").submit();
					$(this).css("font-weight", "bold");
				});
				
				$("#branchMgt").click(function(){
					$("#eDept").val("����������");
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
				<li><a href="/chainCo/main.jsp">Ȩ</a></li>
				<li><a href="#">�⼮üũ</a></li>
				<li><a href="/chainCo/workflow/mainScreen.do">���ڰ���</a></li>
				<li><a href="/chainCo/emp/empEntry.do">�������</a></li>
				<li><a href="/chainCo/branch/branchEntry.do">��������</a></li>
				<li><a href="#">�Խ���</a></li>
				<li><a href="/chainCo/logout.jsp">�α׾ƿ�</a></li>
			</ul>
		</nav>
		
		<aside>
			<div id="aside">			
				<div class="container">
  					<div class="row">
    					<h1>������� �����ϱ�</h1>
  					</div>
				</div>	
				<br><br>			
				<div class="well no-padding">
					<div>
    					<ul class="nav nav-list nav-menu-list-style">
        					<li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
        							 &loz;&nbsp;�μ����
                     			</label>
               					<ul class="nav nav-list tree bullets">
	                   			 	<li><button class="sideButt" id="marketing">&raquo;&nbsp;ȫ����</button></li>
	                   				<li><button class="sideButt" id="sales">&raquo;&nbsp;������ </button></li>
	                   				<li><button class="sideButt" id="human">&raquo;&nbsp;�λ��</button></li>
	                   				<li><button class="sideButt" id="finance">&raquo;&nbsp;�繫�� </button></li>
	                   				<li><button class="sideButt" id="branchMgt">&raquo;&nbsp;����������</button></li>
	                   				<li><button class="sideButt" id="research">&raquo;&nbsp;�������ߺ� </button></li>                       
                            	</ul>
                            </li>
                            <br><br>
                            <li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
    							 	&loz;&nbsp;�� ���� ����
                     			</label>
                     			<ul class="nav nav-list tree bullets">
	                   			 	<li><button class="sideButt" id="myPage">&raquo;&nbsp;�� ���� �����ϱ�</button></li>                       
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
				<h2><strong>&spades; ���� �λ縻 &spades;</strong></h2>	
				<table>
				<tr><td align="center"><img src="<%=ev.getePhoto()%>" alt="photo" /></td>
				</tr><tr><td><p>���� ������ �ȳ��Ͻʴϱ�. ������ ��ǥ ������ �Դϴ�. <br>
			         �������� ������ ���� ���� �ٶ��� ���� ���� ���̴� ������, ������ ó�� �츮 ȸ�翡 ������ ���Ͽ� �ֽô� �����в� �׻� �����Ҵٸ��Դϴ�.<br><br>
				
				� ���� �����ڵ��� â��ȸ���� � ����� ���� ������ ���� �̷��� �̾߱��� �ٰ� �ִµ���,<br>
				"������ ������ �����Ͻ��� Ȯ���ϴ� ���� �Ұ����ϴ�.<br>
				 ������ ���� ���� �������� �߸��� ���� ���� �ƴϴ�.<br>
				 ����� �����Ǵ� ����̶�� ������ �� �� �ۿ� ����.<br>
				 ������ �����̶�� ���� �ݵ�� �Ǹ��� ���񽺿� ���� �������� �־����� �Ѵ�.<br>
				 ������ ���ʰ� �� ���� ����.<br>
				 �װ��� ������ ����� �Ǿ�߸� �Ѵ�."<br><br>
				
				�ڰ�� ���� ���� �濵�� �����ϱ� ��ư� ����� ���ؾ� ���ϴ� ��ǥ�� �ٴٸ� �� �ֽ��ϴ�.<br>
				�������� ���Ͽ� �ٴ� ���� ������ ������ ������� �Ǿ� �ֽ��ϴ�.<br>
				�̹� ��������� �̷� Ŀ�������� ���迡�� ���� ��ŸƮ�� �ܰ��� �츮ȸ���� �����ο� ������ ���ؼ��� ���� ����� �츮 ����� ����� �ʿ��� ���Դϴ�.<br>
				�ܼ��� ���Ḹ�� �ƴ�, ������ Ư���� ����, ������ �����ϴ� ���� �츮�� �Ҹ����� �дϴ�.<br>
				�ܼ��� ������ �̷�� ������ �ƴ� ������ ����� ���� ���������� ������� ������ �ȴٸ� �츮�� ��ǥ�� ���� �ξ�� �ϴ��� �ڸ������ϴ�.<br>
				�������� ������ �������� ����ϸ� ���ݲ� �ؿ� �� ó�� �����ε� ������ ���ư��ô�.<br>
				�����մϴ�.
				</p></td></tr>
				</table>
				<br><br>
				</center>
				<h5 align="right">���� ������</h5>
				<table align="right">
					<tr align="left">
						<td>�����ȣ: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.geteNo()%></td>
					</tr>
					<tr align="left">
						<td>����: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.geteName()%></td>
					</tr>
					<tr align="left">
						<td>���̵�: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.geteId()%></td>
					</tr>
					<tr align="left">
						<td>�̸����ּ�: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.geteEmail()%></td>
					</tr>
					<tr align="left">
						<td>��ȭ��ȣ: </td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><%=ev.getePhone()%></td>
					</tr>
					<tr align="left">
						<td>���ּ�: </td>
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
				<p id="us">������ ������ ������ </p>		
			</div>
		</footer>
	</body>
</html>