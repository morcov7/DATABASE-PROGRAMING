<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<nav>
		
	<ul align="center">

		<li>
			<a href="<c:url value='view/board/notice/list' />" class="list">공지사항 </a>
			<%-- <a href="<c:url value='/view/board/noticeBoard/list' />" class="list">공지사항 </a> --%>
		</li>
		<li>
			<a href="<c:url value='view/board/freshmanot/list' />" class="list">새내기 배움터 신청  </a>
		</li>
		<li>
			<a href="<c:url value='view/board/messenger/list' />" class="list">메신저 연결 신청 </a>
		</li>
		<%-- <c:if test="${empty sessionScope.user}">
				<li><a href=" <c:url value='/view/user/login/form' />" class="list">login</a></li></c:if>
			<c:if test="${!empty sessionScope.user}"><li>
			<a href="<c:url value='/user/logout' />" class = "list" class="list">logout(&nbsp;${sessionScope.user}&nbsp;)</a></li></c:if>
			<li><a href="<c:url value='/view/user/myPage' />" class="list">myPage</a></li> --%>
	</ul>
</nav>
</html>