<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/view/department/main.jsp"%>  
<%
	MessengerBoard board = (MessengerBoard)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> 메신저 연결 신청 </title>
<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">

</head>
<body>
<table align = "center" style="width:30%" class="list">
<tr>
		<td width = "150" align = "center" height = "40">번호</td>
		<td width = "400" align = "center" heigth = "40">${board.messenger_connect_board_no}</td>
	</tr>
	<tr>
		<td width = "150" align = "center" height = "40">제목</td>
		<td width = "400" align = "center" heigth = "40">${board.title}</td>
	</tr>
	<tr>
		<td width = "150" align = "center" height = "40">작성일</td>
		<td width = "400" align = "center" heigth = "40">${board.createtime}</td>
	</tr>
	<tr>
		<td width = "150" align = "center" height = "150">작성자</td>
		<td width = "400" align = "center" height = "150">${board.customer_name}</td>
	</tr>
	<tr>
		<td width = "150" align = "center" height = "150">내용</td>
		<td width = "400" align = "center" height = "150">${board.contents}</td>
	</tr>
	
</table>

<!--  ********신청 url 변경해야함!!!!!******** -->
<div style="text-align:center" class="list">
	    <a href="<c:url value='/view/testMain'> 
	     		   <c:param name='boardNo' value="${board.department_no}"/>
			 	 </c:url>">신청</a> &nbsp;
 	    
 	    <a href="<c:url value='/view/testMain' />">목록</a>
 </div> 	    
<br><br>
 	    

</body>
</html>