<!-- 신청한 학과별 메신저 연결 페이지 (주소 출력) -->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="model.MessengerBoard" %>
<%@include file = "/main_banner.jsp"%> 
<%@include file = "/view/department/main.jsp"%>

<%
	MessengerBoard board = (MessengerBoard)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>메신저 연결 주소 확인</title>
<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">
</head>
<body>
<table align = "center" style="width:30%" class="list">
	<tr>
		<td width = "150" align = "center" height = "40">제목</td>
		<td width = "400" align = "center" heigth = "40">${board.title}</td>
	</tr>
	<tr>
		<td width = "150" align = "center" height = "150">주소</td>
		<td width = "400" align = "center" height = "150"><a href="${board.url}">${board.url}</a></td>
	</tr>
	
</table>
	
</body>
</html>