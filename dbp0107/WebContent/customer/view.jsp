<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.Customer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Customer customer = (Customer)request.getAttribute("customer");
%>
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">
<script>
function customerRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
</script>
<style>
div{
	margin-left: 25%;
}

</style>

</head>

<header class="masthead">
  <div class="container h-50">
    <div class="row h-100 align-items-center">
      <div class="col-4 text-center">
        <h1 class="font-weight-light">사용자 상세</h1>
        <p class="lead">삭제와 수정이 가능합니다.</p>
      </div>
    </div>
  </div>
</header>

<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
  <br>
  <table style="width:100%">
    <tr>
	  <td width="20"></td>
	  <td>  
	    <br>	  	    
<dl class="row" style="margin-left:10%">
	  <dt class="col-sm-3">사용자 ID</dt>
	  <dd class="col-sm-9">${customer.customerId}</dd>
	
	  <dt class="col-sm-3">이름</dt>
	  <dd class="col-sm-9">${customer.name}</dd>
	  	
	  <dt class="col-sm-3">이메일 주소</dt>
	  <dd class="col-sm-9">${customer.email}</dd>
	  	
	  <dt class="col-sm-3">전화번호</dt>
	  <dd class="col-sm-9">${customer.phone}</dd>
	  
	  	  <dt class="col-sm-3">학과</dt>
	  <dd class="col-sm-9">${customer.dept_name}</dd>

  </dl>
	    <br>
	    
	    <div>
	    <a href="<c:url value='/customer/update/form'>
	     		   <c:param name='customerId' value='<%=customer.getCustomerId()%>'/>
			 	 </c:url>"><input type="button" value="수정" class="btn btn-warning">
		</a> &nbsp;
 	    <a href="<c:url value='/customer/delete'>
				   <c:param name='customerId' value='<%=customer.getCustomerId()%>'/>
			 	 </c:url>" onclick="return customerRemove();"><input type="button" value="삭제" class="btn btn-danger">
		</a> &nbsp;
 	    <a href="<c:url value='/customer/list' />">
 	    	<input type="button" value="목록" class="btn btn-dark">
 	    </a> 	    
 	    <br><br>	   
 	    </div>
 	    
 	    <!-- 수정 또는 삭제가  실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${updateFailed || deleteFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>    
	  </td>
	</tr>
  </table>  
</body>
</html>