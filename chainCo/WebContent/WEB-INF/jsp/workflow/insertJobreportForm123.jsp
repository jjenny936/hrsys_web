<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>�����ۼ��ϱ� - ���Ͼ�������</title>
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
					$("#insertForm").attr("action","/workflow/saveDoc.do");
					$("#insertForm").submit();
				});
				$("#submitDoc").click(function() {
					$("#insertForm").attr("action","/workflow/submitDoc.do");
					$("#insertForm").submit();
				});		
				$("#goback").click(function() {
					$("#insertForm").attr("action","/chainCo/workflow/submitbox.do");
					$("#insertForm").submit();
				});	
			});
			

		</script>
	</head>
	<body>
	<br>
		<header>
			<div id="header" align="center">
				<h1>&diams;&nbsp;&nbsp;���� ���� ����&nbsp;&nbsp;&diams;</h1>
			</div>
		</header>
	<br>	
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
		<!--�μ����(ȫ����, ������, ����������, �������ߺ�, �λ��, �繫��)�� ��ü��� ������ -->
			<div id="aside">			
				<div class="container">
  					<div class="row">
    					<h1>���� �����ϱ�</h1>
  					</div>
				</div>	
				<br><br>			
				<div class="well no-padding">
					<div>
    					<ul class="nav nav-list nav-menu-list-style">
        					<li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
        							<span class="glyphicon glyphicon-folder-close m5"></span>
        							 &loz;���繮����
                     				<span class="menu-collapsible-icon glyphicon glyphicon-chevron-down"></span>
                     			</label>
               					<ul class="nav nav-list tree bullets">
	                   			 	<li><a href="/chainCo/workflow/submitBox.do"><button class="sideButt">&raquo;&nbsp;�����</button></a></li>
	                   				<li><a href="/chainCo/workflow/approvalBox.do"><button class="sideButt">&raquo;&nbsp;������</button></a></li> 
	                   				<li><a href="/chainCo/workflow/denyBox.do"><button class="sideButt">&raquo;&nbsp;�ݷ���</button></a></li>
	                   				<li><a href="/chainCo/workflow/receptionBox.do"><button class="sideButt">&raquo;&nbsp;������</button></a></li> 
	                   				<li><a href="/chainCo/workflow/approvalHistory.do"><button class="sideButt">&raquo;&nbsp;����ó������</button></a></li> 
	                   				<li><a href="#"><button class="sideButt">&raquo;&nbsp;����������</button></a></li>                        
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
			<div id="mainContent" name="mainContent">
			<form id="insertForm" name="insertForm" method="POST">				 				 
				<p /><p /><p />
				<table id="table1" border="1">
					<tbody>
					<tr>
					<td colspan="3" rowspan="2" width="385">
					<p><strong>���Ͼ�������</strong></p>
					</td>
					<td rowspan="2" width="38">
					<p>��</p>
					<p>&nbsp;</p>
					<p>��</p>
					</td>
					<td width="113">
					<p>�� ��</p>
					</td>
					<td width="123">
					<p>�� ��</p>
					</td>
					</tr>
					<tr>
					<td width="113">
					<p>&nbsp;</p>
					</td>
					<td width="123">
					<p>&nbsp;</p>
					</td>
					</tr>
					<tr>
					<td width="92">
					<p>�ҼӺμ�</p>
					</td>
					<td width="236">
					<p>&nbsp;${login.ePos}</p>
					</td>
					<td colspan="2" width="94">
					<p>����</p>
					</td>
					<td colspan="2" width="236">
					<p>&nbsp;${login.eDept}</p>
					</td>
					</tr>
					<tr>
					<td width="92">
					<p>����</p>
					</td>
					<td width="236">
					<p>&nbsp;</p>
					</td>
					<td colspan="2" width="94">
					<p>����</p>
					</td>
					<td colspan="2" width="236">
					<p>&nbsp;</p>
					</td>
					</tr>
					<tr>
					<td colspan="6" width="659">
					<p><strong>���Ͻǽû���</strong></p>
					</td>
					</tr>
					<tr>
					<td colspan="2" width="328">
					<p>�� ��</p>
					</td>
					<td colspan="4" width="331">
					<p>�� ��</p>
					</td>
					</tr>
					<tr>
					<td colspan="2" width="328">
					<p>&nbsp;<input type="text" id="wWtodayDone1" name="wWtodayDone1"></p>
					</td>
					<td colspan="4" width="331">
					<p>&nbsp;<input type="text" id="wWtodayDone2" name="wWtodayDone2"></p>
					</td>
					</tr>
					<tr>
					<td width="92">
					<p>����</p>
					<p>��������</p>
					</td>
					<td colspan="5" width="567">
					<p>&nbsp;<input type="text" id="wWnextdayDo" name="wWnextdayDo"></p>
					</td>
					</tr>
					<tr>
					<td width="92">
					<p>���û���</p>
					</td>
					<td colspan="5" width="567">
					<p>&nbsp;<input type="text" id="wWinstruction" name="wWinstruction"></p>
					</td>
					</tr>
					</tbody>
				</table>
			</form>
				<input type="button" id="submitDoc" name="submitDoc" value="������">
				<input type="button" id="save" name="save" value="�ӽ�����">
				<a href="#"><button id="goback" name="goback">�ڷ� ����</button></a>
			</div>
			</center>
			</div>
		</section>
	</body>
</html>




















