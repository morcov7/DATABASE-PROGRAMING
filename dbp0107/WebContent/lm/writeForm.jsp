<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/main_banner.jsp" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>소모임 등록</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/lm.css' />" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script>
function lmCreate() {
	if (form.littlemeeting_name.value == "") {
		alert("소모임 이름을 입력하십시오.");
		form.littlemeeting_name.focus();
		return false;
	} 
	if (form.title.value == "") {
		alert("소모임 소개를 입력하십시오.");
		form.title.focus();
		return false;
	}
	if (form.contents.value == "") {
		alert("소모임 내용을 입력하십시오.");
		form.contents.focus();
		return false;
	}
	if (form.max_num.value == "0") {
		alert("최소 정원은 0명이상입니다.");
		form.max_num.focus();
		return false;
	}
	
	form.submit();
}

function lmList(targetUri) {
	form.action = targetUri;
	form.submit();
}

</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<!-- registration form  -->
<form name="form" method="POST" action="<c:url value='/littlemeeting/write' />">
  <table style="width: 100%">
    <tr>
      <td width="20"></td>
	  <td>
	  
		 <center><h2>소모임 등록</h2></center>
	    <!-- 커뮤니티 생성이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${creationFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>
	    <table class="table table-bordered" style="margin-left:10%">
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="#e8cdd1"> 소모임 이름</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="littlemeeting_name" 
				 	<c:if test="${creationFailed}">value="${littlemeeting.littlemeeting_name}"</c:if>>
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="#e8cdd1">소모임 소개 </td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="title" 
					<c:if test="${creationFailed}">value="${littlemeeting.title}"</c:if>>
			</td>
		  </tr>	
		  <tr height="40">
			<td width="150" align="center" bgcolor="#e8cdd1">소모임  내용</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="contents" 
					<c:if test="${creationFailed}">value="${littlemeeting.contents}"</c:if>>
			</td>
		  </tr>	 
		  <tr height="40">
			<td width="150" align="center" bgcolor="#e8cdd1">소모임 희망인원</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="max_num" 
					<c:if test="${creationFailed}">value="${littlemeeting.max_num}"</c:if>>
			</td>
		  </tr>	  
	    </table>
	    <br>
	    <table style="width: 100%">
		  <tr>
			<td align="left">
			<input type="button" value="생성" onClick="lmCreate()"> &nbsp;
			<input type="button" value="소모임 목록" onClick="lmList('<c:url value='/littlemeeting/list' />')">
			</td>
		  </tr>
	    </table>
	  </td>
    </tr>
  </table>  
</form>
</body>
</html>