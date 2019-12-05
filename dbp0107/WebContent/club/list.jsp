<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@include file = "/main_banner.jsp"%>  --%>
<%-- <%
	@SuppressWarnings("unchecked") 
	List<Community> commList = (List<Community>)request.getAttribute("commList");
%> --%>
<html>
<head>
<title>동아리 리스트</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">
</head>


<header class="masthead">
  <div class="container h-50">
    <div class="row h-100 align-items-center">
      <div class="col-12 text-center">
        <h1 class="font-weight-light">동아리 리스트</h1>
        <!-- <p class="lead">A great starter layout for a landing page</p> -->
      </div>
    </div>
  </div>
</header>



<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table style="width:85%">
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr>
		<td width="20"></td>
		<td>
			<br>
			<table class="table table-bordered" style="margin-left:10%">
				<tr>
					<td width="10" align="center" bgcolor="#F1E1E3">번호</td>
					<td width="100" align="center" bgcolor="#F1E1E3">동아리명</td>
					<td width="100" align="center" bgcolor="#F1E1E3">학과명</td>
				</tr>
				<c:forEach var="club" items="${clubList}">
					<tr>				<!-- 동아리명 클릭시 /club/detail로 넘어감 -->
						<td width="10"  align="center" bgcolor="FFFFFF" style="padding-left: 10" height="20">
				  			${club.club_no}
						</td>
						<td width="100"  align="center" bgcolor="FFFFFF" style="padding-left: 10">
							<a href="<c:url value='/club/detail'>
						    		 <c:param name='club_no' value='${club.club_no}'/>
						 			 </c:url>">
							  ${club.club_name}</a>
						</td>
						<td width="100" align="center" bgcolor="FFFFFF">
							${club.dept_name}
						</td>
					</tr>	
				</c:forEach>
			</table>
			 <br>   
		</td>
	</tr>

</table>
</body>
</html>