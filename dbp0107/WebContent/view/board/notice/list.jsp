<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@include file = "/view/department/main.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Notice Board</title>
</head>
<body link="black" vlink="black" alink="black">
<table align = "center" width = "70%" class="list">
	<tr>
		<td width = "100" align = "center" height = "22">번호</td>
		<td width = "400" align = "center" height = "22">제목</td>
		<td width = "200" align = "center" height = "22">작성일</td>
		<td width = "200" align = "center" height = "22">작성자</td>
	</tr>
	<c:forEach var="board" items="${boardList}">
		<tr>
			<td width = "100" align = "center" height = "22">${board.notice_board_no}</td>
			<td width = "400" align = "center" height = "22">
				<a class = "list" href="<c:url value='/view/board/notice/detail'>
						   <c:param name="notice_board_no" value='${board.notice_board_no}'/>
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









































<%-- 
<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   @SuppressWarnings("unchecked") 
   List<Community> commList = (List<Community>)request.getAttribute("commList");
%>
<html>
<head>
<title>notice board  리스트</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/club.css' />" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table style="width:100%">
   <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
   <tr>
      <td width="20"></td>
      <td>
         <table>
            <tr>
               <td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;><b>동아리 리스트</b></td>
            </tr>
         </table>
         <br>
         <table style="background-color: #E5DFD2">
            <tr>
               <td width="200" align="center" bgcolor="C9BDA2">번호</td>
               <td width="200" align="center" bgcolor="C9BDA2">동아리명</td>
               <td width="200" align="center" bgcolor="C9BDA2">학과명</td>
            </tr>
            <c:forEach var="board" items="${boardList}">
               <tr>            <!-- 동아리명 클릭시 /club/detail로 넘어감 -->
                  <td width="200" bgcolor="FFFFFF" style="padding-left: 10" height="20">
                       ${club.club_no}
                  </td>
                  <td width="300" bgcolor="FFFFFF" style="padding-left: 10">
                     <a href="<c:url value='/club/detail'>
                             <c:param name='club_no' value='${club.club_no}'/>
                             </c:url>">
                       ${club.club_name}</a>
                  </td>
                  <td width="20" align="center" bgcolor="FFFFFF">
                     ${club.dept_name}
                  </td>
               </tr>   
            </c:forEach>
         </table>
          <br>   
          <a href="<c:url value='' />">커뮤니티 추가</a> 
      </td>
   </tr>

</table>
</body>
</html> --%>