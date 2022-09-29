<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String cv = application.getContextPath();
%>
<link rel="stylesheet" type="text/css" href="<%= cv %>/css/common/common.css">
<header>
	<div>
		<ul class="flex">
			<li>
				<img class="logo" src="<%= cv %>/images/common/logo.png">
			</li>
			<li class="header-menu flex">
				<div>
					<a href="#"><img src="<%= cv %>/images/common/camping.jpg"></a>
					<a href="#">캠핑장</a>
				</div>
				<div>
					<a href="#"><img src="<%= cv %>/images/common/item.jpg"></a>
					<a href="#">캠핑장비</a>
				</div>
				<div>	
					<a href="/reservationList.res"><img src="<%= cv %>/images/common/calendar.png"></a>
					<a href="/reservationList.res">내 예약목록</a>
				</div>
			</li>
			<li>
				<c:if test="${empty name}" > 
					<a href="signup.member">회원가입</a>
					<a href="login.member">로그인</a>
				</c:if>
				<c:if test="${not empty name}">
					<span>${name}님 </span>
					<a href="logout.member">  로그아웃</a>
				</c:if>
			</li>
		</ul>
	</div>
</header>
