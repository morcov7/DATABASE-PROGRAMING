<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@include file = "/main_banner.jsp"%>  --%>
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
<title> Main </title>
</head>
<body link="black" vlink="black" alink="black">
<table class="table" align = "center" width = "70%" class="list">
   <tr>
      <td class="hell" width = "100" align = "center" height = "22" bgcolor="#a1304e">학과</td>

   </tr>
   <c:forEach var="department" items="${departList}">
      <tr>
         <td width = "400" align = "center" height = "22"  bgcolor="#F1E1E3">
            <a href="<c:url value='/view/board/notice/list'>
                     <c:param name="department_no" value='${department.department_no}'/>
                    </c:url>">
            ${department.dept_name}</a>
         </td>
         

      </tr>
   </c:forEach> 
</table>
<br>

</body>
</html>