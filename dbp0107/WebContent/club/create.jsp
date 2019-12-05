<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>동아리 생성</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">
<script>
function clubCreate() {
	if (form.club_name.value == "") {
		alert("동아리 이름을 입력하십시오.");
		form.club_name.focus();
		return false;
	} 
	if (form.title.value == "") {
		alert("제목을 입력하십시오.");
		form.title.focus();
		return false;
	}
	if (form.contents.value == "") {
		alert("내용을 입력하십시오.");
		form.contents.focus();
		return false;
	}
	form.submit();
}

function clubList(targetUri) {
	form.action = targetUri;
	form.submit();
}


</script>
</head>

<header class="masthead">
  <div class="container h-50">
    <div class="row h-100 align-items-center">
      <div class="col-12 text-center">
        <h1 class="font-weight-light">동아리 생성</h1>
        <!-- <p class="lead">A great starter layout for a landing page</p> -->
      </div>
    </div>
  </div>
</header>

<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>


<form name="form" method="POST" action="<c:url value='/club/create' />">
<div class="form-group">
	<!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
	<table class="table table-bordered" style="margin-left:10%; margin-right:10%">
	<c:if test="${registerFailed}">
		<font color="red"><c:out value="${exception.getMessage()}" /></font>		
	</c:if>
		<tr height="40">
			<td width="100" align="center" bgcolor="#e8cdd1">학과 선택</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
 		<%-- 	<input type="text" style="width: 240" name="commId" 
 					value="<c:if test="${user.commId!=0}">${user.commId}</c:if>"> --%>	 
			 	<select class="form-control" name="department_no" style="width: 240">
					<option value="0">없음</option>
					<c:forEach var="department" items="${departList}">
						<option value="${department.department_no}"
							>${department.dept_name}</option>
					</c:forEach>
				</select>
			</td>
		  </tr>	  
		
		<tr height="40">
			<td width="100" align="center" bgcolor="#e8cdd1"> 동아리 이름</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" class="form-control"  style="width: 300" name="club_name"
					<c:if test="${creationFailed}">value="${club.club_name}"</c:if>>
			</td>
		</tr>
		<tr height="40">
			<td width="100" align="center" bgcolor="#e8cdd1"> 제목</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" class="form-control"  style="width: 450" name="title"
					<c:if test="${creationFailed}">value="${club.title}"</c:if>>
			</td>
		</tr>
		<tr height="40">
			<td width="100" align="center" bgcolor="#e8cdd1"> 내용</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<textarea type="text"  class="form-control" style="width: 450; height: 200; " name="contents"				
					<c:if test="${creationFailed}">value="${club.contents}"</c:if>></textarea>
			</td>
		</tr>
		
	
		
		
	</table>
	<br>
	<table style="width: 100%">
		<tr>
			<td align="center">
			<input type="button"  class="btn btn-outline-danger btn-lg" value="생성" onClick="clubCreate()"> &nbsp;
			</td>
		</tr>
	</table>
	</div>
</form>


</body>
</html>