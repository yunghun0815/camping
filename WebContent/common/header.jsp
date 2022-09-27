<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String cv = application.getContextPath();
%>
<link rel="stylesheet" type="text/css" href="../css/common/common.css">
<style>
	*{
		box-sizing: border-box;
	}
	ul, ol, li{
		list-style: none;
	}
	a{
		text-decoration: none;
		color: black;
	}
	.flex{
		display: flex;
	}
	header{
		border-bottom: 1px solid #ddd;
		height: 80px;
	}
	header>div{
		width: 1400px;
		margin: 0 auto;
	}
	header .logo{
		width: 140px;
	}
	header>div ul{
		position: relative;	
	}
	header>div ul li{
		line-height: 65px;
	}
	header>div ul li:last-child {
	    position: absolute;
    	left: 1230px;
	    color:#222222;
    	font-weight: bold;
	}
	header>div ul li:last-child a:first-child{
		margin-right: 20px;
	}
	header .header-menu{
		position: relative;
    	left: 200px;
	}
	header .header-menu>div{
		display: inline-block;
	    margin: 0 70px;
	    text-align: center;
	}
	header .header-menu img{
		width: 30px;
	    margin-top: 8px;
	}
	header .header-menu div a:last-child{
	    position: relative;
    	bottom: 15px;
    	color: #333;
    	font-weight: bold;
	}
}
</style>
<header>
	<div>
		<ul class="flex">
			<li>
				<img class="logo" src="<%= cv %>/images/common/logo.png">
			</li>
			<li class="header-menu flex">
				<div>
					<a href="#"><img src="<%= cv %>/images/common/camping.jpg"></a><br>
					<a href="#">캠핑장</a>
				</div>
				<div>
					<a href="#"><img src="<%= cv %>/images/common/item.jpg"></a><br>
					<a href="#">캠핑장비</a>
				</div>
				<div>	
					<a href="#"><img src="<%= cv %>/images/common/calendar.png"></a><br>
					<a href="#">내 예약목록</a>
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
