<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>소모임 목록</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/lm.css' />" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table style="width:100%">
  <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
  <tr>
	<td width="20"></td>
	<td>
	  <table>
		<tr>
		  <td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>소모임 목록</b>&nbsp;&nbsp;</td>
		</tr>
	  </table>  
	  <br>		  
	  <table style="background-color: YellowGreen">
		<tr>		
		  <td width="190" align="center" bgcolor="E6ECDE" height="22">소모임 번호</td>
		  <td width="200" align="center" bgcolor="E6ECDE">소모임 이름</td>
		  <td width="200" align="center" bgcolor="E6ECDE">작성날짜</td>
		  <td width="200" align="center" bgcolor="E6ECDE">현재 정원</td>
		  <td width="200" align="center" bgcolor="E6ECDE">최대 정원</td>
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
	  <br>   
	  <a href="<c:url value='/littlemeeting/write/form' />">소모임 등록</a>
	</td>
  </tr>
</table>  
</body>
</html>