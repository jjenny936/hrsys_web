<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
<%@ page import="java.util.ArrayList" %> 
<%@ page import="com.koitt.baby.vo.HrsysMemberVO" %>  
<%@ page import="org.apache.commons.codec.binary.Base64" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Login Jsp</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("EUC-KR");
		ArrayList aList = (ArrayList)request.getAttribute("loginResult");
		String mId = (String)request.getAttribute("loginId");
		String mPw = (String)request.getAttribute("loginPw");
		String s = new String(Base64.encodeBase64(mPw.getBytes()));
		int aSize = aList.size();
		if(aSize>0){
			//int aSize = aList.size();
			System.out.println("aSize >>" + aSize);
			HrsysMemberVO mv = null;
			for(int i = 0; i<aSize; i++){
			
				mv = (HrsysMemberVO)aList.get(i);
				
				String mid = mv.getmId();
				String mpw = mv.getmPw();
				String mname = mv.getmName();
				String maddr = mv.getmAddr();
				String mphone = mv.getmPhone();
				String memail = mv.getmEmail();
				String mno = mv.getmNo();	
				
				System.out.println("mpw >> " + mpw);
				System.out.println("s >> " + s);
				System.out.println("mno >> " + mno);
				
				if(mid.equals(mId) && mpw.equals(s)){
				
					session.setAttribute("mid", mid);
					session.setAttribute("mno", mno);
					/*session.setAttribute("mpw", mpw);
					session.setAttribute("mname", mname);
					session.setAttribute("maddr", maddr);
					session.setAttribute("mphone", mphone);
					session.setAttribute("memail", memail);
					session.setAttribute("mno", mno);*/
					
					%>						
					<script>
						alert("로그인 성공!");
						location.href = "/hrsys_web/html/MainScr.html";
					</script>
					<%
				}else{
					%>
					<script>
						alert("정보가 일치하지 않습니다. 다시 시도해주세요.");
						history.go(-1);
					</script>
					<%
				}
			}
		}else{
			%>
			<script>
				alert("정보가 일치하지 않습니다. 다시 시도해주세요.");
				history.go(-1);
			</script>
			<%
		}
		%>
	</body>
</html>