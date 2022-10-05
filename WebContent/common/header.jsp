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
				<a href="<%= cv %>"><img class="logo" src="<%= cv %>/images/common/logo.png"></a>
			</li>
			<li class="header-menu flex">
				<div>
					<a href="campingList.camping"><img src="<%= cv %>/images/common/camping.png"></a>
					<a href="campingList.camping">캠핑장</a>
				</div>
				<div>
					<a href="itemList.item"><img src="<%= cv %>/images/common/item.png"></a>
					<a href="itemList.item">캠핑장비</a>
				</div>
				<div>	
					<a href="reservationDetail.res"><img src="<%= cv %>/images/common/calendar.png"></a>
					<a href="reservationDetail.res">내 예약목록</a>
				</div>
			</li>
			<li>
				<c:if test="${empty name}" > 
					<a href="signup.member">회원가입</a>
					<a href="login.member">로그인</a>
				</c:if>
				<c:if test="${not empty name}">
					<span style="color: white">${name}님 </span>
					<a href="logout.member">  로그아웃</a>
				</c:if>
			</li>
		</ul>
	</div>
</header>
