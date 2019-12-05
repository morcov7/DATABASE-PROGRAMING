<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/main_banner.jsp" %> 
<%@include file = "/view/department/main.jsp"%>  
<%
	NoticeBoard board = (NoticeBoard)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> 공지사항 </title>
<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<!--  notice_board_no, title, contents, createtime, department_no, customer_name -->
<dl class="row" style="margin-left:10%" align = "center">
	  <dt class="col-sm-3">번호</dt>
	  <dd class="col-sm-9">${board.notice_board_no}</dd>
	
	  <dt class="col-sm-3">제목</dt>
	  <dd class="col-sm-9">${board.title}</dd>
	  	
	  <dt class="col-sm-3">작성일</dt>
	  <dd class="col-sm-9">${board.createtime}</dd>
	  	
	  <dt class="col-sm-3">작성자</dt>
	  <dd class="col-sm-9">${board.customer_name}</dd>
	  	  	
	  <dt class="col-sm-3">내용</dt>
	  <dd class="col-sm-9">${board.contents}</dd>
  </dl>
	
</table>
<div style="text-align:center" class="list">	
 	    
 	    <a href="<c:url value='/view/board/notice/list'> 
	     		   <c:param name='department_no' value="${board.department_no}"/>
			 	 </c:url>">목록</a> &nbsp;
			 	 
 </div> 	    
 	    <br><br>
 	    

</body>
</html>

