<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="model.FreshmanOTBoard" %>
<%@include file = "/main_banner.jsp" %> 
<%@include file = "/view/department/main.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>새내기 배움터 신청</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body link="black" vlink="black" alink="black">

<table style="width:85%" class="table table-bordered" align = "center" width = "70%">
	<tr>
		<td width = "100" align = "center" height = "22" bgcolor="#F1E1E3">번호</td>
		<td width = "400" align = "center" height = "22" bgcolor="#F1E1E3">제목</td>
		<td width = "200" align = "center" height = "22" bgcolor="#F1E1E3">작성일</td>
		<td width = "200" align = "center" height = "22" bgcolor="#F1E1E3">작성자</td>
	</tr>
	<c:forEach var="board" items="${boardList}">
		<tr>
			<td width = "100" align = "center" height = "22">${board.freshmanOT_board_no}</td>
			
			<td width = "400" align = "center" height = "22">
				<a class = "list" href="<c:url value='/view/board/freshmanot/detail'>
						   <c:param name="freshmanOT_board_no" value='${board.freshmanOT_board_no}'/>
						   <c:param name="department_no" value='${board.department_no}'/>
				 		 </c:url>">
				${board.title}</a>
			</td>
			<td width = "200" align = "center" height = "22">${board.createtime}</td>
			<td width = "200" align = "center" height = "22">${board.customer_name}</td>
		</tr>
	</c:forEach> 
</table>
<br>

<div style="text-align:center" class="list">
	<a href="<c:url value='/view/testMain' />">목록</a>
</div>
</body>
</html>
