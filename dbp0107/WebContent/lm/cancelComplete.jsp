<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file = "/main_banner.jsp"%> 
<%@include file = "/view/department/main.jsp"%>   

<html>
<head>
<title>소모임 신청완료</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%-- <link rel=stylesheet href="<c:url value='/css/lm.css' />" type="text/css">
 --%>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
  content:'';
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
 <body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
  <br>
  
  <center>
  <h2>소모임 신청</h2>
  </center>
  <br>
  <br>
  
  <dl class="row" style="margin-left:10%">

     <dt class="col-sm-3">신청상태</dt>
     <dd class="col-sm-9">신청이 취소되었습니다.</dd>     
  </dl>
  
  <br>
  <div class="meeing text-right" > 
   <a class="meeing" href="<c:url value='/littlemeeting/list'>
     		 </c:url>">목록</a>
  </div>
</body>
</html>