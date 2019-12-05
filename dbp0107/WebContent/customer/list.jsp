<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	@SuppressWarnings("unchecked") 
	List<Customer> customerList = (List<Customer>)request.getAttribute("customerList");
	String curCustomerId = (String)request.getAttribute("curCustomerId");
--%>
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">
</head>

<header class="masthead">
  <div class="container h-50">
    <div class="row h-100 align-items-center">
      <div class="col-12 text-center">
        <h1 class="font-weight-light">사용자 관리</h1>
        <p class="lead">사용자 리스트입니다. 이름을 클릭시 상세한 정보를 볼 수 있습니다.</p>
      </div>
    </div>
  </div>
</header>

<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table style="width:80%">
  <tr>
  	<td width="20"></td>
    <td><a href="<c:url value='/customer/logout' />">로그아웃(&nbsp;${curCustomerId}&nbsp;)</a></td>
  </tr>
  <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
  <tr>
	<td width="20"></td>
	<td> 
	  <br>		  
	  <table  class="table table-bordered" style="margin-left:10%">
		<tr>
		  <td width="120" align="center" bgcolor="#F1E1E3" height="22">사용자 ID</td>
		  <td width="100" align="center" bgcolor="#F1E1E3">이름</td>
		  <td width="200" align="center" bgcolor="#F1E1E3">이메일</td>
		</tr>
<%-- 
	if (customerList != null) {	
	  Iterator<Customer> customerIter = customerList.iterator();
	
	  //사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
	  while ( customerIter.hasNext() ) {
		Customer customer = (Customer)customerIter.next();
--%>	  	
	  <c:forEach var="customer" items="${customerList}">  			  	
  		<tr>
		  <td width="120" align="center" bgcolor="ffffff" height="20">
		  	${customer.customerId}       <%-- <%=customer.getCustomerId()%> --%>
		  </td>
		  <td width="100" align="center" bgcolor="ffffff" style="padding-left: 10">
			<a href="<c:url value='/customer/view'>
					   <c:param name='customerId' value='${customer.customerId}'/>
			 		 </c:url>">
			  ${customer.name}</a>	 <%-- <%=customer.getName()%></a> --%>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${customer.email}        <%-- <%=customer.getEmail()%> --%>
		  </td>
		  </td>
		</tr>
	  </c:forEach> 
<%--
	  }
	}
--%>	 
	  </table>	  	 
	  <br>   
	  <a style="padding-left: 50%" href="<c:url value='/customer/register/form' />">
	  	<input type="button" value="사용자 추가" class="btn btn-outline-danger btn-lg">
	  </a>	
	  <br>   
	</td>
  </tr>
</table>  
</body>
</html>
