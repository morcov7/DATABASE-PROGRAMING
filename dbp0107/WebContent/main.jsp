<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
    	<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding&display=swap" rel="stylesheet">
        <title>동덕여대 신입생 홈페이지</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="vkoiewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <style>
            .container{
                padding-top: 60px;
            }
           /*  body {
            	font-family: 'Do Hyeon', sans-serif;
            } */
        </style>
        <link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet">
    </head>
    <body>
        <script src="<c:url value='/js/jquery-3.4.1.slim.min.js' />"></script>
        <script src="<c:url value='/js/bootstrap.min.js' />"></script>
        <nav class="navbar navbar-expand-lg bg-light navbar-light">
                <!-- 학교 로고 클릭 시 메인홈화면으로 이동 -->
                <a class="navbar-brand" href="<c:url value='main.jsp' />"><img src="<c:url value='/images/logo_white.png' />" /></a>
                <!-- 토글러 버튼 만들기 -->
                <button class="navbar-toggler" type="button" 
                data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                                                <!-- data-target -->
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
						<li class="nav-item">
                            <a class="nav-link" href="<c:url value='/view/testMain' />">학과</a>
                        </li>                       
                     
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/club/recommend' />">동아리</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/littlemeeting/list' />">소모임</a>
                        </li>
                        
                    </ul>
                    
                </div>
            </nav>
            <div class="container">
                <div class="row">
                    
                <div class="col-md-12">
                    <!-- Jumbotron -->
                    <div class="jumbotron">
                        <h1 class="display-4" align="center"><img src="<c:url value='/images/somsom.png' />" width="500" height="500"/></h1>
                        <p class="lead">
                         <br> 
                       		동덕여자대학교 입학을 축하합니다 !
                        </p>
                        <hr class="my-4">
                        <p class="lead">
                        		
                        		동덕여대 신입생을 위한 홈페이지 입니다.
                        </p>
                        <!-- <a class="btn btn-primary btn-lg" href="#" role="button">
                            Learn More
                        </a> -->
                    </div>
                        
                    
                  </div>
                </div>            
            </div>
    </body>
</html>