<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>  
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>    
<%@ page import="java.util.Enumeration" %>  
<%@ page import="java.io.File"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Vector" %>  
<%@ page import="java.util.Arrays" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
		<script type="text/javascript">
			function files(){
				document.sendingForm.action="/chainCo/emp/empUpdate.do";
				document.sendingForm.submit();
			}
		</script>
	</head>
	<body onload="files()">

	<%
		request.setCharacterEncoding("EUC-KR");
		
		String saveFolder="/img"; //파일이 저장될 폴더명
	    String savePath1=""; // 웹 어플리케이션의 절대 경로가 저장될 객체
	    ServletContext context = getServletContext();
	    savePath1 = context.getRealPath(saveFolder);
			
		int fileSize= 10*1024*1024; //approximately 10mb
		
		String eNo = "";
		String ePw = "";
		String eName = "";
		String eAddr = "";
		String eDept = "";
		String ePhone = "";
		String ePos = "";
		String eEmail = "";
		String eId = "";
		String ePhoto="";
		String eSignature="";
		String uploadFlag = "";
		
		try{ 
			  MultipartRequest mr =new MultipartRequest(request, savePath1, fileSize, "EUC-KR" ,new DefaultFileRenamePolicy());
			/*MultipartRequest class in com.oreilly.servlet.MultipartRequest package -> 
			A utility class to handle multipart/form-data requests, 
		  the kind of requests that support file uploads. 
			This class emulates the interface of HttpServletRequest, making it familiar to use. 
			It uses a "push" model where any incoming files are read and saved directly to disk in the constructor. */eNo = mr.getParameter("eNo");
			ePw = mr.getParameter("ePw");
			eName = mr.getParameter("eName");
			eAddr = mr.getParameter("eAddr");
			ePos = mr.getParameter("ePos");
			eDept = mr.getParameter("eDept");
			ePhone = mr.getParameter("ePhone");
			eEmail = mr.getParameter("eEmail");
			eId = mr.getParameter("eId");
			eDept = mr.getParameter("eDept");
			uploadFlag = mr.getParameter("uploadFlag");
			
			System.out.println("uploadFlag >> " + uploadFlag);
			
			Enumeration e = mr.getFileNames();
			/*getFileNames() in MultiRequest class->
           Returns the names of all the uploaded files as an Enumeration of Strings.*/
           
			if(uploadFlag.equals("bothUploaded")){
				Vector vec = new Vector();
				while(e.hasMoreElements()) 
				{ 
				String name = (String)e.nextElement();
				vec.add(name);
				}

				String[] formName= new String[vec.size()];
				vec.copyInto(formName);
				Arrays.sort(formName);
				
				ePhoto = mr.getFilesystemName(formName[0]);
				eSignature = mr.getFilesystemName(formName[1]);
				/*
				String photoFile = (String)e.nextElement();
				ePhoto = mr.getFilesystemName(photoFile);
				
				String signatureFile = (String)e.nextElement();
				eSignature = mr.getFilesystemName(signatureFile);*/
				
				System.out.println("ePhoto >> " + ePhoto);
				System.out.println("eSignature >> " + eSignature);
		   }
			
           if(uploadFlag.equals("photoUploaded")){//사진만 업로드
        	   eSignature = mr.getParameter("eSignature");
        	   String photoFile = (String)e.nextElement();
			   ePhoto = mr.getFilesystemName(photoFile);
			   
			   System.out.println("ePhoto >> " + ePhoto);
			   System.out.println("eSignature >> " + eSignature);
           }
           
           if(uploadFlag.equals("signatureUploaded")){//사인만 업로드
        	   ePhoto = mr.getParameter("ePhoto");
        	   String signatureFile = (String)e.nextElement();
			   eSignature = mr.getFilesystemName(signatureFile);
			   
			   System.out.println("ePhoto >> " + ePhoto);
			   System.out.println("eSignature >> " + eSignature);
           }
			
		}catch(Exception e){
			e.printStackTrace();
		}
		%>
		<form name="sendingForm" method="POST">
			<input type="hidden" name="eDept" value="<%=eDept%>" />
			<input type="hidden" name="eNo" value="<%=eNo%>" />
			<input type="hidden" name=ePw value="<%=ePw%>" />
			<input type="hidden" name="eName" value="<%=eName%>" />
			<input type="hidden" name="ePos" value="<%=ePos%>" />
			<input type="hidden" name="eAddr" value="<%=eAddr%>" />
			<input type="hidden" name="ePhone" value="<%=ePhone%>" />
			<input type="hidden" name="eEmail" value="<%=eEmail%>" />
			<input type="hidden" name="eId" value="<%=eId%>" />
			<input type="hidden" name="ePhoto" value="<%=ePhoto%>" />
			<input type="hidden" name="eSignature" value="<%=eSignature%>" />
		</form>
	</body>
</html>