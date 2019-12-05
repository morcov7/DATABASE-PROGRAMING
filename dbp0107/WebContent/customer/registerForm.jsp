<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">
<script>
function customerCreate() {
	if (form.customerId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.customerId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}
	if (form.password.value != form.password2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.name.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("이메일 형식이 올바르지 않습니다.");
		form.email.focus();
		return false;
	}
	var phoneExp = /^\d{2,3}\d{3,4}\d{4}$/;
	if(phoneExp.test(form.phone.value)==false) {
		alert("전화번호 형식이 올바르지 않습니다.");
		form.phone.focus();
		return false;
	}
	form.submit();
}

function customerList(targetUri) {
	form.action = targetUri;
	form.submit();
}

</script>
</head>

<header class="masthead">
  <div class="container h-50">
    <div class="row h-100 align-items-center">
      <div class="col-12 text-center">
        <h1 class="font-weight-light">회원 가입</h1>
        <!-- <p class="lead">A great starter layout for a landing page</p> -->
      </div>
    </div>
  </div>
</header>

<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>	
<!-- 화면 로드 시 서버로부터 커뮤니티 목록을 가져와 commSelect 메뉴 생성 -->
<br>
<!-- registration form  -->
<form name="form" method="POST" action="<c:url value='/customer/register' />">
<div class="form-group">
  <table class="table table-bordered" style="margin-left:10%; margin-right:10%">
	    <!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${registerFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>	  
	    <tr height="40">
			<td width="100" align="center" bgcolor="#e8cdd1">학과 선택</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10"> 
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
			<td width="100" align="center" bgcolor="#e8cdd1">사용자 ID</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" class="form-control"  style="width: 240;" name="customerId">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="100" align="center" bgcolor="#e8cdd1">비밀번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="password"  class="form-control" style="width: 240" name="password">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="100" align="center" bgcolor="#e8cdd1">비밀번호 확인</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="password" class="form-control"  style="width: 240" name="password2">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="100" align="center" bgcolor="#e8cdd1">이름</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" class="form-control"  style="width: 240" name="name" 
				 	<c:if test="${registerFailed}">value="${customer.name}"</c:if>>
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="100" align="center" bgcolor="#e8cdd1">이메일 주소</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" class="form-control"  style="width: 240" name="email" 
					<c:if test="${registerFailed}">value="${customer.email}"</c:if>>
			</td>
		  </tr>	
	  	  <tr height="40">
			<td width="100" align="center" bgcolor="#e8cdd1">전화번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" class="form-control"  style="width: 240" name="phone" 
					<c:if test="${registerFailed}">value="${customer.phone}"</c:if>>
			</td>
		  </tr>
		
	    </table>
	    <br>
	    <table style="width: 100%">
		  <tr>
			<td align="center">
			<input type="button" class="btn btn-outline-danger btn-lg" value="회원 가입" onClick="customerCreate()"> &nbsp;
			<input type="button" class="btn btn-outline-danger btn-lg" value="목록" onClick="customerList('<c:url value='/customer/list' />')">
			</td>
		  </tr>
	    </table>
</div>
</form>
</body>
</html>
