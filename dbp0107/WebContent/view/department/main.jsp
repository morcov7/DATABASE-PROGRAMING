<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet href="<c:url value='/css/customer.css' />"
	type="text/css">
<header align="center">
	<img alt=""
		src="<c:url value='/images/dongduk_logo.png' />" width="30%"
		height="30%">
</header>
</head>
<body>
<nav>
	
	<ul align="center">
		<li>
			<a href="<c:url value='/view/board/notice/list' >
						   <c:param name="department_no" value='${param.department_no}'/>
				 		 </c:url>" class="list">공지사항 </a>
		</li>
		<li>
			<a href="<c:url value='/view/board/freshmanot/list' >
							<c:param name="department_no" value='${param.department_no}'/>
				 		 </c:url>" class="list">새내기 배움터 신청  </a>
		</li>
		<li>
			<a href="<c:url value='/view/board/messenger/list' >
							<c:param name="department_no" value='${param.department_no}'/>
				 		 </c:url>" class="list">메신저 연결 신청 </a>
		</li>

	</ul>
</nav>
</body>
</html>