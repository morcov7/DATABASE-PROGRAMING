<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> Main </title>
</head>
<body link="black" vlink="black" alink="black">
<table align = "center" width = "70%" class="list">
	<tr>
		<td width = "100" align = "center" height = "22">학과</td>

	</tr>
	<c:forEach var="department" items="${departList}">
		<tr>
			<%-- <td width = "100" align = "center" height = "22">${department.department_no}</td>
			<td width = "400" align = "center" height = "22">
				<a href="<c:url value='/view/board/notice/list'>
						   <c:param name="department_no" value='${department.department_no}'/>
				 		 </c:url>">
				${department.dept_name}</a>
			</td> --%>
			
			<%-- <td width = "400" align = "center" height = "22">
				<a href="<c:url value='/view/board/messenger/list'>
						   <c:param name="department_no" value='${department.department_no}'/>
				 		 </c:url>">
				${department.dept_name}</a>
			</td> --%>
			
			
			<td width = "400" align = "center" height = "22">
				<a href="<c:url value='/view/board/freshmanot/list'>
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