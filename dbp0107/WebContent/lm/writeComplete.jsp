<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>소모임 상세정보</title>
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
		  <td width="190" align="center" bgcolor="E6ECDE" height="22">소모임 이름</td>
		  <td width="200" align="center" bgcolor="E6ECDE">소모임 소개</td>
		  <td width="200" align="center" bgcolor="E6ECDE">소모임 내용</td>
		  <td width="200" align="center" bgcolor="E6ECDE">작성 시간</td>
		  <td width="200" align="center" bgcolor="E6ECDE">현재 정원</td>
		  <td width="200" align="center" bgcolor="E6ECDE">최대 정원</td>
		</tr>	  	
	  <c:forEach var="lm" items="${lmList}">  			  	
  		<tr>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${lm.littlemeeting_name}      
		  </td>
		  	  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${lm.title}      
		  </td>
		  	  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${lm.contents}      
		  </td>
		  	  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${lm.createtime}      
		  </td>
		  	  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${lm.count}      
		  </td>
		  	  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${lm.createtime}      
		  </td>
		  	<td width="200" align="center" bgcolor="ffffff" height="20">
		    ${lm.count}
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${lm.max_num}
		  </td>
		</tr>
	  </c:forEach> 	 
	  </table>	  	 
	  <tr>
	  <table style="width: 100%">
		  <tr>
			<td align="left">
				<input type="button" value="글 삭제" onClick="userCreate('<c:url value='/user/register/form' />')">
			</td>
		  </tr>
	    </table>
  	</tr>
	</table>  
</body>
</html>