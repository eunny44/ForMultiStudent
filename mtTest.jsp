<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.mme.realMulti.dto.Locker" %>
<%@ page import = "com.mme.realMulti.dto.MT" %>
<%@ page import = "javax.servlet.http.HttpSession" %>
<%@ page import = "java.sql.Timestamp" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE HTML>
<!--
	Verti by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>MT 신청</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="resources/assets/css/main.css" />
		<link rel="stylesheet" href="resources/assets/css/myboot.css"/>
		<link rel="stylesheet" href="resources/assets/css/mt_namgwang.css"/>
		<!--
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		-->
		
		<!-- 200721 jquery 관련 -->			
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>			
	</head>
	
	<body class="is-preload no-sidebar">
	
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">

						<!-- Logo -->
						<div id="logo">
							<a href="index.html">
								<img src="resources/images/logo.png" alt="My Image" width="350" height="100">
							</a>
						</div>

						<!-- Nav -->
						<nav id="nav">
							<ul>							
								<li>
									<a href="index.html">공지사항</a>
								</li>
								<li class="current">
									<a href="#">신청</a>
									<ul>											
										<li><a href="locker">사물함 신청</a></li>
										<li><a href="mt">MT 신청</a></li>											
									</ul>
								</li>
								<li><a href="left-sidebar.html">건의사항</a></li>
								<li><a href="right-sidebar.html">자유게시판</a></li>
								<!-- class="current" 이면 검은색으로 되는 것 같은데. 
									하면서 느끼는건데 이거.. 되게 바꾸면서 난리 엄청 날 것 같음 ㅋㅋㅋ..
								-->
								<li class="login">								
									<c:choose>
									    <c:when test="${sessionScope.isLogin== 'true'}">
											<a href="#">${sessionScope.loginedStudentName}</a>
											<ul>
												<li><a href="mypage">마이페이지</a></li>
												<li><a href="logout">로그아웃</a></li>
											</ul>																							
										</c:when>
									    <c:otherwise>
									    	<button type="button" class="btn btn-primary" style="background: #3A3A3A; border-color: #3A3A3A;" data-toggle="modal" data-target="#myModal">
 												Login
											</button>													
									        <!-- <a href="loginform">로그인</a> -->								      
									    </c:otherwise>
									</c:choose>							
								</li>
							</ul>
						</nav>
					</header>
				</div>

			<!-- Footer -->
            <div id="footer-wrapper" style="text-align: center">
               <footer id="footer" class="container">
                  <div class="row">             
                     <div class="col-12">
                        <div class="hr-sect"><img src="resources/images/ele.svg"></div><br>
                     </div>
                  </div>
                  <div class="row">
                     <div class="col-4 col-6-medium col-12-small">
                        <!-- Links -->
                           <section class="widget links">
                              <h3>학과 Info.</h3>
                              <ul class="style2">
                                 <li><a href="#">번호 : 02-2260-8760</a></li>
                                 <li><a href="#">주소 : (변경예정)</a></li>
                              </ul>
                           </section>
                     </div>
                     
                     <div class="col-4 col-6-medium col-12-small">
                        <!-- Links -->
                           <section class="widget links">
                              <h3>학생회 Info.</h3>
                              <ul class="style2">
                                 <li><a href="#">학생회장 : 010-9215-5644</a></li>
                                 <li><a href="#">부학생회장 : 010-5620-2869</a></li>
                                 <li><a href="#">과실 위치 : 원흥관 2층 E267</a></li>
                              </ul>
                           </section>
                     </div>
                     <div class="col-4 col-6-medium col-12-small">

                        <!-- Links -->
                           <section class="widget links">
                              <h3>SNS</h3>
                              <ul class="style2">
                                 <li><a href="https://ko-kr.facebook.com/people/%EB%8F%99%EA%B5%AD%EB%A9%80%ED%8B%B0/100006257864438">facebook</a></li>
                                 <li><a href="https://cafe.naver.com/dgumulti">naver cafe</a></li>
                                 <li><a href="https://pf.kakao.com/_HQVud">kakao</a></li>
                              </ul>
                           </section>
                     </div>
                  </div>
                  <div class="row">
                     <div class="col-12">
                        <div id="copyright">
                           <ul class="menu">
                              <li>&copy; Untitled. All rights reserved</li>
                              <li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
                              <li>Font : <a href="https://noonnu.cc/font_page/407">tt투게더</a></li>
                              <li>Develop: 류남광, 박은희, 최정선, 최희수</li>
                              <li>Thanks to : 백민주</li>
                           </ul>
                        </div>
                     </div>
                  </div>
               </footer>
            </div>   
		</div><!-- 맨 처음입니다.-->

		<!-- Scripts -->
			<script src="resources/assets/js/jquery.min.js"></script>
			<script src="resources/assets/js/jquery.dropotron.min.js"></script>
			<script src="resources/assets/js/browser.min.js"></script>
			<script src="resources/assets/js/breakpoints.min.js"></script>
			<script src="resources/assets/js/util.js?ver=123"></script>
			<script src="resources/assets/js/main.js"></script>
	
	    	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	    	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	   		<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	</body>
</html>
