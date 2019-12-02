<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<style>
   td.hell {
   text-decoration: none;
   color: white;
   width: 350px;
   font-size: 15px;
   font-weight: bold;
   }
</style>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title> Certification file upload </title>
</head>



<body>

<form action="uploadAction.jsp" method="post" enctype="multipart/form-data">
    파일 :<input type="file" name="file"><br>
    <input type="submit" value="업로드"><br>
</form>

</body>
</html>