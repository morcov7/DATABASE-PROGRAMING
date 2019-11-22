<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- <script>
function boardRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
</script> -->
</head>
<body>
<!--  notice_board_no, title, contents, createtime, department_no, customer_name -->
<table align = "center" style="width:30%" class="list">
<tr>
		<td width = "150" align = "center" height = "40">번호</td>
		<td width = "400" align = "center" heigth = "40">${board.notice_board_no}</td>
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
<div style="text-align:center" class="list">
	   <%--  <a href="<c:url value='/view/board/update/form'>
	     		   <c:param name='boardNo' value="${board.boardno}"/>
	     		   <c:param name='userId' value='${board.id}' />
			 	 </c:url>">수정</a> &nbsp;
 	    <a href="<c:url value='/view/board/remove'>
				   <c:param name='boardNo' value='${board.boardno}'/>
				   <c:param name='userId' value='${board.id}' />
			 	 </c:url>" onclick="return boardRemove();">삭제</a> &nbsp;
		<a href="<c:url value='/view/board/answer/form'>
	     		   <c:param name='boardNo' value='${board.boardno}'/>
			 	 </c:url>">답변</a> &nbsp; --%>
			 	 
 	    <a href="<c:url value='/view/board/notice/list' />">목록</a>
 </div> 	    
 	    <br><br>
 	    

</body>





<%-- 
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
  <br>
  <table style="width:100%">
    <tr>
     <td width="20"></td>
     <td>
       <table>
        <tr>   <!-- String club_name, String dept_name, String title, String contents, Date createtime  -->
        
       <!--  notice_board_no, title, contents, createtime, department_no, customer_name -->
        
         <td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b> 공지사항 상세 정보 </b>&nbsp;&nbsp;</td>
        </tr>
       </table>  
       <br>            
        <table class="clubTable">
          <tr>
         <td class="clubHead">동아리명</td>
         <td class="clubCell">
            ${club.club_name}
         </td>
        </tr>
        <tr>
         <td class="clubHead">학과명</td>
         <td class="clubCell">
            ${club.dept_name}
         </td>
        </tr>
        <tr>
         <td class="clubHead">제목</td>
         <td class="clubCell">
            ${club.title}
         </td>
        </tr>   
        <tr>
         <td class="clubHead">내용</td>
         <td class="clubCell">
            ${club.contents}
         </td>
        </tr>             
        <tr>
         <td class="clubHead">개설일자</td>
         <td width="470" bgcolor="ffffff" style="padding-left: 10">
            ${club.createtime} 
         </td>
       </table>
       <br>
        <a href="<c:url value='/club/list' />">동아리 목록</a>
        <br>      
        
        <!-- 수정이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${updateFailed}">
         <font color="red"><c:out value="${exception.getMessage()}" /></font>
       </c:if>    
     </td>
   </tr>
  </table>  
</body> --%>

</html>







<%-- 



<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>NoticeBoard Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">
<style>
.commTable {
  color: blue;
  background: YellowGreen;
}
.commHead {
  width: 120px;
  height: 22px;
  text-align: center;
  background: "E6ECDE";  
}
.commCell {
  width: 470px;
  text-align: left;
  padding-left: 10px;
  background: "FFFFFF";  
}
</style>

</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
  <br>
  <table style="width:100%">
    <tr>
     <td width="20"></td>
     <td>
       <table>
        <tr>   <!-- String club_name, String dept_name, String title, String contents, Date createtime  -->
         <td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>동아리 상세 정보</b>&nbsp;&nbsp;</td>
        </tr>
       </table>  
       <br>            
        <table class="clubTable">
          <tr>
         <td class="clubHead">동아리명</td>
         <td class="clubCell">
            ${club.club_name}
         </td>
        </tr>
        <tr>
         <td class="clubHead">학과명</td>
         <td class="clubCell">
            ${club.dept_name}
         </td>
        </tr>
        <tr>
         <td class="clubHead">제목</td>
         <td class="clubCell">
            ${club.title}
         </td>
        </tr>   
        <tr>
         <td class="clubHead">내용</td>
         <td class="clubCell">
            ${club.contents}
         </td>
        </tr>             
        <tr>
         <td class="clubHead">개설일자</td>
         <td width="470" bgcolor="ffffff" style="padding-left: 10">
            ${club.createtime} 
         </td>
       </table>
       <br>
        <a href="<c:url value='/club/list' />">동아리 목록</a>
        <br>      
          
     </td>
   </tr>
  </table>  
</body>
</html> --%>