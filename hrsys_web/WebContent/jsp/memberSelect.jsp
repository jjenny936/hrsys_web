<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="com.koitt.baby.vo.HrsysMemberVO" %>  
<%@ page import="org.apache.commons.codec.binary.Base64" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Member Select Jsp</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		ArrayList a = (ArrayList)request.getAttribute("selectResult");
		int aSize = a.size();
		if(aSize>0){
			for(int i =0; i<aSize; i++){
				HrsysMemberVO mv = (HrsysMemberVO)a.get(i);
				String mno = mv.getmNo();
				String mid = mv.getmId();
				String mname = mv.getmName();
				String maddr = mv.getmAddr();
				String memail = mv.getmEmail();
				String mphone = mv.getmPhone();
				String mpw = new String(Base64.decodeBase64(mv.getmPw().getBytes()));
				
				session.setAttribute("mno", mno);
				session.setAttribute("mid", mid);
				session.setAttribute("mpw", mpw);
				session.setAttribute("mname", mname);
				session.setAttribute("maddr", maddr);
				session.setAttribute("memail", memail);
				session.setAttribute("mphone", mphone);
				
			}
			%>
			<script>
			location.href = "/hrsys_web/jsp/myPage.jsp";
			</script>
			<%
		}else{
			System.out.println("aSize가 0보다 작음");
		}
		%>
	</body>
</html>