<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page import="coffee.chain.emp.vo.EmpVO" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>�������� ������ �Դϴ�.</title>
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
					
					if(sessionEdept == '����������' || sessionEpos == '����'){
						window.open("", "pop", "width=600, height=600, left=600px, top=200px");
						$("#branchEntry").attr("action", "/chainCo/branch/list.do");
						$("#branchEntry").attr("target", "pop");
						$("#branchEntry").submit();
					}else{
						alert("���ϴ� ���������� ������ ������ �����ϴ�.");
					}
				});	
				
				$("#delete").click(function(){
					$("#choiceFlag").val("delete");
					var sessionEdept = $("#sessionEdept").val();
					var sessionEpos = $("#sessionEpos").val();
					
					if(sessionEdept == '����������' || sessionEpos == '����'){
						$("#branchEntry").attr("action", "/chainCo/branch/branchDelete.do");
						$("#branchEntry").submit();
					}else{
						alert("���ϴ� ���������� ������ �����ϴ�.");
					}
				});	
				
				$("#sales").click(function(){
					$("#branchEntry").attr("action", "/chainCo/branch/sales.do");
					$("#branchEntry").submit();
				});				
			});
			
			function branches(branch){
				$("#bName").val(branch);
				
				$("#branchEntry").attr("action", "/chainCo/branch/branchList.do");
				$("#branchEntry").submit();
			}	
		</script>
	    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
	    <script type="text/javascript">
	    
	      // Load the Visualization API and the piechart package.
	      google.load('visualization', '1.0', {'packages':['corechart']});
	      
	      // Set a callback to run when the Google Visualization API is loaded.
	      google.setOnLoadCallback(drawChart);
	
	      // Callback that creates and populates a data table, 
	      // instantiates the pie chart, passes in the data and
	      // draws it.
	      function drawChart() {
				
	      var first = $("#first").val();
	      first = Number(first);
	      var second = $("#second").val();
	      second = Number(second);
	      var third = $("#third").val();
	      third = Number(third);
	      var fourth = $("#fourth").val();
	      fourth = Number(fourth);
	      // Create the data table.
	      var data = new google.visualization.DataTable();
	
	      data.addColumn('string', 'Period');
	      data.addColumn('number', 'Sales');
	      data.addRows([
	        ['1�б�', first],
	        ['2�б�', second],
	        ['3�б�', third], 
	        ['4�б�', fourth]
	      ]);
	
	      // Set chart options
	      var options = {'width':800,
	                     'height':700};
	
	      // Instantiate and draw our chart, passing in some options.
	      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
	      chart.draw(data, options);
	    }
	    </script>
	</head>
	<body>
	<%
	String sessionEno = (String)session.getAttribute("eNo");
	String sessionEpos = (String)session.getAttribute("ePos");
	String sessionEdept = (String)session.getAttribute("eDept");
	%>
	<form name="branchEntry" id="branchEntry" method="POST">
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
    					<h1>�������� �����ϱ�</h1>
  					</div>
				</div>	
				<br><br>			
				<div class="well no-padding">
					<div>
    					<ul class="nav nav-list nav-menu-list-style">
        					<li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
        							 &loz;&nbsp;������ �⺻����
                     			</label>
               					<ul class="nav nav-list tree bullets">
	                   			 	<li><button class="sideButt" id="gasan" onclick="branches('������')">&raquo;&nbsp;������</button></li>
	                   				<li><button class="sideButt" id="gangnam" onclick="branches('������')">&raquo;&nbsp;������</button></li>                    
                            	</ul>
                            </li>
                            <br>
                            <li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
    							 	&loz;&nbsp;������ ����
                     			</label>
                     			<ul class="nav nav-list tree bullets">
	                   			 	<li><button class="sideButt" id="sales">&raquo;&nbsp;���⺸��</button></li>                       
                            	</ul>
                            </li>
                            <br>
                            <li>
        						<label class="tree-toggle nav-header glyphicon-icon-rpad">
    							 	&loz;&nbsp;��������
                     			</label>
                     			<ul class="nav nav-list tree bullets">
	                   			 	<li><button class="sideButt" id="update">&raquo;&nbsp;���� �����ϱ�</button></li> 
	                   			 	<li><button class="sideButt" id="delete">&raquo;&nbsp;��������</button></li>                      
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
				<c:if test="${not empty branchEntry}">
					<h2>&spades;�� ������Ȳ&spades;</h2>
					<br>
					<table border="1" style="padding: 10px;">
					<c:forEach items="${branchEntry}" var="row">
						<input type="hidden" id="first" value="${row.sFirstQ}" />
						<input type="hidden" id="second" value="${row.sSecondQ}" />
						<input type="hidden" id="third" value="${row.sThirdQ}" />
						<input type="hidden" id="fourth" value="${row.sFourthQ}" />
						<tr><td colspan="2" align="center" style="font-weight:bold;">${row.sYear}��</td></tr>
						<tr><td>&bull;����������Ʈ����: </td><td>${row.sUpdateDate}</td></tr>
						<tr><td>&bull;�� ������:&nbsp;&nbsp;</td><td>${row.bNo}(����)</td></tr>
					</c:forEach>
					</table>
					<br><br>
					<table border="1">
						<tr><td align="center">&bull;�Ѹ���&bull;  *����: ��ȭ(\)</td></tr>
						<tr><td><div id="chart_div"></div></td></tr>
					</table>	
				</c:if>
			</center>	
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
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							