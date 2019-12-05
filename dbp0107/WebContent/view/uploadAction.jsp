<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.io.File" %>
<%@ page import="model.dao.CertificationDAO" %>

<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>



<!DOCTYPE html>
<html>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<style>
   td.hell {
   text-decoration: none;
   color: white;
   width: 350px;
   font-size: 15px;
   font-weight: bold;
   }
</style>
 -->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title> uploadAction </title>
</head>



<body>

<%
	String directory = application.getRealPath("/upload/");
	int maxSize = 1024 * 1024 * 100;
	String encoding = "UTF-8";
	
	MultipartRequest multipartRequest
		= new MultipartRequest(request, directory, maxSize, encoding,
				new DefaultFileRenamePolicy());
	
	String fileName = multipartRequest.getOriginalFileName("file");
	String fileRealName = multipartRequest.getFilesystemName("file");
	
	
	
	//new CertificationDAO().upload(fileName, fileRealName);
	
	out.write("파일명 : " + fileName + "<br");
	out.write("파일명 : " + fileName + "<br");

%>

</body>
</html>