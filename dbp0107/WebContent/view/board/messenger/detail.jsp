<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/main_banner.jsp" %> 
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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
  <dl class="row" style="margin-left:30%" align = "center">
	  <dt class="col-sm-2">번호</dt>
	  <dd class="col-sm-10">${board.messenger_connect_board_no}</dd>
	
	  <dt class="col-sm-2">제목</dt>
	  <dd class="col-sm-10">${board.title}</dd>
	  	
	  <dt class="col-sm-2">작성일</dt>
	  <dd class="col-sm-10">${board.createtime}</dd>
	  	
	  <dt class="col-sm-2">작성자</dt>
	  <dd class="col-sm-10">${board.customer_name}</dd>
	  	  	
	  <dt class="col-sm-2">내용</dt>
	  <dd class="col-sm-10">${board.contents}</dd>
  </dl>

<!--  ********신청 url 변경해야함!!!!!******** -->
<div style="text-align:center" class="list">
	    <a href="<c:url value='/view/board/messenger/connect'>
	    		   <c:param name="messenger_connect_board_no" value='${board.messenger_connect_board_no}'/>
		 		   <c:param name='department_no' value="${board.department_no}"/>
			 	 </c:url>">연결</a> &nbsp;

 	     <a href="<c:url value='/view/board/messenger/list'> 
	     		   <c:param name='department_no' value="${board.department_no}"/>
			 	 </c:url>">목록</a> &nbsp;
 </div> 	
<br><br>
 	    

</body>
</html>