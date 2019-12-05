<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>로그인</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">
<script>
function login() {
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
	form.submit();
}

function customerCreate(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
<style>
	div{
		margin-left: 25%;
	}
	body {
 position: absolute;
 width: 500px;
 height: 500px;
 left: 50%;
 top: 50%;
 margin-left: -250px;
 margin-top: -250px;
	}
</style>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<!-- login form  -->
  <table style="width:100%">
<form name="form" method="POST" action="<c:url value='/customer/login' />">
	<tr>
	  <td width="20"></td>
	  <td>
	    <table>

	    </table>  
	    <!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${loginFailed}">
	  	  <br><font color="red"><c:out value="${exception.getMessage()}" /></font><br>
	    </c:if>
	    <br>	  
	    
	    	  <td>
		<a href="http://cs.dongduk.ac.kr">
		  <img src="<c:url value='/images/logo.png' />" /></a>		
	  </td>
	  
	  <div class="big">
	    <table class="table">
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="#F1E1E3">사용자 ID</td>
			<td width="250" bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:240" name="customerId">
			</td>
		  </tr>
	  	  <tr height="40">
			<td width="150" align="center" bgcolor="#F1E1E3">비밀번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left:10">
				<input type="password" style="width:240" name="password">
			</td>
		  </tr>
	    </table>
	    

		</div>
		 
	<tr height="100"><td>&nbsp;</td>

	</tr>
</form>

<!-- GET방식으로 버튼을 보내고 싶기 때문에 form태그 밖으로 빼옴  -->
	<div class="my">
		<input type="button" value="로그인"  class="btn btn-outline-danger" onClick="login()"> &nbsp;
					<!-- button태그를 감싸는 a태그 -->
		<a  href="<c:url value='/customer/register/form' />"><input type="button" value="회원가입" class="btn btn-outline-danger"></a>
	</div>
	
 </table>

		
</body>
</html>