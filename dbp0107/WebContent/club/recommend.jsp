<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/main_banner.jsp"%> 
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

<style>

a.but {
	width:100px;
    background-color: #a1304e;
    border: none;
    color:#fff;
    padding: 15px 0;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px;
    cursor: pointer;
    	text-align: center;
	font size: 3.0em;
}

a.but:hover{
  background:#fff;
  color:#a13042;
}
a.but:before,a.but:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #a13042;
  transition:400ms ease all;
}
a.but:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
a.but:hover:before,a.but:hover:after{
  width:100%;
  transition:800ms ease all;
}




</style>


</head>

<header class="masthead">
  <div class="container h-50">
    <div class="row h-100 align-items-center">
      <div class="col-12 text-center">
        <h1 class="font-weight-light">'${customerId}'님을 위한 추천 동아리입니다</h1>

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
					<td scope="col" width="100" align="center" scope="col" bgcolor="#F1E1E3">동아리명</th>
					<td scope="col" width="200" align="center" scope="col" bgcolor="#F1E1E3">제목</th>
				</tr>
				<c:forEach var="club" items="${clubList}">
					<tr >				<!-- 동아리명 클릭시 /club/detail로 넘어감 -->
	
						<td width="100"  align="center" bgcolor="FFFFFF" style="padding-left: 10" height="20">
							<a href="<c:url value='/club/detail'>
						    		 <c:param name='club_no' value='${club.club_no}'/>
						 			 </c:url>"> 
				  			${club.club_name}</a>
						</td>
						<td width="200"  align="center" align="center" bgcolor="FFFFFF">
							${club.title}
						</td>
					</tr>	
				</c:forEach>
			</table> 
			 

			 <div class="my text-right">
			 <a class= "but" href="<c:url value='/club/list' />">동아리 더보기</a>
			 <a class= "but" href="<c:url value='/club/create/form' />">동아리 만들기</a>
			 </div>
			
			
		
		</td>
	</tr>			
</table>
</body>
</html>