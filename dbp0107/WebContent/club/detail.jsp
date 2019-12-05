<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/main_banner.jsp"%> 
<html>
<head>
<title>동아리 세부정보</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel=stylesheet href="<c:url value='/css/customer.css' />" type="text/css">
<script>
	function clubRemove(){
		return confirm("정말 삭제하시겠습니까?");
	}
</script>
<style>
div.my {
	margin-left: 50%;
}

</style>

</head>


<header class="masthead">
  <div class="container h-50">
    <div class="row h-100 align-items-center">
      <div class="col-7 text-center">
        <h1 class="font-weight-light">동아리 관련 정보입니다.</h1>
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
	  <dt class="col-sm-3">동아리명</dt>
	  <dd class="col-sm-9">${club.club_name}</dd>
	
	  <dt class="col-sm-3">학과명</dt>
	  <dd class="col-sm-9">${club.dept_name}</dd>
	  	
	  <dt class="col-sm-3">제목</dt>
	  <dd class="col-sm-9">${club.title}</dd>
	  	
	  <dt class="col-sm-3">내용</dt>
	  <dd class="col-sm-9">${club.contents}</dd>
	  	  	
	  <dt class="col-sm-3">개설일자</dt>
	  <dd class="col-sm-9">${club.createtime} </dd>
  </dl>
  
  	   <div class="my">
 	    <a href="<c:url value='/club/delete' >
 	    		 <c:param name='club_no' value='${club.club_no}' />
 	    		 </c:url>">
 	    	<input type="button" value="삭제" class="btn btn-danger" onclick="return clubRemove();">
 	    </a> &nbsp;
 	    <a href="<c:url value='/club/list' />">
 	    	<input type="button" value="목록" class="btn btn-dark">
 	    </a>  	    
 	    <br><br>	   
 	    </div>
  </table>
</body>
</html>