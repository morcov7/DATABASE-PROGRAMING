<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/main_banner.jsp" %> 
<%@include file = "/view/department/main.jsp"%>   
<html>
<head>
<title>소모임 목록</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel=stylesheet href="<c:url value='/css/lm.css' />" type="text/css">
<style>

a.meeing {
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

a.meeing:hover{
  background:#fff;
  color:#a13042;
}
a.meeing:before,a.meeing:after{

  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #a13042;
  transition:400ms ease all;
}
a.meeing:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
a.meeing:hover:before,a.meeing:hover:after{
  width:100%;
  transition:800ms ease all;
}

</style>
</head>
<header class="masthead">
  <div class="container h-50">
    <div class="row h-100 align-items-center">
      <div class="col-12 text-center">
        <h1 class="font-weight-light">소모임</h1>

      </div>
    </div>
  </div>
</header>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table style="width:85%">
  <tr>
	<td width="20"></td>
	<td>		  
	
	  <table class="table table-bordered" style="margin-left:10%">
		<tr>		
		  <td width="190" align="center" bgcolor="#e8cdd1" height="22">소모임 번호</td>
		  <td width="200" align="center" bgcolor="#e8cdd1">소모임 이름</td>
		  <td width="200" align="center" bgcolor="#e8cdd1">작성날짜</td>
		  <td width="200" align="center" bgcolor="#e8cdd1">현재 정원</td>
		  <td width="200" align="center" bgcolor="#e8cdd1">최대 정원</td>
		</tr>	  	
	  <c:forEach var="littlemeeting" items="${lmList}">  			  	
  		<tr>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${littlemeeting.littlemeeting_no}      
		  </td>
		  <td width="200" bgcolor="ffffff" style="padding-left: 10">
			<a href="<c:url value='/littlemeeting/detail'>
					   <c:param name='littlemeeting_no' value='${littlemeeting.littlemeeting_no}'/>
			 		 </c:url>">
			  ${littlemeeting.littlemeeting_name}</a>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${littlemeeting.createtime}
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${littlemeeting.count}
		  </td>
		   <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${littlemeeting.max_num}
		  </td>
		</tr>
	  </c:forEach> 
	  </table>	
	  <div class="meei text-right" >
	  <a class="meeing" href="<c:url value='/littlemeeting/write/form' />">소모임 등록</a></div>  	 
	  <br>  
	</td>
  </tr>
</table>  
</body>
</html>